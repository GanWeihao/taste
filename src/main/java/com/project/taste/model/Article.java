package com.project.taste.model;

import java.util.Date;

public class Article {
    private String articleId;

    private String articleTitle;

    private String articleStatus;

    private String articleUserId;

    private String articleContentId;

    private String articleCategoryId;

    private Date articleTime;

    public Article(String articleId, String articleTitle, String articleStatus, String articleUserId, String articleContentId, String articleCategoryId, Date articleTime) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleStatus = articleStatus;
        this.articleUserId = articleUserId;
        this.articleContentId = articleContentId;
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

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus == null ? null : articleStatus.trim();
    }

    public String getArticleUserId() {
        return articleUserId;
    }

    public void setArticleUserId(String articleUserId) {
        this.articleUserId = articleUserId == null ? null : articleUserId.trim();
    }

    public String getArticleContentId() {
        return articleContentId;
    }

    public void setArticleContentId(String articleContentId) {
        this.articleContentId = articleContentId == null ? null : articleContentId.trim();
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