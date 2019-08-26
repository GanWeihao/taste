package com.project.taste.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.taste.model.User;
import com.project.taste.service.impl.UserServiceImpl;
import com.project.taste.util.Constants;
import com.project.taste.util.Duanxin;
import com.project.taste.util.JsonResult;

import com.project.taste.vo.DateVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/user")
@Api(tags = "用户控制器")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    /**
     * 查询所有用户
     * @return
     */
    @ResponseBody
    @RequestMapping("/all")
    public JsonResult selectAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "6") Integer pageSize){
        JsonResult js;
        try{
            PageHelper.startPage(pageNum, pageSize);
            List<User> list = userService.selectAll();
            PageInfo pageInfo = new PageInfo(list);
            if(list.size()>0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功", pageInfo);
            }else {
                js = new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }

    /**
     * 用户登入
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult selectByPrimaryKey(User user) {
        JsonResult result = null;
        try {
            User user1 = userService.selectByPrimaryKey(user);
            if (user1 != null) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", user1);
            } else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "查询异常", e.getMessage());
        }
        return result;
    }

    /**
     * 手机号码登录添加用户
     */
    @ResponseBody
    @RequestMapping(value = "/telphone/insert", method = RequestMethod.POST)
    public JsonResult insertFromTelphone(String userTelephone){
        JsonResult js;
        try{
            User user = userService.selectByPrimaryKey1(userTelephone);
            if (user != null) {
                js = new JsonResult(Constants.STATUS_SUCCESS, "登录成功", user);
            } else {
                User user1 = new User();
                user1.setUserTelphone(userTelephone);
                String i = userService.insertSelective(user1);
                User user2 = userService.selectByPrimaryKey1(userTelephone);
                if (i != null) {
                    js = new JsonResult(Constants.STATUS_SUCCESS, "注册成功", user2);
                } else {
                    js = new JsonResult(Constants.STATUS_FAIL, "注册失败");
                }
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR, "注册异常"+e.getMessage());
        }
        return js;
    }

    /**
     * 发送短信
     *
     * @param userTelephone
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login1", method = RequestMethod.POST)
    public JsonResult selectByPrimaryKey1(String userTelephone) {
        JsonResult result = null;
        try {
            Duanxin s = new Duanxin();
            String s1 = s.duanxin(userTelephone).toString();
            String s11 = s1.replaceAll("\"", "");
            result = new JsonResult(Constants.STATUS_SUCCESS, "发送成功", JSON.parse(s11));
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "发送异常");
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
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public JsonResult insert(User user) {
        JsonResult result = null;
        try {
            List user1 = userService.queryAlltiaojian(user);
            if(user1.size()<=0){
                String s1 = userService.insertSelective(user);
                if (s1 != null) {
                    result = new JsonResult(Constants.STATUS_SUCCESS, "添加成功", s1);
                } else {
                    result = new JsonResult(Constants.STATUS_FAIL, "添加失败");
                }
            }else{
                result = new JsonResult(Constants.STATUS_FAIL, "用户名、手机号码或邮箱已存在");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "添加异常", e.getMessage());
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
    @RequestMapping("/querynum")
    public JsonResult querynum() {
        JsonResult result = null;
        try {
            int s = userService.querynum();
            if (s != 0) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", s);
                return result;
            }if (s == 0) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", s);
                return  result;
            }
            else {
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
    @RequestMapping("/querybyid")
    public JsonResult queryById(String userId) {
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
     * 模糊搜索
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/query/mohu")
    public JsonResult queryAlltiaojian2(User user, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "6") Integer pageSize) {
        JsonResult result = null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List user1 = userService.queryAlltiaojian2(user);
            PageInfo pageInfo = new PageInfo(user1);
            if (user1.size()>0) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", pageInfo);
            } else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "查询异常");
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
    @RequestMapping("/querybyname")
    public JsonResult queryAlltiaojian(User user) {
        JsonResult result = null;
        try {
            List user1 = userService.queryAlltiaojian(user);
            if (user1.size()>0) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", user1);
            } else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "查询异常");
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
    @RequestMapping("/delete")
    public JsonResult updateByStatus(String userId) {
        JsonResult result = null;
        try {
            User user = userService.selectById(userId);
            Integer s = user.getUserStatus();
            System.out.println(user.getUserStatus());
            if (s == 0) {
                user.setUserStatus(1);
                int s1 = userService.updateByStatus(user);
                result = new JsonResult(Constants.STATUS_SUCCESS, "已禁封该用户", s1);
            }else if (s != 0) {
                user.setUserStatus(0);
                int s1 = userService.updateByStatus(user);
                result = new JsonResult(Constants.STATUS_SUCCESS, "已恢复该用户", s1);
            } else {
                result = new JsonResult(Constants.STATUS_FAIL, "操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult(Constants.STATUS_ERROR, "操作异常");
        }
        return result;
    }

    /**
     * 根据用户id查询所有关注
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/attention/query/userid")
    public JsonResult attention(String userId) {
        JsonResult result = null;
        List<User> list = userService.attention(userId);
        try {
            if (list.size()>0) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", list);
                return result;
            }
            else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "查询异常", e.getMessage());
        }
        return result;
    }

    /**
     * 根据用户id查询所有粉丝
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/fensi/query/toserid")
    public JsonResult attention1(String userId) {
        JsonResult result = null;
        List<User> list = userService.attention1(userId);
        try {
            if (list.size()>0) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", list);
                return result;
            }
            else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "查询异常", e.getMessage());
        }
        return result;
    }

    /**
     * 根据日期查数量
     * @return
     */
    @ResponseBody
    @RequestMapping("/select/bytime")
    public JsonResult selectByTime(){
        JsonResult js;
        try{
            List list = userService.selectNumByTime();
            js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }
}