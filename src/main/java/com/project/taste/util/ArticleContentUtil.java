package com.project.taste.util;

import com.project.taste.bo.Article_Content;
import com.project.taste.model.Article;
import com.project.taste.model.Content;
import com.project.taste.model.User;
import com.project.taste.service.ContentService;
import com.project.taste.service.UserService;
import org.apache.solr.common.SolrDocument;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ArticleContentUtil {

    public static Article_Content put(SolrDocument obj, ContentService contentService, UserService userService) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", java.util.Locale.US);
        Article_Content article_content = new Article_Content();
        article_content.setArticleId(obj.get("id").toString());
        article_content.setArticleCategoryId(obj.get("articleCategoryId").toString());
        article_content.setArticleStatus(Integer.valueOf(obj.get("articleStatus").toString()));
        article_content.setArticleTime(sdf.parse(obj.get("articleTime").toString()));
        article_content.setArticleTitle(obj.get("articleTitle").toString());
        article_content.setArticleUserId(obj.get("articleUserId").toString());
        article_content.setHighlight(obj.get("highlight"));
        List<Content> list = contentService.selectByArticleId(obj.get("id").toString());
        article_content.setList(list);
        User user = userService.selectById(obj.get("articleUserId").toString());
        article_content.setUser(user);
        return article_content;
    }

    public static Article_Content put2(Article article, ContentService contentService, UserService userService) throws ParseException {
        Article_Content article_content = new Article_Content();
        article_content.setArticleId(article.getArticleId());
        article_content.setArticleCategoryId(article.getArticleCategoryId());
        article_content.setArticleStatus(article.getArticleStatus());
        article_content.setArticleTime(article.getArticleTime());
        article_content.setArticleTitle(article.getArticleTitle());
        article_content.setArticleUserId(article.getArticleUserId());
        List<Content> list = contentService.selectByArticleId(article.getArticleId());
        article_content.setList(list);
        User user = userService.selectById(article.getArticleUserId());
        article_content.setUser(user);
        return article_content;
    }

}
