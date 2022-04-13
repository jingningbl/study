package com.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bai
 * @version V1.0
 * @Package com.springMvc.controller
 * @date 2022/3/5 12:16
 * @describe
 */
@RequestMapping("freemarker")
@Controller
public class FreeMarkerController {
    @GetMapping("first")
    public String firstRequest(ModelMap modelMap){
        modelMap.addAttribute("username","木子");
        return "my-freeMarker";
    }
}
