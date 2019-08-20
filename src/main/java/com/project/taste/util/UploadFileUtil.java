package com.project.taste.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传文件工具类
 */
public class UploadFileUtil {
    public static String upload(MultipartFile file, String fileExt) throws IOException {
        // 重构文件名称
        String pikId = UUID.randomUUID().toString().replaceAll("-", "");
        String newFileName = pikId + "." + fileExt;
        String path = "C:/taste/file";
        File dest = new File(path);
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        //保存文件
        File fileSave = new File(path, newFileName);
        file.transferTo(fileSave);
        return newFileName;
    }
}
