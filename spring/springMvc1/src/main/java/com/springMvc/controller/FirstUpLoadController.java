package com.springMvc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author bai
 * @version V1.0
 * @Package com.springMvc.controller
 * @date 2022/3/9 17:53
 * @describe
 */
@RestController
@RequestMapping("firstUpload")
public class FirstUpLoadController {
    //    上传到的文件夹
    private static final String FILE_PATH = "D:\\IDEA\\Maven\\spring\\springMvc1\\upload";

    @PostMapping("upload")
    public String upLoad(MultipartFile file) throws IOException {
//        获取文件
        String originalFilename = file.getOriginalFilename();
//        截取文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
//        拼接文件名
        String fileName = System.currentTimeMillis() + suffix;
//        上传
        file.transferTo(new File(FILE_PATH + File.separator + fileName));
        return "成功";
    }
}
