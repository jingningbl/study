package com.ssm1.controller;

import com.ssm1.service.ExpenseReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 报销单表(ExpenseReport)表控制层
 *
 * @author makejava
 * @since 2022-04-30 18:55:08
 */
@Controller
@RequestMapping("expenseReport")
@Api(tags = "报销单管理")
public class ExpenseReportController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private ExpenseReportService expenseReportService;

    @ApiOperation(value = "跳转至报销单路由")
    @GetMapping("toList")
    public String toList() {
        request.getSession().setAttribute("pageName", "报销单管理");
        return "expense-report-list";
    }

    @ApiOperation(value = "跳转至新增报销单路由")
    @GetMapping("toAddExpenseReport")
    public String toAddExpenseReport() {
        request.getSession().setAttribute("pageName", "新增报销单");
        return "expense-report-add1";
    }

}
