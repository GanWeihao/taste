package com.project.taste.controller;

import com.project.taste.model.User;
import com.project.taste.service.impl.UserServiceImpl;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class UserController {
    @Autowired
    UserServiceImpl userService;

    /**
     * 用户登入
     * @param userName
     * @param userPassword
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/login")
    public Object selectByPrimaryKey(String userName,String userPassword){
        JsonResult result=null;
        try{
            User user = userService.selectByPrimaryKey(userName,userPassword);
            if(user!=null){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",user);
            }else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"查询异常",e.getMessage());
        }
        return result;
    }

}