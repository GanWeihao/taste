package com.project.taste.controller;

import com.project.taste.bo.VideoCollect_Video;
import com.project.taste.model.Video;
import com.project.taste.model.VideoCollect;
import com.project.taste.service.VideoCollectService;
import com.project.taste.service.VideoService;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/videocollect")
@Api(tags = "视频收藏控制器")
public class VideoCollectController {
    @Autowired
    VideoCollectService videoCollectService;
    @Autowired
    VideoService videoService;
    /**
     * 添加视频收藏
     */
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult insertCollect(VideoCollect videoCollect){
        JsonResult js;
        try{
            int i=videoCollectService.insertVideoCollect(videoCollect);
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
     * 根据用户ID查视频收藏
     */
    @ResponseBody
    @RequestMapping("/querybyuserid")
    public JsonResult queryByUserId(String videoCollectUserId){
        JsonResult js;
        try{
            List<VideoCollect> list = videoCollectService.selectByUserId(videoCollectUserId);
            List<VideoCollect_Video> list1 = new ArrayList<>();
            for(VideoCollect videoCollect : list){
                VideoCollect_Video videoCollectVideo = new VideoCollect_Video();
                videoCollectVideo.setVideoCollectId(videoCollect.getVideoCollectId());
                videoCollectVideo.setVideoCollectTime(videoCollect.getVideoCollectTime());
                videoCollectVideo.setVideoCollectUserId(videoCollect.getVideoCollectUserId());
                videoCollectVideo.setVideoCollectVideoId(videoCollect.getVideoCollectVideoId());
                videoCollectVideo.setVideo(videoService.queryVideoById(videoCollect.getVideoCollectVideoId()));
                list1.add(videoCollectVideo);
            }
            if(list1.size()>0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list1);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }

    /**
     * 根据视频ID查收藏数量
     */
    @RequestMapping(value = "/querynum" ,method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectVideoCount(String videoCollectVideoId){
        JsonResult js;
        try{
            int i =videoCollectService.selectVideoCount(videoCollectVideoId);
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
     * 删除视频收藏
     */
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteVideoCollect(String videoCollectId){
        JsonResult js;
        try{
            int i =videoCollectService.deleteVideoCollect(videoCollectId);
            if(i!=0){
                js=new JsonResult(Constants.STATUS_SUCCESS,"取消收藏成功",i);
            }else {
                js=new JsonResult(Constants.STATUS_NOT_FOUND,"取消收藏失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            js=new JsonResult(Constants.STATUS_ERROR,"取消收藏异常");
        }
        return  js;
    }


}
