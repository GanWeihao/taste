package com.project.taste.bo;

import com.project.taste.model.Article;

import java.util.Date;

public class ArticleBrowse_Article {
    private String articleBrowseId;

    private String articleBrowseUserId;

    private String articleBrowseArticleId;

    private Date articleBrowseTime;

    private Article article;

    public ArticleBrowse_Article(String articleBrowseId, String articleBrowseUserId, String articleBrowseArticleId, Date articleBrowseTime, Article article) {
        this.articleBrowseId = articleBrowseId;
        this.articleBrowseUserId = articleBrowseUserId;
        this.articleBrowseArticleId = articleBrowseArticleId;
        this.articleBrowseTime = articleBrowseTime;
        this.article = article;
    }

    public ArticleBrowse_Article() {
        super();
    }

    public String getArticleBrowseId() {
        return articleBrowseId;
    }

    public void setArticleBrowseId(String articleBrowseId) {
        this.articleBrowseId = articleBrowseId;
    }

    public String getArticleBrowseUserId() {
        return articleBrowseUserId;
    }

    public void setArticleBrowseUserId(String articleBrowseUserId) {
        this.articleBrowseUserId = articleBrowseUserId;
    }

    public String getArticleBrowseArticleId() {
        return articleBrowseArticleId;
    }

    public void setArticleBrowseArticleId(String articleBrowseArticleId) {
        this.articleBrowseArticleId = articleBrowseArticleId;
    }

    public Date getArticleBrowseTime() {
        return articleBrowseTime;
    }

    public void setArticleBrowseTime(Date articleBrowseTime) {
        this.articleBrowseTime = articleBrowseTime;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

}
