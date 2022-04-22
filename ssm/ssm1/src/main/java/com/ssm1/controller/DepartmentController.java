package com.ssm1.controller;

import com.ssm1.dto.requestDto.DepartmentListRequestDto;
import com.ssm1.dto.requestDto.ToggleDepartmentStatusRequestDto;
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

    /**
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @description: 查询列表数据
     * @ResponseBody: 将Map转化为json字符串
     * @RequestBody: 接收json字符串, 这里传值为json对象, 不需要
     */
    @ApiOperation(value = "查询列表数据(包括分页,模糊,条件查询)")
    @PostMapping("getList")
    @ResponseBody
    public Map<String, Object> getList(DepartmentListRequestDto departmentListRequestDto) {
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
    public Map<String, Object> toggleDepartmentStatus(@RequestBody ToggleDepartmentStatusRequestDto requestDto) {
        Map<String, Object> map = null;
        try {
            map=departmentService.toggleStatus(requestDto);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }
}
