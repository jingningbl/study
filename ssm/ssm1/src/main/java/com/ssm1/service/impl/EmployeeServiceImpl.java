package com.ssm1.service.impl;

import com.ssm1.dao.EmployeeDao;
import com.ssm1.dto.responseDto.EmployeeDto;
import com.ssm1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 员工表(Employee)表服务实现类
 *
 * @author makejava
 * @since 2022-04-16 17:28:56
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public EmployeeDto getEmInfoByUsernameAndPassword(String username, String password) {
        return employeeDao.getEmInfoByUsernameAndPassword(username,password);
    }
}
