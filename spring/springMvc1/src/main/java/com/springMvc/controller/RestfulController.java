package com.springMvc.controller;

import com.springMvc.pojo.Student;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.springMvc.controller
 * @date 2022/3/5 13:32
 * @describe
 */
@RequestMapping("restful")
@Controller
//局部配置跨域问题
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
public class RestfulController {
    @GetMapping("request")
    @ResponseBody
    public String getRequest(Student student) {
        System.out.println(student);
        return "{\n" +
                "  \"username\": \"张三get\",\n" +
                "  \"age\": 18,\n" +
                "  \"ladies\": {\n" +
                "    \"username\": \"小红\",\n" +
                "    \"age\": 90,\n" +
                "    \"ladies\": \"老王\"\n" +
                "  }\n" +
                "}";
    }

    @PostMapping("request")
    @ResponseBody
    public String postRequest(Student student) {
        System.out.println(student);
        return "{\n" +
                "  \"username\": \"张三post\",\n" +
                "  \"age\": 18,\n" +
                "  \"ladies\": {\n" +
                "    \"username\": \"小红\",\n" +
                "    \"age\": 90,\n" +
                "    \"ladies\": \"老王\"\n" +
                "  }\n" +
                "}";
    }

    @PutMapping("request")
    @ResponseBody
    public String putRequest(Student student) {
        System.out.println(student);
        return "{\n" +
                "  \"username\": \"张三put\",\n" +
                "  \"age\": 18,\n" +
                "  \"ladies\": {\n" +
                "    \"username\": \"小红\",\n" +
                "    \"age\": 90,\n" +
                "    \"ladies\": \"老王\"\n" +
                "  }\n" +
                "}";
    }

    @DeleteMapping("request")
    @ResponseBody
    public String deleteRequest(Student student) {
        System.out.println(student);
        return "{\n" +
                "  \"username\": \"张三delete\",\n" +
                "  \"age\": 18,\n" +
                "  \"ladies\": {\n" +
                "    \"username\": \"小红\",\n" +
                "    \"age\": 90,\n" +
                "    \"ladies\": \"老王\"\n" +
                "  }\n" +
                "}";
    }

    @GetMapping("getJson")
    @ResponseBody
    public List<Student> getJson() {
        List<Student> list = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Student student = new Student();
            student.setUsername("木子" + i);
            student.setAge(18);
            student.setBirthday(new Date());
            list.add(student);
        }
        return list;
    }

    @GetMapping("getDate")
    @ResponseBody
//    public List<Student> getDate(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
    public List<Student> getDate(Student param) {
        System.out.println(param);
        List<Student> list = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Student student = new Student();
            student.setUsername("木子" + i);
            student.setAge(18);
            student.setBirthday(new Date());
            list.add(student);
        }
        return list;
    }
}
