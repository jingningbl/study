package com.springboot1.controller;

import com.springboot1.entity.Student;
import com.springboot1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/2 17:13
 * @describe
 */
@Controller
@RequestMapping("exception")
public class ExceptionController {
    @Autowired
    private StudentService studentService;

    @GetMapping("toList")
    public String toList(Model model) {
        if (1 == 1) {
//            throw new LoveException();
            throw new RuntimeException();
//            throw new PasswordException();
        }
        List<Student> studentList = studentService.selectList();
        model.addAttribute("stuList", studentList);
        return "student-list";
    }
}
