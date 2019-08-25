package com.project.taste.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.taste.bo.Article_Content;
import com.project.taste.model.Article;
import com.project.taste.model.Content;
import com.project.taste.service.ArticleService;
import com.project.taste.service.ContentService;
import com.project.taste.util.Constants;
import com.project.taste.util.HttpClientHelper;
import com.project.taste.util.JsonResult;
import com.project.taste.util.ListPageUtil;
import io.swagger.annotations.Api;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
@Api(tags = "文章控制器")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    ContentService contentService;
    @Autowired
    SolrClient solrClient;

    //增量
    String deltaImport = "http://106.13.207.98:9091/solr/taste/dataimport?command=delta-import&verbose=false&clean=false&commit=true&optimize=false&core=taste&name=dataimport";

    //全量
    String fullImport = "http://106.13.207.98:9091/solr/taste/dataimport?command=full-import&verbose=false&clean=true&commit=true&optimize=false&core=taste&name=dataimport";

    /**
     * 查询所有文章（带分页）
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryall")
    public JsonResult queryAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        JsonResult js;
        try{
            String update = HttpClientHelper.sendPost(deltaImport);
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setRows(pageNum*pageSize);
            solrQuery.setQuery("*:*");
            QueryResponse response = solrClient.query(solrQuery);
            List list = new ArrayList<>();
            SolrDocumentList results = response.getResults();
            for (SolrDocument obj : results){
                System.out.println(obj);
                list.add(obj);
            }
            ListPageUtil listPageUtil = new ListPageUtil(list,pageNum,pageSize);
            if(results.size()>0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",listPageUtil);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"暂无数据");
            }
        }catch (Exception e){
            e.printStackTrace();
            js = new JsonResult(Constants.STATUS_ERROR,"暂无数据");
        }
        return js;
    }

    /**
     * 根据文章标题查询文章（带分页）
     * @param article
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/querybytitle")
    public JsonResult queryByTitle(Article article, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        JsonResult js;
        try{
            HttpClientHelper.sendPost(deltaImport);
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setRows(pageNum*pageSize);
            solrQuery.set("q", article.getArticleTitle());
            //默认域
            solrQuery.set("df", "articleTitle");
            //高亮
            //打开开关
            solrQuery.setHighlight(true);
            //指定高亮域
            solrQuery.addHighlightField("articleTitle");
            //设置前缀
            solrQuery.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            solrQuery.setHighlightSimplePost("</span>");
            QueryResponse response = solrClient.query(solrQuery);
            Map<String, Map<String, List<String>>> highlight = response.getHighlighting();
            List<Map<String, Object>> list = new ArrayList<>();
            SolrDocumentList results = response.getResults();
            for (SolrDocument obj : results){
                obj.put("highlight",highlight.get(obj.get("id")));
                list.add(obj);
            }
            ListPageUtil listPageUtil = new ListPageUtil(list,pageNum,pageSize);
            if(results.size()>0 && results!=null){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",listPageUtil);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"暂无数据");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"暂无数据");
        }
        return js;
    }

    /**
     * 根据类别ID查询所有文章
     * @param pageNum
     * @param pageSize
     * @param articleCategoryId
     * @return
     */
    @ResponseBody
    @RequestMapping("/query/categoryid")
    public JsonResult selectByCategory(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, String articleCategoryId){
        JsonResult js;
        try{
            PageHelper.startPage(pageNum, pageSize);
            List<Article> list = articleService.selectByCategoryId(articleCategoryId);
            PageInfo pageInfo = new PageInfo(list);
            if(list.size()>0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",pageInfo);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"暂无数据");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }

    /**
     * 根据文章ID查文章详情+内容
     * @param articleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/query/articleid")
    public JsonResult selectByArticleid(String articleId){
        JsonResult js;
        try {
            Article article = articleService.selectByPrimaryKey(articleId);
            List<Content> list = contentService.selectByArticleId(articleId);
            if(article!=null && list.size()>0){
                Article_Content article_content = new Article_Content();
                article_content.setArticleId(article.getArticleId());
                article_content.setArticleCategoryId(article.getArticleCategoryId());
                article_content.setArticleStatus(article.getArticleStatus());
                article_content.setArticleTime(article.getArticleTime());
                article_content.setArticleTitle(article.getArticleTitle());
                article_content.setArticleUserId(article.getArticleUserId());
                article_content.setList(list);
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",article_content);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL,"查询异常");
        }
        return js;
    }

    /**
     * 根据文章ID删除文章（修改状态）
     * @param articleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult deleteArticle(String articleId){
        JsonResult js;
        try{
            int i = articleService.deleteByArticleId(articleId);
            if(i!=0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"删除成功",i);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"删除失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"删除异常");
        }
        return js;
    }

    /**
     * 添加文章
     */
    @ResponseBody
    @RequestMapping("/insert")
    public JsonResult insertArticle(Article article){
        JsonResult js;
        try{
            int i = articleService.insertSelective(article);
            if(i!=0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"添加成功",i);

            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"添加失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"添加异常"+e.getMessage());
        }
        return js;
    }

    /**
     * 修改文章
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult updateArticle(Article article){
        JsonResult js;
        try{
            int i = articleService.updateByPrimaryKeySelective(article);
            if(i!=0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"修改成功",i);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"修改失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"修改异常");
        }
        return js;
    }

    /**
     * 查询文章数量
     */
    @ResponseBody
    @RequestMapping("/select/num")
    public JsonResult selectArticleNum(){
        JsonResult js;
        try{
            int i = articleService.selectArticleNum();
            js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",i);
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }

    /**
     * 根据日期查数量
     * @return
     */
    @ResponseBody
    @RequestMapping("/select/bytime")
    public JsonResult selectByTime(){
        JsonResult js;
        try{
            List list = articleService.selectNumByTime();
            js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }


}
