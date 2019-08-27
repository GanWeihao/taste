package com.project.taste.bo;

import com.project.taste.model.Article;

import java.util.Date;

public class ArticleCollect_Article {
    private String articleCollectId;

    private String articleCollectUserId;

    private String articleCollectArticleId;

    private Date articleCollectTime;

    private Article article;

    public ArticleCollect_Article(String articleCollectId, String articleCollectUserId, String articleCollectArticleId, Date articleCollectTime, Article article) {
        this.articleCollectId = articleCollectId;
        this.articleCollectUserId = articleCollectUserId;
        this.articleCollectArticleId = articleCollectArticleId;
        this.articleCollectTime = articleCollectTime;
        this.article = article;
    }

    public ArticleCollect_Article() {
        super();
    }

    public String getArticleCollectId() {
        return articleCollectId;
    }

    public void setArticleCollectId(String articleCollectId) {
        this.articleCollectId = articleCollectId;
    }

    public String getArticleCollectUserId() {
        return articleCollectUserId;
    }

    public void setArticleCollectUserId(String articleCollectUserId) {
        this.articleCollectUserId = articleCollectUserId;
    }

    public String getArticleCollectArticleId() {
        return articleCollectArticleId;
    }

    public void setArticleCollectArticleId(String articleCollectArticleId) {
        this.articleCollectArticleId = articleCollectArticleId;
    }

    public Date getArticleCollectTime() {
        return articleCollectTime;
    }

    public void setArticleCollectTime(Date articleCollectTime) {
        this.articleCollectTime = articleCollectTime;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
