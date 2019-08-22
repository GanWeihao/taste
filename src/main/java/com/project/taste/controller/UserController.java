package com.project.taste.controller;

import com.project.taste.model.User;
import com.project.taste.service.impl.UserServiceImpl;
import com.project.taste.util.Constants;
import com.project.taste.util.Duanxin;
import com.project.taste.util.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

@Controller
@CrossOrigin
public class UserController {
    @Autowired
    UserServiceImpl userService;

    /**
     * 用户登入
     *
     * @param userName
     * @param userPassword
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/login")
    public Object selectByPrimaryKey(String userName, String userPassword) {
        JsonResult result = null;
        try {
            User user = userService.selectByPrimaryKey(userName, userPassword);
            if (user != null) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", user);
            } else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "查询异常", e.getMessage());
        }
        return result;
    }

    /**
     * 短信登入
     *
     * @param userTelephone
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/login1")
    public Object selectByPrimaryKey1(String userTelephone) throws Exception {
        JsonResult result = null;
        try {
            Duanxin s = new Duanxin();
            User user = userService.selectByPrimaryKey1(userTelephone);
            if (user != null) {
                String s1 = s.duanxin(userTelephone).toString();
                String s11 = s1.replaceAll("\"", "");
                result = new JsonResult(Constants.STATUS_SUCCESS, "登录成功", s11);
            } else {
                User user1 = new User();
                user1.setUserTelphone(userTelephone);
                int i = userService.insertSelective(user1);
                if (i != 0) {
                    String s1 = s.duanxin(userTelephone).toString();
                    String s11 = s1.replaceAll("\"", "");
                    result = new JsonResult(Constants.STATUS_SUCCESS, "登录成功", s11);
                } else {
                    result = new JsonResult(Constants.STATUS_FAIL, "登录失败");
                }
            }

        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "异常");
        }

        return result;
    }

    /**
     * 注册用户
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/insert")
    public Object insert(String userName, String userTelphone, String userEmail, String userPassword, String userHeadurl) {
        JsonResult result = null;
        try {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            int s1 = userService.insert(uuid, userName, userTelphone, userEmail, userPassword, userHeadurl, new Date());
            if (s1 == 1) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", s1);
            } else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "查询异常", e.getMessage());
        }
        return result;
    }


    /**
     * 查询用户数量
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/querynum")
    public Object querynum() {
        JsonResult result = null;
        try {
            int s = userService.querynum();
            if (s != 0) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", s);
            } else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "查询异常", e.getMessage());
        }
        return result;
    }

    /**
     * 根据id查询用户详情
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/querybyid")
    public Object queryById(String userId) {
        JsonResult result = null;
        try {
            User user = userService.selectById(userId);
            if (user != null) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", user);
            } else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "查询异常", e.getMessage());
        }
        return result;
    }

    /**
     * 根据用户名 用户邮箱 用户电话查询用户
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/querybyname")
    public Object queryAlltiaojian(String userName, String userTelphone, String userEmail) {
        JsonResult result = null;
        try {
            User user = userService.queryAlltiaojian(userName, userTelphone, userEmail);
            if (user != null) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", user);
            } else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "查询异常", e.getMessage());
        }
        return result;
    }

    /**
     * 恢复或者禁封用户
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/delete")
    public Object updateByStatus(String userId) {
        JsonResult result = null;
        User user = userService.selectById(userId);
        Integer s = user.getUserStatus();
        try {
            if (s == 0) {
                int s1 = userService.updateByStatus(userId, 1);
                result = new JsonResult(Constants.STATUS_SUCCESS, "禁封该用户", s1);
                return result;
            }
            if (s == 1) {
                int s1 = userService.updateByStatus(userId, 0);
                result = new JsonResult(Constants.STATUS_SUCCESS, "恢复该用户", s1);
                return result;

            } else {
                result = new JsonResult(Constants.STATUS_FAIL, "操作失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "操作异常", e.getMessage());
        }
        return result;
    }


}