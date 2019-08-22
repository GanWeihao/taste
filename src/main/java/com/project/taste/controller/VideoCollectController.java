package com.project.taste.controller;

import com.project.taste.model.Video;
import com.project.taste.model.VideoCollect;
import com.project.taste.service.VideoCollectService;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class VideoCollectController {
    @Autowired
    VideoCollectService videoCollectService;
    /**
     * 添加视频收藏
     */
    @RequestMapping(value = "/videocollect/insert" ,method = RequestMethod.POST)
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
     * 根据用户id查询所有收藏视频
     */
    @RequestMapping(value = "/videocollect/querybyid" ,method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectVideoByUId(String videoCollectUserId){
        JsonResult js;
        try{
            List<Video>  video=videoCollectService.selectVideoByUId(videoCollectUserId);
            if(video!=null){
                js=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",video);
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
     * 根据视频ID查收藏数量
     */
    @RequestMapping(value = "/videocollect/querynum" ,method = RequestMethod.GET)
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
    @RequestMapping(value = "/videocollect/delete" ,method = RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteVideoCollect(String videoCollectVideoId,String videoCollectUserId){
        JsonResult js;
        try{
            int i =videoCollectService.deleteVideoCollect(videoCollectVideoId,videoCollectUserId);
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
