package com.ssm1.controller;

import com.ssm1.dto.StudentDto;
import com.ssm1.entity.Student;
import com.ssm1.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2022-03-26 11:52:29
 */
@RestController
@RequestMapping("student")
@Api(tags = "课程模块")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

//    /**
//     * 通过主键查询单条数据
//     *
//     * @param
//     * @return 单条数据
//     */
//    @GetMapping("selectOne")
//    @ApiOperation("根据id查询课程信息")
//    public Student selectOne(StudentDto studentDto) {
//        return this.studentService.queryById(studentDto.getId());
//    }

    @PostMapping("test")
    @ApiOperation("测试接口")
    public Map<String, Object> test(@RequestBody StudentDto studentDto) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "木子");
        return map;
    }

}
