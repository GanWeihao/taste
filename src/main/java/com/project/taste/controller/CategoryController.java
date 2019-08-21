package com.project.taste.controller;

import com.project.taste.model.Category;
import com.project.taste.service.CategoryService;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * 查询所有文章（
     * @return
     */
    @ResponseBody
    @RequestMapping("/category/queryall")
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
     * 添加类别
     */
}
