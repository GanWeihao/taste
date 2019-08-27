package com.project.taste.model;

public class UserCategory {
    private String userCategoryId;

    private String userCategoryUserId;

    private String userCategoryCategoryId;

    public UserCategory(String userCategoryId, String userCategoryUserId, String userCategoryCategoryId) {
        this.userCategoryId = userCategoryId;
        this.userCategoryUserId = userCategoryUserId;
        this.userCategoryCategoryId = userCategoryCategoryId;
    }

    public UserCategory() {
        super();
    }

    public String getUserCategoryId() {
        return userCategoryId;
    }

    public void setUserCategoryId(String userCategoryId) {
        this.userCategoryId = userCategoryId == null ? null : userCategoryId.trim();
    }

    public String getUserCategoryUserId() {
        return userCategoryUserId;
    }

    public void setUserCategoryUserId(String userCategoryUserId) {
        this.userCategoryUserId = userCategoryUserId == null ? null : userCategoryUserId.trim();
    }

    public String getUserCategoryCategoryId() {
        return userCategoryCategoryId;
    }

    public void setUserCategoryCategoryId(String userCategoryCategoryId) {
        this.userCategoryCategoryId = userCategoryCategoryId == null ? null : userCategoryCategoryId.trim();
    }

}