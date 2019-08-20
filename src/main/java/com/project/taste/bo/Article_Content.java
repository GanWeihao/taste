package com.project.taste.bo;

import com.project.taste.model.Content;

import java.util.Date;
import java.util.List;

public class Article_Content {
    private String articleId;

    private String articleTitle;

    private String articleStatus;

    private String articleUserId;

    private String articleContentId;

    private String articleCategoryId;

    private Date articleTime;

    private List<Content> list;

    public Article_Content(String articleId, String articleTitle, String articleStatus, String articleUserId, String articleContentId, String articleCategoryId, Date articleTime, List<Content> list) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleStatus = articleStatus;
        this.articleUserId = articleUserId;
        this.articleContentId = articleContentId;
        this.articleCategoryId = articleCategoryId;
        this.articleTime = articleTime;
        this.list = list;
    }

    public Article_Content() {
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

    public List<Content> getList() {
        return list;
    }

    public void setList(List<Content> list) {
        this.list = list;
    }
}
