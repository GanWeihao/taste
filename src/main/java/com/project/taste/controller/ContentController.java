package com.project.taste.controller;

import com.alibaba.fastjson.JSON;
import com.project.taste.model.Content;
import com.project.taste.service.ContentService;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/content")
@Api(tags = "文章内容控制器")
public class ContentController {
    @Autowired
    ContentService contentService;
/**
 *
 * 查询所有文章内容
 */
@ResponseBody
@RequestMapping("/select/allcontent")
public JsonResult selectAllContent(){
    JsonResult result=null;
    try{
        List<Content> list=contentService.selectAllContent();
        if(list.size()>0){
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",list);
        }else{
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
    }catch (Exception e){
        e.printStackTrace();
        result=new JsonResult(Constants.STATUS_ERROR,"异常");
    }
    return result;
}

    /**
     * 根据文章ID删除文章内容
     * @param contentArticleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult deleteContent(String contentArticleId){
        JsonResult js;
        try{
            int i = contentService.deleteByArticleId(contentArticleId);
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
     *添加文章内容
     * @param content
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public JsonResult insertContent(@RequestParam("content") String content){
        JsonResult js;
        String strlist = content;
        List<Content> array = JSON.parseArray(strlist,Content.class);
        try{
            int i = contentService.insertBatch(array);
            js = new JsonResult(Constants.STATUS_SUCCESS,"添加成功",i);
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"添加异常");
        }
        return js;
    }

    /**
     * 查询文章内容
     * @param contentArticleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/select/articleid")
    public JsonResult selectByArticleId(String contentArticleId){
        JsonResult js;
        try{
            List list = contentService.selectByArticleId(contentArticleId);
            if(list.size()>0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }
}
