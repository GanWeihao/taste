package com.project.taste.controller;

import com.project.taste.service.ContentService;
import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class ContentController {
    @Autowired
    ContentService contentService;

    /**
     * 根据文章ID删除文章内容
     * @param contentArticleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/content/delete")
    public JsonResult deleteContent(String contentArticleId){
        JsonResult js;
        try{
            int i = contentService.deleteByArticleId(contentArticleId);
            if(i!=0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"删除成功",i);
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"删除失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"删除异常");
        }
        return js;
    }
}
