package com.service;

import com.dao.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author bai
 * @version V1.0
 * @Package com.service
 * @date 2022/2/15 22:27
 * @describe
 */
@Service
public class TestService {
    @Resource(name = "bai")
    private Animal animal;
    public void animalSay(){
        animal.say();
    }

    @Override
    public String toString() {
        return "TestService{" +
                "animal=" + animal +
                '}';
    }
}
