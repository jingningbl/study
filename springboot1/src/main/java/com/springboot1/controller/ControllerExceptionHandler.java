package com.springboot1.controller;

import com.springboot1.exception.BaseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/2 17:45
 * @describe @ControllerAdvice(前后端不分离使用)与@RestControllerAdvice(前后端分离使用)不可以同时存在
 */
@ControllerAdvice(annotations = Controller.class)
public class ControllerExceptionHandler {
    /**
     * 如果拦截到BaseException
     */
    @ExceptionHandler(BaseException.class)
    public ModelAndView baseExceptionHandler(BaseException baseException) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("base");
        modelAndView.addObject("code", baseException.getCode());
        modelAndView.addObject("msg", baseException.getMsg());
        return modelAndView;
    }

    /**
     * 如果拦截到非BaseException
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView otherExceptionHandler(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("base");
        modelAndView.addObject("code", "99999");
        modelAndView.addObject("msg", "未知异常");
        return modelAndView;
    }
}
