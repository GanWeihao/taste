package com.project.taste.controller;

import com.project.taste.model.Article;
import com.project.taste.model.ArticleCollect;
import com.project.taste.service.ArticleCollectService;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/articlecollect")
@Api(tags = "文章收藏控制器")
public class ArticleCollectController {
    @Autowired
    ArticleCollectService articleCollectService;

    /**
     * 根据用户id查询所有文章收藏
     */
    @RequestMapping(value = "/queryall" ,method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectArticleByUId(String articleCollectUserId){
        JsonResult js;
        try{
            List<ArticleCollect> list=articleCollectService.selectArticleByUId(articleCollectUserId);
            if(list.size()>0){
                js=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
            }else {
                js=new JsonResult(Constants.STATUS_NOT_FOUND,"查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            js=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return  js;
    }
    /**
     * 根据文章ID查收藏数量
     */
    @RequestMapping(value = "/querynum" ,method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectCount(String articleId){
        JsonResult js;
        try{
            int i=articleCollectService.selectCount(articleId);
            if(i!=0){
                js=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",i);
            }else {
                js=new JsonResult(Constants.STATUS_NOT_FOUND,"查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            js=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return  js;
    }
    /**
     * 添加文章收藏
     */
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult insertCollect(ArticleCollect articleCollect){
        JsonResult js;
        try{
            int i=articleCollectService.insertCollect(articleCollect);
            if(i!=0){
                js=new JsonResult(Constants.STATUS_SUCCESS,"收藏成功",i);
            }else {
                js=new JsonResult(Constants.STATUS_NOT_FOUND,"收藏失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            js=new JsonResult(Constants.STATUS_ERROR,"收藏异常");
        }
        return  js;
    }
    /**
     * 删除文章收藏
     */
    @RequestMapping(value = "/delete" )
    @ResponseBody
    public JsonResult deleteCollect(String articleCollectId){
        JsonResult result;
        try{
            int i=articleCollectService.deleteCollect(articleCollectId);
            if(i!=0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"取消收藏成功",i);
            }else {
                result=new JsonResult(Constants.STATUS_NOT_FOUND,"取消收藏失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result=new JsonResult(Constants.STATUS_ERROR,"取消收藏异常");
        }
        return result;
    }
}
