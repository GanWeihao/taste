package com.project.taste.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.taste.model.Message;
import com.project.taste.service.impl.MessageServiceImpl;
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
@RequestMapping("/message")
@Api(tags = "用户消息控制器")
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
    @RequestMapping("/queryall")
    public Object queryMessageByUserId(@Param("userId") String userId, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Message> list=messageService.queryMessageByUserId(userId);
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
     * 查询用户所有消息
     */
    @ResponseBody
    @RequestMapping("/select/all")
    public JsonResult selectAllByUserId(String messageUserId){
        JsonResult js;
        try{
            List list = messageService.queryAllByUserId(messageUserId);
            js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }

    /**
     * 根据消息ID查询消息详情
     * @param messageId
     * @return
     */
    @ResponseBody
    @RequestMapping("/querybyid")
    public Object queryMessageByMessageId(String messageId){
        JsonResult result=null;
        try{
            Message message=messageService.queryMessageByMessageId(messageId);
            if(message!=null){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",message);
            }else{
                result=new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch(Exception e){
                result=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return result;
    }

    /**
     * 查询未读信息数量
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/querynum")
    public Object queryMessageNum(String userId){
        JsonResult result=null;
        try{
            int num=messageService.queryMessageNum(userId);
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
     * 添加消息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(String messageContent,String messageTitle,String messageUserId){
        JsonResult result=null;
        try{
            int num=messageService.insert(messageContent,messageTitle,messageUserId);
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
     * 删除消息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteByPrimaryKey(String messageId){
        JsonResult result=null;
        try{
            int num=messageService.deleteByPrimaryKey(messageId);
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
