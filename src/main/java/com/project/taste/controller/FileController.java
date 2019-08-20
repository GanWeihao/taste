package com.project.taste.controller;


import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import com.project.taste.util.UploadFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
public class FileController {

    /**
     * 上传单个图片
     * 只支持jpg/png格式
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public JsonResult upload(@RequestParam("file") MultipartFile file) {
        JsonResult js;

        //判断文件是否为空
        if (file==null || file.isEmpty()) {
            return new JsonResult(Constants.STATUS_FAIL,"请选择您要上传的文件");
        }
        if(file.getSize()>2097152){
            return new JsonResult(Constants.STATUS_FAIL,"图片不能大于2MB");
        }
        try {
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            if(fileExt.equals("png") || fileExt.equals("jpg") || fileExt.equals("PNG") || fileExt.equals("JPG")){
                String newFileName = UploadFileUtil.upload(file, fileExt);
                js = new JsonResult(Constants.STATUS_SUCCESS,"上传成功",newFileName);
            }else{
                return new JsonResult(Constants.STATUS_FAIL,"图片格式有误，请重新选择");
            }

        } catch (Exception e) {
            js = new JsonResult(Constants.STATUS_FAIL,"上传异常"+e.getMessage());
        }
        return js;
    }
}
