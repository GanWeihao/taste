package com.project.taste.mapper;

import com.project.taste.model.User;
import com.project.taste.vo.DateVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component("UserMapper")
public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    //查询所有用户
    List<User> selectAll();

    // 注册用户
    int insert(String userId, String userName, String userTelphone, String userEmail, String userPassword, String userHeadurl, Date userTime, Integer userRank, Integer userStatus);

    //添加用户2
    int insertSelective(User record);

    //用户登入
    User selectByPrimaryKey(User user);

    //短信登入
    User selectByPrimaryKey1(String userTelephone);

    //查询用户数量
    int querynum();

    //根据ID查询用户详情
    User selectById(String userId);

    //根据用户名 手机号 邮箱查询用户
    List queryAlltiaojian(User user);
    //模糊搜索
    List queryAlltiaojian2(User user);

    //恢复或者禁封用户
    int updateByStatus(User user);
    //根据id查询所有关注的人
    List<User> attention(String userId);
    //根据id查询所有粉丝
    List<User> attention1(String userId);

    //根据时间查询用户数量
    List<DateVo> selectNumByTime();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}