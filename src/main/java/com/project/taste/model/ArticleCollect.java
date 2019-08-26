package com.project.taste.model;

import java.util.Date;

public class ArticleCollect {
    private String articleCollectId;

    private String articleCollectUserId;

    private String articleCollectArticleId;

    private Date articleCollectTime;

    Article article;
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }


    public ArticleCollect(String articleCollectId, String articleCollectUserId, String articleCollectArticleId, Date articleCollectTime) {
        this.articleCollectId = articleCollectId;
        this.articleCollectUserId = articleCollectUserId;
        this.articleCollectArticleId = articleCollectArticleId;
        this.articleCollectTime = articleCollectTime;
    }

    public ArticleCollect() {
        super();
    }

    public String getArticleCollectId() {
        return articleCollectId;
    }

    public void setArticleCollectId(String articleCollectId) {
        this.articleCollectId = articleCollectId == null ? null : articleCollectId.trim();
    }

    public String getArticleCollectUserId() {
        return articleCollectUserId;
    }

    public void setArticleCollectUserId(String articleCollectUserId) {
        this.articleCollectUserId = articleCollectUserId == null ? null : articleCollectUserId.trim();
    }

    public String getArticleCollectArticleId() {
        return articleCollectArticleId;
    }

    public void setArticleCollectArticleId(String articleCollectArticleId) {
        this.articleCollectArticleId = articleCollectArticleId == null ? null : articleCollectArticleId.trim();
    }

    public Date getArticleCollectTime() {
        return articleCollectTime;
    }

    public void setArticleCollectTime(Date articleCollectTime) {
        this.articleCollectTime = articleCollectTime;
    }
}