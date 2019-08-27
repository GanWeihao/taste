package com.project.taste.model;

import java.util.Date;
import java.util.List;

public class ArticleBrowse {
    private String articleBrowseId;

    private String articleBrowseUserId;

    private String articleBrowseArticleId;

    private Date articleBrowseTime;

    public ArticleBrowse(String articleBrowseId, String articleBrowseUserId, String articleBrowseArticleId, Date articleBrowseTime) {
        this.articleBrowseId = articleBrowseId;
        this.articleBrowseUserId = articleBrowseUserId;
        this.articleBrowseArticleId = articleBrowseArticleId;
        this.articleBrowseTime = articleBrowseTime;
    }

    public ArticleBrowse() {
        super();
    }

    public String getArticleBrowseId() {
        return articleBrowseId;
    }

    public void setArticleBrowseId(String articleBrowseId) {
        this.articleBrowseId = articleBrowseId == null ? null : articleBrowseId.trim();
    }

    public String getArticleBrowseUserId() {
        return articleBrowseUserId;
    }

    public void setArticleBrowseUserId(String articleBrowseUserId) {
        this.articleBrowseUserId = articleBrowseUserId == null ? null : articleBrowseUserId.trim();
    }

    public String getArticleBrowseArticleId() {
        return articleBrowseArticleId;
    }

    public void setArticleBrowseArticleId(String articleBrowseArticleId) {
        this.articleBrowseArticleId = articleBrowseArticleId == null ? null : articleBrowseArticleId.trim();
    }

    public Date getArticleBrowseTime() {
        return articleBrowseTime;
    }

    public void setArticleBrowseTime(Date articleBrowseTime) {
        this.articleBrowseTime = articleBrowseTime;
    }

}