package com.project.taste.controller;

import com.github.pagehelper.PageHelper;
import com.project.taste.model.VideoBrowse;
import com.project.taste.service.impl.VideoBrowseServiceImpl;
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
    @RequestMapping("/videobrowse/querybyid")
    public Object queryVideoBrowseByUserId(@Param("userId") String userId,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<VideoBrowse> list=videoBrowseService.queryVideoBrowseByUserId(userId);
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
     * 根据用户ID查询用户浏览视频数量
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/videobrowse/querynum")
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
}
