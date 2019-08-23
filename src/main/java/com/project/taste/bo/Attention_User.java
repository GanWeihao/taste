package com.project.taste.bo;



public class Attention_User {
    private String userId;

    private String userName;

    private String userTelphone;

    private String userEmail;

    private String userHeadurl;

    private Integer userRank;

    public Attention_User(String userId, String userName, String userTelphone, String userEmail, String userHeadurl, Integer userRank) {
        this.userId = userId;
        this.userName = userName;
        this.userTelphone = userTelphone;
        this.userEmail = userEmail;

        this.userHeadurl = userHeadurl;

        this.userRank = userRank;

    }

    public Attention_User() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserTelphone() {
        return userTelphone;
    }

    public void setUserTelphone(String userTelphone) {
        this.userTelphone = userTelphone == null ? null : userTelphone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }


    public String getUserHeadurl() {
        return userHeadurl;
    }

    public void setUserHeadurl(String userHeadurl) {
        this.userHeadurl = userHeadurl == null ? null : userHeadurl.trim();
    }


    public Integer getUserRank() {
        return userRank;
    }

    public void setUserRank(Integer userRank) {
        this.userRank = userRank;
    }


}