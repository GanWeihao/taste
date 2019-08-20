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
}
