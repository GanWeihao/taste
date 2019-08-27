package com.project.taste.controller;

import com.project.taste.model.Admin;
import com.project.taste.service.AdminService;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
@Api(tags = "管理员控制器")
public class AdminController {
    @Autowired
    AdminService adminService;

    /**
     * 管理员登陆
     */
    @ApiOperation(value = "管理员登录",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "adminName",value = "登录账号"),
            @ApiImplicitParam(name = "adminPassword",value = "登录密码")
    })
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
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
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
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
    @RequestMapping(value = "/delete" ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult AdminDel(String adminId){
        JsonResult js;
        try{
            int i =adminService.AdminDel(adminId);
            if(i!=0){
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

    /**
     * 根据ID查管理员
     */
    @ResponseBody
    @RequestMapping(value = "/findbyid", method = RequestMethod.POST)
    public JsonResult FindAdminById(String adminId){
        JsonResult js;
        try{
            Admin admin = adminService.selectByPrimaryKey(adminId);
            if(admin!=null){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功", admin);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }
}
