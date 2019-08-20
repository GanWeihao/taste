package com.project.taste.controller;

import com.github.pagehelper.PageHelper;
import com.project.taste.model.Video;
import com.project.taste.service.impl.VideoServiceImpl;
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
public class VideoController {


    @Autowired
    VideoServiceImpl videoService;

    /**
     * 查询所有视频
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/video/queryall")
    public Object queryVideoAll(Integer pageNum,Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Video> list = videoService.queryVideoAll();
            if(list.size()>0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
            }else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        }catch(Exception e){
                result=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return result;
    }

    /**
     * 根据用户ID查询该用户上传的视频数量
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/video/qyerynum/userid")
    public Object queryVideoNum(String userId){
        JsonResult result=null;
        try{
            int num=videoService.queryVideoNum(userId);
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
     * 根据视频ID查询视频详情
     * @param videoId
     * @return
     */
    @ResponseBody
    @RequestMapping("/video/querybyid")
    public Object queryVideoById(String videoId){
        JsonResult result=null;
        try{
            Video video=videoService.queryVideoById(videoId);
            if(video!=null){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",video);
            }else {
                result=new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return result;
    }
}
