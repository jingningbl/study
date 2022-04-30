package com.ssm1.controller;

import com.ssm1.entity.ExpenseReportDetail;
import com.ssm1.service.ExpenseReportDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 报销单细节表(ExpenseReportDetail)表控制层
 *
 * @author makejava
 * @since 2022-04-30 18:55:49
 */
@RestController
@RequestMapping("expenseReportDetail")
public class ExpenseReportDetailController {
    /**
     * 服务对象
     */
    @Resource
    private ExpenseReportDetailService expenseReportDetailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ExpenseReportDetail selectOne(Integer id) {
        return this.expenseReportDetailService.queryById(id);
    }

}
