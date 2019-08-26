package com.project.taste.controller;

import com.project.taste.model.ArticleComment;
import com.project.taste.service.impl.ArticleCommentServiceImpl;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/articlecomment")
@Api(tags = "文章评论控制器")
public class ArticleCommentController {
    @Autowired
    ArticleCommentServiceImpl articleCommentService;
    //根据文章id查询文章评论
    @ResponseBody
    @RequestMapping("/query/articleid")
    public Object queryByIdComment(String articleCommentArticleId){
        JsonResult result=null;
        try{
            List<ArticleComment> list=articleCommentService.queryByIdComment(articleCommentArticleId);
            if(list.size()>0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"成功",list);
            }else{
                result=new JsonResult(Constants.STATUS_ERROR,"失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(Constants.STATUS_ERROR,"异常");
        }
        return  result;
    }

    //根据用户ID查文章评论
    @ResponseBody
    @RequestMapping("/query/userid")
    public Object queryUserByIdComment(String articleCommentUserId){
        JsonResult result=null;
        try{
            List<ArticleComment> list=articleCommentService.queryUserByIdComment(articleCommentUserId);
            if(list.size()>0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"成功",list);
            }else{
                result=new JsonResult(Constants.STATUS_ERROR,"失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(Constants.STATUS_ERROR,"异常");
        }
        return  result;
    }
    //根据文章ID查询评论数量
    @ResponseBody
    @RequestMapping("/querynum")
    public Object queryCommentNumber(String articleCommentArticleId){
        JsonResult result=null;
        try{
            int  ac=articleCommentService.queryCommentNumber(articleCommentArticleId);
            if(ac!=0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"成功",ac);
            }else{
                result=new JsonResult(Constants.STATUS_ERROR,"失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(Constants.STATUS_ERROR,"异常");
        }
        return  result;
    }
    //添加文章评论
    @ResponseBody
    @RequestMapping("/insert")
    public Object insertSelective(ArticleComment record){
        JsonResult result=null;
        try{
            int  ac=articleCommentService.insertSelective(record);
            if(ac!=0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"成功",ac);
            }else{
                result=new JsonResult(Constants.STATUS_ERROR,"失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(Constants.STATUS_ERROR,"异常");
        }
        return  result;
    }
    //删除文章评论
    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteArticleComment(String articleCommentId){
        JsonResult result=null;
        try{
            int  ac=articleCommentService.deleteArticleComment(articleCommentId);
            if(ac!=0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"成功",ac);
            }else{
                result=new JsonResult(Constants.STATUS_ERROR,"失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult(Constants.STATUS_ERROR,"异常");
        }
        return  result;
    }

}
