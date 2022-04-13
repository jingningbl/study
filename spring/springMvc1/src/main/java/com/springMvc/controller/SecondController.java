package com.springMvc.controller;

import com.springMvc.pojo.Form;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.springMvc.controller
 * @date 2022/2/28 11:09
 * @describe
 */
@Controller
@RequestMapping("second")
public class SecondController {
    @PostMapping("getData")
    @ResponseBody
    public String getData(String username,String goddess,Integer [] reason){
        System.out.println(username+goddess);
        return "success";
    }
    @PostMapping("getData1")
    @ResponseBody
    public String getData1(String username, String goddess, @RequestParam List<Integer>[] reason){
        System.out.println(username+goddess);
        return "success";
    }
    @PostMapping("getData2")
    @ResponseBody
    public String getData2(Form form){
        System.out.println(form);
        return "success";
    }
}
