package com.project.taste.controller;

import com.project.taste.model.ArticleBrowse;
import com.project.taste.service.ArticleBrowseService;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleBrowseController {
    @Autowired
    ArticleBrowseService articleBrowseService;

    /**
     * 根据用户ID查询文章浏览记录
     * @param articleBrowseUserId
     * @return
     */
    @ResponseBody
    @RequestMapping("/articlebrowse/querybyid")
    public JsonResult queryArticleBrowseByUserId(String articleBrowseUserId){
        JsonResult js;
        try{
            List<ArticleBrowse> list = articleBrowseService.selectByUserId(articleBrowseUserId);
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
     * 根据文章ID查询浏览数量
     * @param articleBrowseArticleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/articlebrowse/querynum")
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
}
