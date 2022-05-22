package com.springMvc3.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: bai
 * @date: 2022/5/14 9:51
 * @description:
 */
public class MyController1 implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Hello World");
        modelAndView.setViewName("/WEB-INF/page/page1.jsp");
        return modelAndView;
    }
}
