package com.project.taste.model;

public class Content {
    private String contentId;

    private String contentText;

    private String contentArticleId;

    private String contentImgurl;

    private Integer contentOrder;

    public Content(String contentId, String contentText, String contentArticleId, String contentImgurl, Integer contentOrder) {
        this.contentId = contentId;
        this.contentText = contentText;
        this.contentArticleId = contentArticleId;
        this.contentImgurl = contentImgurl;
        this.contentOrder = contentOrder;
    }

    public Content() {
        super();
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId == null ? null : contentId.trim();
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText == null ? null : contentText.trim();
    }

    public String getContentArticleId() {
        return contentArticleId;
    }

    public void setContentArticleId(String contentArticleId) {
        this.contentArticleId = contentArticleId == null ? null : contentArticleId.trim();
    }

    public String getContentImgurl() {
        return contentImgurl;
    }

    public void setContentImgurl(String contentImgurl) {
        this.contentImgurl = contentImgurl == null ? null : contentImgurl.trim();
    }

    public Integer getContentOrder() {
        return contentOrder;
    }

    public void setContentOrder(Integer contentOrder) {
        this.contentOrder = contentOrder;
    }
}