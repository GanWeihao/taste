package com.project.taste.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.taste.bo.Article_Content;
import com.project.taste.model.Article;
import com.project.taste.model.Content;
import com.project.taste.service.ArticleService;
import com.project.taste.service.ContentService;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
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
            PageHelper.startPage(pageNum, pageSize);
            List<Article> list = articleService.selectAll();
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
                article_content.setArticleContentId(article.getArticleContentId());
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

}
