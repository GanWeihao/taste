package com.project.taste.controller;

import com.project.taste.model.UserCategory;
import com.project.taste.service.UserCategoryService;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/usercategory")
@Api(tags = "用户喜好控制器")
public class UserCategoryController {
    @Autowired
    UserCategoryService userCategoryService;

    /**
     * 查询用户的喜好
     * @return
     */
    @ResponseBody
    @RequestMapping("/querybyid")
    public JsonResult queryAll(String userCategoryUserId){
        JsonResult js;
        try{
            List<UserCategory> list = userCategoryService.selectByUserId(userCategoryUserId);

            if(list.size()>0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"暂无数据");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }
    /**
     * 添加喜好
     */
    @ResponseBody
    @RequestMapping("/insert")
    public JsonResult insertArticle(UserCategory userCategory){
        JsonResult js;
        try{
            int i = userCategoryService.insertSelective(userCategory);
            if(i!=0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"添加成功",i);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"添加失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"添加异常"+e.getMessage());
        }
        return js;
    }

    /**
     * 删除用户喜好
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteByPrimaryKey(String userCategoryId) {
        JsonResult result = null;
        int s = userCategoryService.deleteByPrimaryKey(userCategoryId);
        try {
            if (s == 1) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "删除成功", s);
            } else {
                result = new JsonResult(Constants.STATUS_FAIL, "删除失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "删除异常");
        }
        return result;
    }

}
