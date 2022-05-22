package com.springMvc4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: bai
 * @date: 2022/5/21 9:48
 * @description:
 */
@Controller
public class MyController {

    @RequestMapping(value = "toPage1", method = RequestMethod.GET)
    public String toPage1() {
        return "page1";
    }

    @RequestMapping(value = "toPage2", method = RequestMethod.GET)
    public String toPage2() {
        return "page2";
    }

    @RequestMapping(value = "toPage3", method = RequestMethod.GET)
    public String toPage3() {
        return "page3";
    }
}
