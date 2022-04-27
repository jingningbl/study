package com.ssm1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm1.dto.requestDto.EmployeeListRequestDto;
import com.ssm1.entity.Employee;
import com.ssm1.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: bai
 * @date: 2022/4/26 14:00
 * @description:
 */
@Controller
@Api(tags = "员工管理")
@RequestMapping("employee")
public class EmployeeController extends BaseController{
    
    @Autowired
    private EmployeeService employeeService;

    /**
     * @return: java.lang.String
     * @description: 跳转员工列表
     */
    @GetMapping("toList")
    @ApiOperation(value = "跳转员工列表")
    public String toList() {
        request.getSession().setAttribute("pageName", "员工管理");
        return "employee-list";
    }

    @GetMapping("toAddEmployee")
    @ApiOperation(value = "跳转新增员工页面")
    public String toAddEmployee() {
        request.getSession().setAttribute("pageName", "新增员工");
        return "employee-add";
    }

    @GetMapping("goEmployee")
    @ApiOperation(value = "跳转查看员工详情")
    public String goEmployee() {
        request.getSession().setAttribute("pageName", "员工详情");
        return "employee-info";
    }

    @GetMapping("goEmployeeEdit")
    @ApiOperation(value = "跳转修改员工详情")
    public String goEmployeeEdit() {
        request.getSession().setAttribute("pageName", "修改员工");
        return "employee-update";
    }

    /**
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @description: 查询列表数据
     * @ResponseBody: 将Map转化为json字符串
     * @RequestBody: 接收json字符串, 这里传值为json对象, 不需要
     */
    @ApiOperation(value = "查询列表数据(包括分页,模糊,条件查询)")
    @PostMapping("getList")
    @ResponseBody
    public Map<String, Object> getList(@RequestBody EmployeeListRequestDto requestDto) {
        Map<String, Object> map = null;
        try {
            map = employeeService.queryPageList(requestDto);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }
//
//    @ApiOperation(value = "对单个员工的状态进行切换")
//    @PostMapping("toggleEmployeeStatus")
//    @ResponseBody
//    public Map<String, Object> toggleEmployeeStatus(@RequestBody ToggleEmployeeStatusRequestDto requestDto) {
//        Map<String, Object> map = null;
//        try {
//            map = employeeService.toggleStatus(requestDto);
//        } catch (Exception e) {
//            map = new HashMap<>();
//            map.put("success", false);
//            map.put("errMsg", e.getMessage());
//        }
//        return map;
//    }
//
//    /**
//     * @RequestParam String employeeStr
//     */
//    @PostMapping("insertEmployee")
//    @ResponseBody
//    @ApiOperation(value = "新增员工")
//    public Map<String, Object> insertEmployee(@RequestParam String employeeStr) {
//        Map<String, Object> map = new HashMap<>();
//        Employee employee = null;
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            employee = mapper.readValue(employeeStr, Employee.class);
//        } catch (JsonProcessingException e) {
//            map.put("success", false);
//            map.put("errMsg", "传入的json格式不对");
//            return map;
//        }
//        try {
//            employeeService.insert(employee);
//        } catch (Exception e) {
//            map.put("success", false);
//            map.put("errMsg", e.getMessage());
//            return map;
//        }
//        map.put("success", true);
//        return map;
//    }
//
//    @PostMapping("queryEmployee")
//    @ApiOperation(value = "查看指定员工信息")
//    @ResponseBody
//    public Map<String, Object> queryEmployeeById(Integer employeeId) {
//        Map<String, Object> map = new HashMap<>();
//        Employee employee = null;
//        try {
//            employee = employeeService.queryById(employeeId);
//        } catch (Exception e) {
//            map.put("success", false);
//            map.put("errMsg", e.getMessage());
//            return map;
//        }
//        map.put("success", true);
//        map.put("data", employee);
//        return map;
//    }
//
//    @PostMapping("editEmployee")
//    @ApiOperation(value = "修改指定员工信息")
//    @ResponseBody
//    public Map<String, Object> editEmployeeById(@RequestParam String employeeStr) {
//        Map<String, Object> map = new HashMap<>();
//        Employee employee = null;
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            employee = mapper.readValue(employeeStr, Employee.class);
//        } catch (JsonProcessingException e) {
//            map.put("success", false);
//            map.put("errMsg", "传入的json格式不对");
//            return map;
//        }
//        try {
//            employeeService.update(employee);
//        } catch (Exception e) {
//            map.put("success", false);
//            map.put("errMsg", e.getMessage());
//            return map;
//        }
//        map.put("success", true);
//        return map;
//    }
}
