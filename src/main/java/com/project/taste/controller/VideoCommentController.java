package com.project.taste.controller;

import com.github.pagehelper.PageHelper;
import com.project.taste.model.VideoComment;
import com.project.taste.service.VideoCommentService;
import com.project.taste.service.impl.VideoCommentServiceImpl;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/videocomment")
@Api(tags = "视频评论控制器")
public class VideoCommentController {
    @Autowired
    VideoCommentServiceImpl videoCommentService;

    /**
     * 根据视频ID查询视频的所有评论
     * @param videoId
     * @return
     */
    @ResponseBody
    @RequestMapping("/query/videoid")
    public  Object queryVideoCommentByVideoId(@Param("videoId") String videoId){
        JsonResult result=null;
        try{
            List<VideoComment> list=videoCommentService.queryVideoCommentByVideoId(videoId);
            if(list.size()>0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
            }else{
                result=new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return result;
    }

    /**
     * 查询视频评论数量
     * @return
     */
    @ResponseBody
    @RequestMapping("/querynum")
    public Object queryVideoCommentNum(String videoCommentVideoId){
        JsonResult result=null;
        try{
            int num=videoCommentService.queryVideoCommentNum(videoCommentVideoId);
            if(num!=0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",num);
            }else{
                result=new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return result;
    }

    /**
     * 根据用户ID查询所有视频评论
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/query/userid")
    public Object queryVideoCommentByUserId(String userId){
        JsonResult result=null;
        try{
            List<VideoComment> list = videoCommentService.queryVideoCommentByUserId(userId);
            if(list.size()>0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
            }else{
                result=new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return result;
    }

    /**
     * 添加视频评论
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Object  insert(VideoComment videoComment){
        JsonResult result=null;
        try{
            int num=videoCommentService.insertSelective(videoComment);
            if(num!=0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"添加成功",num);
            }else{
                result=new JsonResult(Constants.STATUS_FAIL,"添加失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"添加异常");
        }
        return result;
    }

    /**删除视频评论
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object  updateByPrimaryKey(String videoCommentId){
        JsonResult result=null;
        try{
            int num=videoCommentService.updateByPrimaryKey(videoCommentId);
            if(num!=0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"删除成功",num);
            }else{
                result=new JsonResult(Constants.STATUS_FAIL,"删除失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"删除异常");
        }
        return result;
    }

}
