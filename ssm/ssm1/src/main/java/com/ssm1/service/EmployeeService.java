package com.ssm1.service;

import com.ssm1.dto.responseDto.EmployeeDto;

/**
 * 员工表(Employee)表服务接口
 *
 * @author makejava
 * @since 2022-04-16 17:28:56
 */
public interface EmployeeService{
    /**
     * @param username:
     * @param password:
     * @return: com.ssm1.dto.responseDto.EmployeeDto
     * @description:通过用户名密码查询用户信息
     */
    EmployeeDto getEmInfoByUsernameAndPassword(String username, String password);
}
