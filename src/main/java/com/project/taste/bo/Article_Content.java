package com.project.taste.bo;

import com.project.taste.model.Content;

import java.util.Date;
import java.util.List;

public class Article_Content {
    private String articleId;

    private String articleTitle;

    private Integer articleStatus;

    private String articleUserId;

    private String articleCategoryId;

    private Date articleTime;

    private List<Content> list;

    public Article_Content(String articleId, String articleTitle, Integer articleStatus, String articleUserId, String articleCategoryId, Date articleTime, List<Content> list) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleStatus = articleStatus;
        this.articleUserId = articleUserId;
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

    public List<Content> getList() {
        return list;
    }

    public void setList(List<Content> list) {
        this.list = list;
    }
}
