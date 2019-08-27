package com.project.taste.controller;

import com.project.taste.model.Category;
import com.project.taste.model.User;
import com.project.taste.service.CategoryService;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/category")
@Api(tags = "类别控制器")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * 查询所有类别（状态为0）
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryall")
    public JsonResult queryAll(){
        JsonResult js;
        try{

            List<Category> list = categoryService.queryAll();

            if(list.size()>0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"暂无数据");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常",e.getMessage());
            e.printStackTrace();
        }
        return js;
    }

    /**
     * 查询所有类别
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryall2")
    public JsonResult queryAll2(){
        JsonResult js;
        try{
            List list = categoryService.queryAll2();
            if(list.size()>0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功", list);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }


    /**
     * 添加类别
     */
    @ResponseBody
    @RequestMapping("/insert")
    public JsonResult insertArticle(Category category){
        JsonResult js;
        try{
            int i = categoryService.insertSelective(category);
            if(i!=0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"添加成功",i);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"添加失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"添加异常");
        }
        return js;
    }

    //修改类别
    @ResponseBody
    @RequestMapping("/updatebyid")
    public JsonResult updatebyid(Category category){
        JsonResult js;
        try{
            int i = categoryService.updateByPrimaryKeySelective(category);
            if(i!=0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"修改成功",i);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"修改失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"修改异常"+e.getMessage());
        }
        return js;
    }

    /**
     * 删除/恢复类别
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/deletebyid")
    public Object updateByPrimaryKey(Category category) {
        JsonResult result = null;
        int s = categoryService.updateByPrimaryKey(category);
        try {
            if (s != 0) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "成功", s);
            } else {
                result = new JsonResult(Constants.STATUS_FAIL, "失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "异常", e.getMessage());
        }
        return result;
    }


}
