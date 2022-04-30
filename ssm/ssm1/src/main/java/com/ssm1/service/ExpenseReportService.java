package com.ssm1.service;

import com.ssm1.entity.ExpenseReport;
import java.util.List;

/**
 * 报销单表(ExpenseReport)表服务接口
 *
 * @author makejava
 * @since 2022-04-30 18:55:08
 */
public interface ExpenseReportService {

    /**
     * 通过ID查询单条数据
     *
     * @param expenseId 主键
     * @return 实例对象
     */
    ExpenseReport queryById(Integer expenseId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ExpenseReport> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param expenseReport 实例对象
     * @return 实例对象
     */
    ExpenseReport insert(ExpenseReport expenseReport);

    /**
     * 修改数据
     *
     * @param expenseReport 实例对象
     * @return 实例对象
     */
    ExpenseReport update(ExpenseReport expenseReport);

    /**
     * 通过主键删除数据
     *
     * @param expenseId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer expenseId);

}
