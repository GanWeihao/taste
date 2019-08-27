package com.project.taste.util;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.UUID;


/**
 * 上传文件工具类
 */
public class UploadFileUtil {
    public static String upload(MultipartFile file, String fileExt) throws IOException {
        // 重构文件名称
        String pikId = UUID.randomUUID().toString().replaceAll("-", "");
        String newFileName = pikId + "." + fileExt;
        String path = "/usr/taste/file";
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


    public static String getImageBase64code(String iamgePath) {
        try {
            File file = new File(iamgePath);
            FileInputStream fs;

            fs = new FileInputStream(file);

            byte[] data = new byte[fs.available()];
            fs.read(data);
            fs.close();
            BASE64Encoder be = new BASE64Encoder();

            return be.encode(data);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static String base64CodeToimage(String basee64code) throws IOException {
        if (basee64code == null){
            return null;// 图像数据为空
        }
        BASE64Decoder decoder = new BASE64Decoder();
        //byte[] b = decoder.decodeBuffer(basee64code.replace("data:image/jpeg;base64,", ""));//去除base64中无用的部分
        OutputStream out = null;
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        String newFileName = "";
        if (basee64code.indexOf("data:image/png;") != -1) {
            newFileName = id+".png";
        }else if(basee64code.indexOf("data:image/jpeg;") != -1){
            newFileName = id+".jpeg";
        }else if(basee64code.indexOf("data:image/gif;") != -1){
            newFileName = id+".gif";
        }else{
            return null;
        }
        try {
            basee64code.replaceAll(" ", "+");
            basee64code = basee64code.substring(basee64code.indexOf(",")+1);
            out = new FileOutputStream("/usr/taste/file/"+newFileName);
            // Base64解码
            byte[] b = decoder.decodeBuffer(basee64code);

            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            out.write(b);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            return newFileName;
        }
    }

}
