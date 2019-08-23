package com.project.taste.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.taste.model.VideoBrowse;
import com.project.taste.service.impl.VideoBrowseServiceImpl;
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
@RequestMapping("/videobrowse")
@Api(tags = "视频浏览记录控制器")
public class VideoBrowseController {
    @Autowired
    VideoBrowseServiceImpl videoBrowseService;

    /**
     * 根据用户ID查询用户浏览视频记录
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/querybyid")
    public Object queryVideoBrowseByUserId(@Param("userId") String userId, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<VideoBrowse> list=videoBrowseService.queryVideoBrowseByUserId(userId);
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
     * 根据用户ID查询用户浏览视频数量
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/querynum")
    public Object queryVideoBrowseNum(String userId){
        JsonResult result=null;
        try{
            int num=videoBrowseService.queryVideoBrowseNum(userId);
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
     * 添加视频浏览记录
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(String videoBroweUserId,String VideoBroweVideoId){
        JsonResult result=null;
        try{
            int num=videoBrowseService.insert(videoBroweUserId,VideoBroweVideoId);
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

    /**
     * 删除视频浏览记录
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteByPrimaryKey(String videoBrowseId){
        JsonResult result=null;
        try{
            int num=videoBrowseService.deleteByPrimaryKey(videoBrowseId);
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
