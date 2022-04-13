package com.springMvc.controller;

import com.springMvc.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bai
 * @version V1.0
 * @Package com.springMvc.controller
 * @date 2022/2/25 12:55
 * @describe
 */
@RequestMapping("first")
@Controller
public class FirstController {
    @RequestMapping("test1")
//    原样输出,不找视图解析器
    @ResponseBody
    public String test1() {
//        spring默认有视图解析器,返回String类型,SpringMVC会找视图,找不到404
        return "123456";
    }

    //    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    @GetMapping("test2")
//    @PostMapping("test2")
    @ResponseBody
    public String test2() {
        return "hello";
    }

    @GetMapping("test3")
    @ResponseBody
    public String test3(HttpServletRequest request, String username, int age) {
        String usernameByRequest = request.getParameter("username");
        String ageByRequest = request.getParameter("age");
        System.out.println(usernameByRequest + ageByRequest);
        System.out.println(username + age);
        return "hello";
    }

    @GetMapping("test4")
    @ResponseBody
    public String test4(Student student) {
        System.out.println(student);
        return "hi";
    }

    @GetMapping("test5")
    @ResponseBody
    /**
     * @RequestParam 参数绑定, 默认绑定的参数必须存在
     * 可以修改 required = false或者 defaultValue = "游客"(默认值)
     */
    public String test5(@RequestParam(value = "user_name", defaultValue = "游客") String username, Integer age) {
        System.out.println(username + age);
        return "haha";
    }

    /**
     * RestFul开发风格
     *
     * @PathVariable 接收url路径中变量的值,
     */
    @GetMapping("test6/{username}")
    @ResponseBody
    public String test6(@PathVariable String username) {
        System.out.println(username);
        return "789";
    }

    @GetMapping("test7")
    @ResponseBody
    public String test7(@CookieValue String nihao) {
        System.out.println(nihao);
        return "000";
    }
}