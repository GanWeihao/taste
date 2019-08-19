package com.project.taste.model;

public class Attention {
    private String attentionId;

    private String attentionUserId;

    private String attentionTouserId;

    public Attention(String attentionId, String attentionUserId, String attentionTouserId) {
        this.attentionId = attentionId;
        this.attentionUserId = attentionUserId;
        this.attentionTouserId = attentionTouserId;
    }

    public Attention() {
        super();
    }

    public String getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(String attentionId) {
        this.attentionId = attentionId == null ? null : attentionId.trim();
    }

    public String getAttentionUserId() {
        return attentionUserId;
    }

    public void setAttentionUserId(String attentionUserId) {
        this.attentionUserId = attentionUserId == null ? null : attentionUserId.trim();
    }

    public String getAttentionTouserId() {
        return attentionTouserId;
    }

    public void setAttentionTouserId(String attentionTouserId) {
        this.attentionTouserId = attentionTouserId == null ? null : attentionTouserId.trim();
    }
}