package com.springboot1.controller;

import com.springboot1.entity.TeachInfo;
import com.springboot1.service.TeachInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TeachInfo)表控制层
 *
 * @author makejava
 * @since 2022-04-02 15:28:41
 */
@RestController
@RequestMapping("teachInfo")
public class TeachInfoController {
    /**
     * 服务对象
     */
    @Resource
    private TeachInfoService teachInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TeachInfo selectOne(Integer id) {
        return this.teachInfoService.queryById(id);
    }

}
