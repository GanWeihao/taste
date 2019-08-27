package com.project.taste.service.impl;

import com.project.taste.mapper.AdminMapper;
import com.project.taste.model.Admin;
import com.project.taste.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public int deleteByPrimaryKey(String adminId) {
        return 0;
    }

    @Override
    public int insert(Admin record) {
        return 0;
    }

    @Override
    public int insertSelective(Admin record) {
        return 0;
    }

    //根据ID查管理员
    @Override
    public Admin selectByPrimaryKey(String adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return 0;
    }

    /**
     * 管理员登录
     */
    @Override
    public Admin Adminlogin(Admin admin){
        return adminMapper.Adminlogin(admin);
    }
    /**
     * 管理员添加
     */
    @Override
    public int AdminAdd(Admin admin) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        admin.setAdminId(id);
        return adminMapper.AdminAdd(admin);
    }
    /**
     * 管理员删除
     */
    @Override
    public int AdminDel(String adminId) {
        return adminMapper.AdminDel(adminId);
    }

}
