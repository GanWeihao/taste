package com.project.taste.controller;

import com.project.taste.service.impl.AttentionServiceImpl;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class AttentionController {
    @Autowired
    AttentionServiceImpl attentionService;
    /**
     * 根据用户id查询用户的关注数量
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/attention/querynum")
    public Object queryNum(String userId) {
        JsonResult result = null;
        try {
            int s = attentionService.queryNum(userId);
            if (s != 0) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", s);
                return result;
            }if(s==0){
                result=new JsonResult(Constants.STATUS_SUCCESS, "查询成功", s);
                return  result;
            }
            else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "查询异常", e.getMessage());
        }
        return result;
    }



    /**
     * 根据用户id查询用户的粉丝数量
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/fensi/querynum")
    public Object queryNum1(String userId) {
        JsonResult result = null;
        try {
            int s = attentionService.queryNum1(userId);
            if (s != 0) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", s);
                return result;
            }if(s==0){
                result=new JsonResult(Constants.STATUS_SUCCESS, "查询成功", s);
                return  result;
            }
            else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "查询异常", e.getMessage());
        }
        return result;
    }


    /**
     * 添加关注
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/attention/insert")
    public Object insert(String attentionUserId,String attentionTouserId) {
        JsonResult result = null;
        try {
            int s = attentionService.insert(attentionUserId,attentionTouserId);
            if (s != 0) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "添加成功",s);

            }
            else {
                result = new JsonResult(Constants.STATUS_FAIL, "添加失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "查询异常", e.getMessage());
        }
        return result;
    }


    /**
     * 取消关注
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/attention/delete")
    public Object deleteByPrimaryKey (String attentionUserId,String attentionTouserId) {
        JsonResult result = null;
        try {
            int s = attentionService.insert(attentionUserId,attentionTouserId);
            if (s != 0) {
                result = new JsonResult(Constants.STATUS_SUCCESS, "取消关注",s);

            }
            else {
                result = new JsonResult(Constants.STATUS_FAIL, "取消关注失败");
            }
        } catch (Exception e) {
            result = new JsonResult(Constants.STATUS_ERROR, "取消关注异常", e.getMessage());
        }
        return result;
    }
}
