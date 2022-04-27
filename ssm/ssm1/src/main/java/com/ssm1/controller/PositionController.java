package com.ssm1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm1.dto.requestDto.PositionListRequestDto;
import com.ssm1.dto.requestDto.TogglePositionStatusRequestDto;
import com.ssm1.entity.Position;
import com.ssm1.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: bai
 * @date: 2022/4/25 19:33
 * @description:
 */
@Controller
@Api(tags = "职位管理")
@RequestMapping("position")
public class PositionController extends BaseController {

    @Autowired
    private PositionService positionService;

    /**
     * @return: java.lang.String
     * @description: 跳转职位列表
     */
    @GetMapping("toList")
    @ApiOperation(value = "跳转职位列表")
    public String toList() {
        request.getSession().setAttribute("pageName", "职位管理");
        return "position-list";
    }

    @GetMapping("toAddPosition")
    @ApiOperation(value = "跳转新增职位页面")
    public String toAddPosition() {
        request.getSession().setAttribute("pageName", "新增职位");
        return "position-add";
    }

    @GetMapping("goPosition")
    @ApiOperation(value = "跳转查看职位详情")
    public String goPosition() {
        request.getSession().setAttribute("pageName", "职位详情");
        return "position-info";
    }

    @GetMapping("goPositionEdit")
    @ApiOperation(value = "跳转修改职位详情")
    public String goPositionEdit() {
        request.getSession().setAttribute("pageName", "修改职位");
        return "position-update";
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
    public Map<String, Object> getList(@RequestBody PositionListRequestDto requestDto) {
        Map<String, Object> map = null;
        try {
            map = positionService.queryPageList(requestDto);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }

    @ApiOperation(value = "对单个职位的状态进行切换")
    @PostMapping("togglePositionStatus")
    @ResponseBody
    public Map<String, Object> togglePositionStatus(@RequestBody TogglePositionStatusRequestDto requestDto) {
        Map<String, Object> map = null;
        try {
            map = positionService.toggleStatus(requestDto);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }

    /**
     * @RequestParam String positionStr
     */
    @PostMapping("insertPosition")
    @ResponseBody
    @ApiOperation(value = "新增职位")
    public Map<String, Object> insertPosition(@RequestParam String positionStr) {
        Map<String, Object> map = new HashMap<>();
        Position position = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            position = mapper.readValue(positionStr, Position.class);
        } catch (JsonProcessingException e) {
            map.put("success", false);
            map.put("errMsg", "传入的json格式不对");
            return map;
        }
        try {
            positionService.insert(position);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        return map;
    }

    @PostMapping("queryPosition")
    @ApiOperation(value = "查看指定职位信息")
    @ResponseBody
    public Map<String, Object> queryPositionById(Integer positionId) {
        Map<String, Object> map = new HashMap<>();
        Position position = null;
        try {
            position = positionService.queryById(positionId);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        map.put("data", position);
        return map;
    }

    @PostMapping("editPosition")
    @ApiOperation(value = "修改指定职位信息")
    @ResponseBody
    public Map<String, Object> editPositionById(@RequestParam String positionStr) {
        Map<String, Object> map = new HashMap<>();
        Position position = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            position = mapper.readValue(positionStr, Position.class);
        } catch (JsonProcessingException e) {
            map.put("success", false);
            map.put("errMsg", "传入的json格式不对");
            return map;
        }
        try {
            positionService.update(position);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        return map;
    }
    @ApiOperation(value = "查询有效职位列表数据")
    @PostMapping("queryActivePositionList")
    @ResponseBody
    public Map<String, Object> queryActivePositionList() {
        Map<String, Object> map = null;
        try {
            map = positionService.queryActivePositionList();
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }

}
