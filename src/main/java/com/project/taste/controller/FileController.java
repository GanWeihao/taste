package com.project.taste.controller;


import com.project.taste.util.Constants;
import com.project.taste.util.JsonResult;
import com.project.taste.util.UploadFileUtil;
import io.swagger.annotations.Api;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@CrossOrigin
@Controller
@RequestMapping("/upload")
@Api(tags = "文件上传控制器")
public class FileController {

    /**
     * 上传单个图片
     * 只支持jpg/png格式
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public JsonResult upload(@RequestParam("file") MultipartFile file) {
        JsonResult js;
        try {
            //判断文件是否为空
            if (file == null || file.isEmpty()) {
                return new JsonResult(Constants.STATUS_FAIL, "请选择您要上传的文件");
            }
            if (file.getSize() > 2097152) {
                return new JsonResult(Constants.STATUS_FAIL, "图片不能大于2MB");
            }
            String reg = "(jpg|png|gif)";
            Pattern pattern = Pattern.compile(reg);
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            if (pattern.matcher(fileExt).find()) {
                String newFileName = UploadFileUtil.upload(file, fileExt);
                js = new JsonResult(Constants.STATUS_SUCCESS, "上传成功", newFileName);
            } else {
                return new JsonResult(Constants.STATUS_FAIL, "图片格式有误，请重新选择");
            }

        } catch (Exception e) {
            js = new JsonResult(Constants.STATUS_FAIL, "上传异常");
        }
        return js;
    }

    /**
     * 上传多个图片
     * 只支持jpg/png格式
     * @param files
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/images", method = RequestMethod.POST)
    public JsonResult upload(@RequestParam("files") MultipartFile[] files) {
        JsonResult js;
        try {
            //判断文件是否为空
            if(files.length<=0){
                return new JsonResult(Constants.STATUS_FAIL, "请选择您要上传的文件");
            }
            String reg = "(jpg|png|gif)";
            Pattern pattern = Pattern.compile(reg);
            List list = new ArrayList<>();
            for(MultipartFile file : files){
                //获取文件后缀
                String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                if (pattern.matcher(fileExt).find()) {
                    String newFileName = UploadFileUtil.upload(file, fileExt);
                    list.add(newFileName);
                }
            }
            if(list.size()>0){
                js = new JsonResult(Constants.STATUS_SUCCESS, "上传成功", list);
            }else {
                js = new JsonResult(Constants.STATUS_FAIL, "上传失败，请稍后重试");
            }
        } catch (Exception e) {
            js = new JsonResult(Constants.STATUS_FAIL, "上传异常");
        }
        return js;
    }

    /**
     * 上传视频
     * 只支持mp4|flv|avi|rm|rmvb|wmv
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/video", method = RequestMethod.POST)
    public JsonResult uploadVideo(@RequestParam("file") MultipartFile file){
        JsonResult js;
        try{
            if (file == null || file.isEmpty()) {
                return new JsonResult(Constants.STATUS_FAIL, "请选择您要上传的文件");
            }
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            String reg = "(mp4|flv|avi|rm|rmvb|wmv)";
            Pattern pattern = Pattern.compile(reg);
            if (pattern.matcher(fileExt).find()) {
                String newFileName = UploadFileUtil.upload(file, fileExt);
                js = new JsonResult(Constants.STATUS_SUCCESS, "上传成功", newFileName);
            } else {
                return new JsonResult(Constants.STATUS_FAIL, "视频格式有误，请重新上传");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"上传异常");
        }
        return js;
    }

    /**
     * 上传Base64图片
     */
    @RequestMapping("/base64")
    @ResponseBody
    public JsonResult saveBase64(@RequestParam(value = "img") String base64Str) throws IOException {
        JsonResult js;
        System.out.println(base64Str);

        String fileName = UploadFileUtil.base64CodeToimage(base64Str);
        if(fileName!=null){
            js = new JsonResult(Constants.STATUS_SUCCESS,"上传成功",fileName);
        }else{
            js = new JsonResult(Constants.STATUS_FAIL,"长传失败");
        }
        return js;
    }
}
