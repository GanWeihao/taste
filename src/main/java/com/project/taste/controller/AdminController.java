package com.project.taste.controller;

import com.project.taste.model.Admin;
import com.project.taste.service.AdminService;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class AdminController {
    @Autowired
    AdminService adminService;

    /**
     * 管理员登陆
     */
    @RequestMapping(value = "/admin/login" ,method = RequestMethod.GET)
    @ResponseBody
    public JsonResult Adminlogin(Admin admin){
        JsonResult js;
        try{
            Admin admin1=adminService.Adminlogin(admin);
            if(admin1!=null){
                js=new JsonResult(Constants.STATUS_SUCCESS,"登录成功",admin1);
            }else {
                js=new JsonResult(Constants.STATUS_NOT_FOUND,"登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            js=new JsonResult(Constants.STATUS_ERROR,"登录异常");
        }
        return  js;
    }
    /**
     * 管理员添加
     */
    @RequestMapping(value = "/admin/insert" ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult AdminAdd(Admin admin){
        JsonResult js;
        try{
            int i =adminService.AdminAdd(admin);
            if(i>0){
                js=new JsonResult(Constants.STATUS_SUCCESS,"添加成功",i);
            }else {
                js=new JsonResult(Constants.STATUS_NOT_FOUND,"添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            js=new JsonResult(Constants.STATUS_ERROR,"添加异常");
        }
        return  js;
    }
    /**
     * 管理员删除
     */
    @RequestMapping(value = "/admin/delete" ,method = RequestMethod.GET)
    @ResponseBody
    public JsonResult AdminDel(String adminName, String adminPassword){
        JsonResult js;
        try{
            int i =adminService.AdminDel(adminName,adminPassword);
            if(i>0){
                js=new JsonResult(Constants.STATUS_SUCCESS,"删除成功",i);
            }else {
                js=new JsonResult(Constants.STATUS_NOT_FOUND,"删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            js=new JsonResult(Constants.STATUS_ERROR,"删除异常");
        }
        return  js;
    }
}
