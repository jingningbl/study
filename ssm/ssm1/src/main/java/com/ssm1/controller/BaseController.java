package com.ssm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: bai
 * @date: 2022/4/16 21:52
 * @description:
 */
@Controller
public class BaseController {

    //多个请求不会共享一个request对象,因为SpringMVC内部使用了ThreadLocal
    @Autowired
    HttpServletRequest request;
}
