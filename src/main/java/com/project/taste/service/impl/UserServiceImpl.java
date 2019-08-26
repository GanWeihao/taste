package com.project.taste.service.impl;

import com.project.taste.mapper.UserMapper;
import com.project.taste.model.User;
import com.project.taste.service.UserService;
import com.project.taste.vo.DateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(String userId) {
        return 0;
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    //查询用户数量
    @Override
    public int querynum() {
        return userMapper.querynum();
    }

    //用户注册
    @Override
    public int insert(String userId, String userName, String userTelphone, String userEmail, String userPassword, String userHeadurl, Date userTime) {
        int s = userMapper.insert(userId, userName, userTelphone, userEmail, userPassword, userHeadurl, userTime, 1, 0);
        return s;
    }

    //添加用户2
    @Override
    public String insertSelective(User record) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        record.setUserId(id);
        if(record.getUserName()==null){
            record.setUserName(record.getUserTelphone());
        }
        record.setUserTime(new Date());
        if(record.getUserStatus()==null){
            record.setUserStatus(0);
        }
        record.setUserRank(1);
        int i = userMapper.insertSelective(record);
        if(i==0){
            return null;
        }
        return id;
    }


    //用户登入
    @Override
    public User selectByPrimaryKey(User user) {
        User user1 = userMapper.selectByPrimaryKey(user);
        return user1;
    }

    //短信登入
    @Override
    public User selectByPrimaryKey1(String userTelephone) {
        User user = userMapper.selectByPrimaryKey1(userTelephone);
        return user;
    }

    //根据id查询用户详情
    @Override
    public User selectById(String userId) {
        return userMapper.selectById(userId);
    }

    //根据用户名 用户邮箱 用户电话 查询用户信息
    @Override
    public List queryAlltiaojian(User user) {
        return userMapper.queryAlltiaojian(user);
    }

    //模糊搜索
    @Override
    public List queryAlltiaojian2(User user) {
        return userMapper.queryAlltiaojian2(user);
    }

    //恢复或禁封用户
    @Override
    public int updateByStatus(User user) {
        return userMapper.updateByStatus(user);
    }
    //根据用户id查询所有关注
    @Override
    public List<User> attention(String userId){
        return  userMapper.attention(userId);
    }

    //根据用户id查询所有粉丝
    @Override
    public List<User> attention1(String userId){
        return  userMapper.attention1(userId);
    }

    @Override
    public List selectNumByTime() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        List<DateVo> list = userMapper.selectNumByTime();
        List list1 = new ArrayList();
        for(DateVo dateVo : list){
            HashMap<String, Object> hm = new HashMap<>();
            hm.put("date",sdf.format(dateVo.getDates()));
            hm.put("num",dateVo.getNum());
            list1.add(hm);
        }
        return list1;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}