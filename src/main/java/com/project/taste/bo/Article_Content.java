package com.project.taste.bo;

import com.project.taste.model.Content;
import com.project.taste.model.User;

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

    private Object highlight;

    private User user;

    public Article_Content(String articleId, String articleTitle, Integer articleStatus, String articleUserId, String articleCategoryId, Date articleTime, List<Content> list, Object highlight, User user) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleStatus = articleStatus;
        this.articleUserId = articleUserId;
        this.articleCategoryId = articleCategoryId;
        this.articleTime = articleTime;
        this.list = list;
        this.highlight = highlight;
        this.user = user;
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

    public Object getHighlight() {
        return highlight;
    }

    public void setHighlight(Object highlight) {
        this.highlight = highlight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
