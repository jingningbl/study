package com.springMvc3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: bai
 * @date: 2022/5/14 9:51
 * @description:
 */
@Controller
public class MyController2 {

    @RequestMapping("myController2")
    public ModelAndView execute() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "Hello World");
        modelAndView.setViewName("page1");
        return modelAndView;
    }
}
