package com.project.taste.controller;

import com.github.pagehelper.PageHelper;
import com.project.taste.model.Message;
import com.project.taste.service.impl.MessageServiceImpl;
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
public class MessageController {
    @Autowired
    MessageServiceImpl messageService;

    /**
     * 根据用户ID查询用户的所有已读和未读信息
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/message/queryall")
    public Object queryMessageByUserId(@Param("userId") String userId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Message> list=messageService.queryMessageByUserId(userId);
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
