package com.project.taste.controller;

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
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    ContentService contentService;
    @Autowired
    SolrClient solrClient;

    //增量
    String deltaImport = "http://localhost:8080/solr/taste/dataimport?command=delta-import&verbose=false&clean=false&commit=true&optimize=false&core=taste&name=dataimport";

    //全量
    String fullImport = "http://localhost:8080/solr/taste/dataimport?command=full-import&verbose=false&clean=true&commit=true&optimize=false&core=taste&name=dataimport";

    /**
     * 查询所有文章（带分页）
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/article/queryall")
    public JsonResult queryAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        JsonResult js;
        try{
            String update = HttpClientHelper.sendPost(deltaImport);
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setQuery("*:*");
            QueryResponse response = solrClient.query(solrQuery);
            PageHelper.startPage(pageNum,pageSize);
            SolrDocumentList results = response.getResults();
            PageInfo pageInfo = new PageInfo(results);
            if(results.size()>0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",pageInfo);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"暂无数据");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常"+e.getMessage());
        }
        return js;
    }

    /**
     * 根据文章标题查询文章
     * @param article
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/article/querybytitle")
    public JsonResult queryByTitle(Article article, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        JsonResult js;
        try{
            HttpClientHelper.sendPost(deltaImport);
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setQuery("articleTitle:"+article.getArticleTitle());
            solrQuery.setHighlight(true);
            solrQuery.addHighlightField("articleTitle");
            solrQuery.setHighlightSimplePre("<font color='blue'>");
            solrQuery.setHighlightSimplePost("</font>");
            QueryResponse response = solrClient.query(solrQuery);
            PageHelper.startPage(pageNum,pageSize);
            SolrDocumentList results = response.getResults();
            PageInfo pageInfo = new PageInfo(results);
            if(results.size()>0){
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
     * 根据类别ID查询所有文章
     * @param pageNum
     * @param pageSize
     * @param articleCategoryId
     * @return
     */
    @ResponseBody
    @RequestMapping("/article/query/categoryid")
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
    @RequestMapping("/article/query/articleid")
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
    @RequestMapping("/article/delete")
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
    @RequestMapping("/article/insert")
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
    @RequestMapping("/article/update")
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

}
