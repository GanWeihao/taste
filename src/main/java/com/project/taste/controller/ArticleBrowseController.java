package com.project.taste.controller;

import com.alibaba.fastjson.JSON;
import com.project.taste.model.Article;
import com.project.taste.model.ArticleBrowse;
import com.project.taste.model.Content;
import com.project.taste.service.ArticleBrowseService;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/articlebrowse")
@Api(tags = "文章浏览记录控制器")
public class ArticleBrowseController {
    @Autowired
    ArticleBrowseService articleBrowseService;

    /**
     * 根据用户ID查询文章浏览记录
     * @param articleBrowseUserId
     * @return
     */
    @ResponseBody
    @RequestMapping("/querybyid")
    public JsonResult selectByUserId(String articleBrowseUserId){
        JsonResult js;
        try{
            List<ArticleBrowse> list = articleBrowseService.selectByUserId(articleBrowseUserId);
            if(list.size()>0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功", list);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch (Exception e){
                e.printStackTrace();
                js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }

    /**
     * 根据文章ID查询浏览数量
     * @param articleBrowseArticleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/querynum")
    public JsonResult queryNumByArticleId(String articleBrowseArticleId){
        JsonResult js;
        try{
            int i = articleBrowseService.selectNumByArticleId(articleBrowseArticleId);
            js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",i);
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }

    /**
     * 删除浏览记录
     *
     */
    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult articleBrowseDelete(String articleBrowseId){
        JsonResult js;
        try{
            int i = articleBrowseService.deleteByArticleBrowseId(articleBrowseId);
            if(i!=0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"删除成功",i);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"删除失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"删除异常");
        }
        return js;
    }
    /**
     * 删除浏览记录（循环）
     */
    @ResponseBody
    @RequestMapping("/article/deleteall")
    public JsonResult articleBrowseDelete2(@RequestParam("ariticleBrowseId") String ariticleBrowseId){
        String strlist = ariticleBrowseId;
        List<String> array = JSON.parseArray(strlist,String.class);
        JsonResult js;
        try{
            int i = articleBrowseService.deleteByArticleBrowseId2(array);
            if(i!=0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"删除成功",i);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"删除失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"删除异常");
        }
        return js;
    }
    /**
     * 删除用户所有浏览记录
     */
    @ResponseBody
    @RequestMapping("/userid/deleteall")
    public JsonResult deleteAllByUserId(String articleBrowseUserId){
        JsonResult js;
        try{
            int i = articleBrowseService.deleteByUserId(articleBrowseUserId);
            if(i!=0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"删除成功",i);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"删除失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"删除异常");
        }
        return js;
    }

    /**
     * 添加浏览记录
     */
    @ResponseBody
    @RequestMapping("/insert")
    public JsonResult insertArticleBrowse(ArticleBrowse articleBrowse){
        JsonResult js;
        try{
            int i = articleBrowseService.insertSelective(articleBrowse);
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
}
