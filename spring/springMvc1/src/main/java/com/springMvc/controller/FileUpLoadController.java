package com.springMvc.controller;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author bai
 * @version V1.0
 * @Package com.springMvc.controller
 * @date 2022/3/9 16:15
 * @describe 文件上传处理器
 */
//@RestController=@Controller+@ResponseBody
@RestController
@RequestMapping("upload")
public class FileUpLoadController {
    private static final String FILE_PATH = "D:\\IDEA\\Maven\\spring\\springMvc1\\upload";

    @PostMapping("fileUpLoad")
    public String fileUpLoad(MultipartFile file) throws IOException {
//        省略这两步,通过MultipartFile获取文件
//        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//        MultipartFile file = multipartHttpServletRequest.getFile("file");
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = System.currentTimeMillis() + suffix;
        file.transferTo(new File(FILE_PATH + File.separator + fileName));
//        InputStream inputStream = file.getInputStream();
//        FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH + File.separator + fileName);
//        int b = 0;
//        while (((b = inputStream.read()) != -1)) {
//            fileOutputStream.write(b);
//        }
        return "成功";
    }
}
