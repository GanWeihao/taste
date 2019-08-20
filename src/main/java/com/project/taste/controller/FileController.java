package com.project.taste.controller;


import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
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
     * 上传单个文件
     *
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public JsonResult upload(@RequestParam("file") MultipartFile file) {
        JsonResult js;
        try {
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存视频
            File fileSave = new File("C:\\taste\\file", newVidoeName);
            file.transferTo(fileSave);
            js = new JsonResult(Constants.STATUS_SUCCESS,"上传成功",newVidoeName);
        } catch (Exception e) {
            js = new JsonResult(Constants.STATUS_FAIL,"上传异常");
        }
        return js;
    }
}
