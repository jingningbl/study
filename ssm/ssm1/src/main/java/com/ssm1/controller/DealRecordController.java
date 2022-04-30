package com.ssm1.controller;

import com.ssm1.entity.DealRecord;
import com.ssm1.service.DealRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 操作记录表(DealRecord)表控制层
 *
 * @author makejava
 * @since 2022-04-30 18:54:21
 */
@RestController
@RequestMapping("dealRecord")
public class DealRecordController {
    /**
     * 服务对象
     */
    @Resource
    private DealRecordService dealRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DealRecord selectOne(Integer id) {
        return this.dealRecordService.queryById(id);
    }

}
