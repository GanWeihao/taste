package com.project.taste.controller;

import com.github.pagehelper.PageHelper;
import com.project.taste.model.VideoComment;
import com.project.taste.service.VideoCommentService;
import com.project.taste.service.impl.VideoCommentServiceImpl;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class VideoCommentController {
    @Autowired
    VideoCommentServiceImpl videoCommentService;

    /**
     * 根据视频ID查询视频的所有评论
     * @param videoId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/videocomment/query/videoid")
    public  Object queryVideoCommentByVideoId(@Param("videoId") String videoId,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
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


}
