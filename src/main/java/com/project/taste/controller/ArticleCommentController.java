package com.project.taste.controller;

import com.project.taste.model.ArticleComment;
import com.project.taste.service.impl.ArticleCommentServiceImpl;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class ArticleCommentController {
    @Autowired
    ArticleCommentServiceImpl articleCommentService;
    //根据文章评论ID查询文章评论
    @ResponseBody
    @RequestMapping("/articlecomment/query/articleid")
    public Object queryByIdComment(String articleCommentArticleId){
        JsonResult result=null;
        try{
            List<ArticleComment> list=articleCommentService.queryByIdComment(articleCommentArticleId);
            if(list.size()>0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
            }else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            result=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return result;
    }
    //根据用户ID查询文章评论
    @ResponseBody
    @RequestMapping("/articlecomment/query/userid")
    public Object queryUserByIdComment(String articleCommentUserId){
        JsonResult result=null;
        try{
            List<ArticleComment> list=articleCommentService.queryUserByIdComment(articleCommentUserId);
            if(list.size()>0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
            }else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            result=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return result;
    }

}
