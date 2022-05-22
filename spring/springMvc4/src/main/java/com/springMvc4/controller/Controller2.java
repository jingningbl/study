package com.springMvc4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author: bai
 * @date: 2022/5/20 8:25
 * @description:
 */
@Controller
public class Controller2 {
    @RequestMapping(value = "controller2", method = RequestMethod.GET)
    public void params(String[] hobby, HttpServletResponse response) throws IOException {
        System.out.println("学科:" + Arrays.toString(hobby));
        response.getWriter().print("OK");
    }

    @RequestMapping(value = "controller3", method = RequestMethod.GET)
    public void paramsList(@RequestParam("foods") List<String> foods, HttpServletResponse response) throws IOException {
        System.out.println("食物:"+foods);
        response.getWriter().print("OK");
    }
}
