package com.springMvc4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: bai
 * @date: 2022/5/20 8:25
 * @description:
 */
@Controller
public class Controller1 {
    @RequestMapping(value = "controller1", method = RequestMethod.GET)
    public void params(int param1, float param2, double param3, char param4,
                       boolean param5, long param6, HttpServletResponse response) throws IOException {
        System.out.println("int:" + param1);
        System.out.println("float:" + param2);
        System.out.println("double:" + param3);
        System.out.println("char:" + param4);
        System.out.println("boolean:" + param5);
        System.out.println("long:" + param6);
        response.getWriter().print("OK");
    }
}
