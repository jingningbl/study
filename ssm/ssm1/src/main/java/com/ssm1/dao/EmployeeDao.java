package com.ssm1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssm1.dto.responseDto.EmployeeDto;
import com.ssm1.entity.Employee;
import org.apache.ibatis.annotations.Param;

/**
 * 员工表(Employee)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-16 17:28:56
 */
public interface EmployeeDao extends BaseMapper<Employee> {
    /**
     * @param username:
     * @param password:
     * @return: com.ssm1.dto.responseDto.EmployeeDto
     * @description: @Param("username") mybatis传多个参数必不可少
     */
    EmployeeDto getEmInfoByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
