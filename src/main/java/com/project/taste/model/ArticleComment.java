package com.project.taste.model;

import java.util.Date;

public class ArticleComment {
    private String articleCommentId;

    private String articleCommentText;

    private Date articleCommentTime;

    private String articleCommentUserId;

    private String articleCommentArticleId;

    private String articleCommentTouserId;

    private Integer articleCommentStatus;
    User user;
    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public ArticleComment(String articleCommentId, String articleCommentText, Date articleCommentTime, String articleCommentUserId, String articleCommentArticleId, String articleCommentTouserId, Integer articleCommentStatus) {
        this.articleCommentId = articleCommentId;
        this.articleCommentText = articleCommentText;
        this.articleCommentTime = articleCommentTime;
        this.articleCommentUserId = articleCommentUserId;
        this.articleCommentArticleId = articleCommentArticleId;
        this.articleCommentTouserId = articleCommentTouserId;
        this.articleCommentStatus = articleCommentStatus;
    }

    public ArticleComment() {
        super();
    }

    public String getArticleCommentId() {
        return articleCommentId;
    }

    public void setArticleCommentId(String articleCommentId) {
        this.articleCommentId = articleCommentId == null ? null : articleCommentId.trim();
    }

    public String getArticleCommentText() {
        return articleCommentText;
    }

    public void setArticleCommentText(String articleCommentText) {
        this.articleCommentText = articleCommentText == null ? null : articleCommentText.trim();
    }

    public Date getArticleCommentTime() {
        return articleCommentTime;
    }

    public void setArticleCommentTime(Date articleCommentTime) {
        this.articleCommentTime = articleCommentTime;
    }

    public String getArticleCommentUserId() {
        return articleCommentUserId;
    }

    public void setArticleCommentUserId(String articleCommentUserId) {
        this.articleCommentUserId = articleCommentUserId == null ? null : articleCommentUserId.trim();
    }

    public String getArticleCommentArticleId() {
        return articleCommentArticleId;
    }

    public void setArticleCommentArticleId(String articleCommentArticleId) {
        this.articleCommentArticleId = articleCommentArticleId == null ? null : articleCommentArticleId.trim();
    }

    public String getArticleCommentTouserId() {
        return articleCommentTouserId;
    }

    public void setArticleCommentTouserId(String articleCommentTouserId) {
        this.articleCommentTouserId = articleCommentTouserId == null ? null : articleCommentTouserId.trim();
    }

    public Integer getArticleCommentStatus() {
        return articleCommentStatus;
    }

    public void setArticleCommentStatus(Integer articleCommentStatus) {
        this.articleCommentStatus = articleCommentStatus;
    }
}