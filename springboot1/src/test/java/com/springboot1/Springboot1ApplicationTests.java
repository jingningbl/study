package com.springboot1;

import com.springboot1.dao.TeachInfoDao;
import com.springboot1.entity.TeachInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Springboot1ApplicationTests {

    @Resource
    private TeachInfoDao teachInfoDao;

    @Test
    void contextLoads() {
        TeachInfo teachInfo = teachInfoDao.queryById(1);
        System.out.println(teachInfo);
    }

}
