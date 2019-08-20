package com.project.taste.model;

import java.util.Date;

public class Article {
    private String articleId;

    private String articleTitle;

    private Integer articleStatus;

    private String articleUserId;

    private String articleCategoryId;

    private Date articleTime;

    public Article(String articleId, String articleTitle, Integer articleStatus, String articleUserId, String articleCategoryId, Date articleTime) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleStatus = articleStatus;
        this.articleUserId = articleUserId;
        this.articleCategoryId = articleCategoryId;
        this.articleTime = articleTime;
    }

    public Article() {
        super();
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getArticleUserId() {
        return articleUserId;
    }

    public void setArticleUserId(String articleUserId) {
        this.articleUserId = articleUserId == null ? null : articleUserId.trim();
    }

    public String getArticleCategoryId() {
        return articleCategoryId;
    }

    public void setArticleCategoryId(String articleCategoryId) {
        this.articleCategoryId = articleCategoryId == null ? null : articleCategoryId.trim();
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }
}