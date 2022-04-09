package com.springboot1.controller;

import com.springboot1.entity.Student;
import com.springboot1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/2 17:13
 * @describe
 */
@RestController
@RequestMapping("rexception")
public class ExceptionRestController {
    @Autowired
    private StudentService studentService;

    @GetMapping("toList")
    public Map<String, Object> toList() {
        Map<String, Object> result = new HashMap<>();
        List<Student> studentList = studentService.selectList();
        result.put("success", true);
        result.put("data", studentList);
        return result;
    }
}
