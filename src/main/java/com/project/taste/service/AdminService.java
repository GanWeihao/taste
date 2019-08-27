package com.project.taste.service;

import com.project.taste.model.Admin;

public interface AdminService {
    int deleteByPrimaryKey(String adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    //管理员登录
    Admin Adminlogin(Admin admin);
    //管理员添加
    int AdminAdd(Admin admin);
    //管理员删除
    int AdminDel (String adminId);

}