package com.project.taste.model;

import java.util.Date;

public class User {
    private String userId;

    private String userName;

    private String userTelphone;

    private String userEmail;

    private String userPassword;

    private String userHeadurl;

    private Date userTime;

    private Integer userRank;

    private Integer userStatus;

    public User(String userId, String userName, String userTelphone, String userEmail, String userPassword, String userHeadurl, Date userTime, Integer userRank, Integer userStatus) {
        this.userId = userId;
        this.userName = userName;
        this.userTelphone = userTelphone;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userHeadurl = userHeadurl;
        this.userTime = userTime;
        this.userRank = userRank;
        this.userStatus = userStatus;
    }

    public User() {
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserHeadurl() {
        return userHeadurl;
    }

    public void setUserHeadurl(String userHeadurl) {
        this.userHeadurl = userHeadurl == null ? null : userHeadurl.trim();
    }

    public Date getUserTime() {
        return userTime;
    }

    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }

    public Integer getUserRank() {
        return userRank;
    }

    public void setUserRank(Integer userRank) {
        this.userRank = userRank;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }
}