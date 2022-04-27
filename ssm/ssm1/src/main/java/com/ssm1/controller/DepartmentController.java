package com.ssm1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm1.dto.requestDto.DepartmentListRequestDto;
import com.ssm1.dto.requestDto.ToggleDepartmentStatusRequestDto;
import com.ssm1.entity.Department;
import com.ssm1.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: bai
 * @date: 2022/4/19 19:52
 * @description: 部门管理
 */
@Controller
@Api(tags = "部门管理")
@RequestMapping("department")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * @return: java.lang.String
     * @description: 跳转部门列表
     */
    @GetMapping("toList")
    @ApiOperation(value = "跳转部门列表")
    public String toList() {
        request.getSession().setAttribute("pageName", "部门管理");
        return "department-list";
    }

    @GetMapping("toAddDepartment")
    @ApiOperation(value = "跳转新增部门页面")
    public String toAddDepartment() {
        request.getSession().setAttribute("pageName", "新增部门");
        return "department-add";
    }

    @GetMapping("goDepartment")
    @ApiOperation(value = "跳转查看部门详情")
    public String goDepartment() {
        request.getSession().setAttribute("pageName", "部门详情");
        return "department-info";
    }

    @GetMapping("goDepartmentEdit")
    @ApiOperation(value = "跳转修改部门详情")
    public String goDepartmentEdit() {
        request.getSession().setAttribute("pageName", "修改部门");
        return "department-update";
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
    public Map<String, Object> getList(@RequestBody DepartmentListRequestDto departmentListRequestDto) {
        Map<String, Object> map = null;
        try {
            map = departmentService.queryPageList(departmentListRequestDto);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }

    @ApiOperation(value = "对单个部门的状态进行切换")
    @PostMapping("toggleDepartmentStatus")
    @ResponseBody
    public Map<String, Object> toggleDepartmentStatus(@RequestBody ToggleDepartmentStatusRequestDto requestDto) {
        Map<String, Object> map = null;
        try {
            map = departmentService.toggleStatus(requestDto);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }

    /**
     * @RequestParam String departmentStr
     */
    @PostMapping("insertDepartment")
    @ResponseBody
    @ApiOperation(value = "新增部门")
    public Map<String, Object> insertDepartment(@RequestParam String departmentStr) {
        Map<String, Object> map = new HashMap<>();
        Department department = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            department = mapper.readValue(departmentStr, Department.class);
        } catch (JsonProcessingException e) {
            map.put("success", false);
            map.put("errMsg", "传入的json格式不对");
            return map;
        }
        try {
            departmentService.insert(department);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        return map;
    }

    @PostMapping("queryDepartment")
    @ApiOperation(value = "查看指定部门信息")
    @ResponseBody
    public Map<String, Object> queryDepartmentById(Integer departmentId) {
        Map<String, Object> map = new HashMap<>();
        Department department = null;
        try {
            department = departmentService.queryById(departmentId);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        map.put("data", department);
        return map;
    }

    @PostMapping("editDepartment")
    @ApiOperation(value = "修改指定部门信息")
    @ResponseBody
    public Map<String, Object> editDepartmentById(@RequestParam String departmentStr) {
        Map<String, Object> map = new HashMap<>();
        Department department = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            department = mapper.readValue(departmentStr, Department.class);
        } catch (JsonProcessingException e) {
            map.put("success", false);
            map.put("errMsg", "传入的json格式不对");
            return map;
        }
        try {
            departmentService.update(department);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        return map;
    }

    @ApiOperation(value = "查询有效的部门数据")
    @PostMapping("queryActiveDepartmentList")
    @ResponseBody
    public Map<String, Object> queryActiveDepartmentList() {
        Map<String, Object> map = null;
        try {
            map = departmentService.queryActiveDepartmentList();
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }
}
