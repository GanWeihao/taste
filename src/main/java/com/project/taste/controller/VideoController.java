package com.project.taste.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.taste.model.Video;
import com.project.taste.service.impl.VideoServiceImpl;
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
@RequestMapping("/video")
@Api(tags = "视频控制器")
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
    @RequestMapping("/queryall")
    public Object queryVideoAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "8") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Video> list = videoService.queryVideoAll();
            PageInfo pageInfo = new PageInfo(list);
            if(list.size()>0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",pageInfo);
            }else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"查询异常"+e.getMessage());
        }
        return result;
    }

    /**
     * 根据用户ID查询该用户上传的视频数量
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/qyerynum/userid")
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
    @RequestMapping("/querybyid")
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

    /**
     * 根据用户id查询用户上传所有视频
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/query/userid")
    public Object queryVideoAllByid(@Param("userId") String userId,@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "8") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Video> list = videoService.queryVideoAllByid(userId);
            PageInfo pageInfo = new PageInfo(list);
            if(list.size()>0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",pageInfo);
            }else{
                result=new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return result;
    }

    /**
     * 根据视频标题查询视频
     * @param videoTitle
     * @return
     */
    @ResponseBody
    @RequestMapping("/querybytitle")
    public Object selectByPrimaryKey(String videoTitle){
        JsonResult result=null;
        try{
            Video video=videoService.selectByPrimaryKey(videoTitle);
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


    /**
     * 添加视频
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(Video video){
        JsonResult result=null;
        try{
            int s=videoService.insertSelective(video);
            if(s!=0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"添加成功",s);
            }else {
                result=new JsonResult(Constants.STATUS_FAIL,"添加失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"添加异常");
        }
        return result;
    }

    /**
     * 删除视频
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object updateByPrimaryKey(String videoId){
        JsonResult result=null;
        try{
            int s=videoService.updateByPrimaryKey(videoId);
            if(s!=0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"删除成功",s);
            }else {
                result=new JsonResult(Constants.STATUS_FAIL,"删除失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"删除异常");
        }
        return result;
    }

    /**
     * 根据类别ID查视频
     */
    @ResponseBody
    @RequestMapping("/select/categoryid")
    public JsonResult selectByCategoryId(String videoCategoryId, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "8") Integer pageSize){
        JsonResult js;
        try{
            PageHelper.startPage(pageNum, pageSize);
            List<Video> list = videoService.selectAllByCategoryId(videoCategoryId);
            PageInfo pageInfo = new PageInfo(list);
            if(list.size()>0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功", pageInfo);
            }else {
                js = new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }
}

