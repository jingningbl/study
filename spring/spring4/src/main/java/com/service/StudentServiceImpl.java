package com.service;

import com.pojo.MyResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author bai
 * @version V1.0
 * @Package com.service
 * @date 2022/2/19 14:02
 * @describe
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Override
    public MyResult queryStudent() {
//        long start = System.currentTimeMillis();
        try {
//            模拟耗时
            TimeUnit.SECONDS.sleep(1);
            System.out.println("正在处理....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("queryStudent接口耗时:"+(System.currentTimeMillis()-start)+"毫秒");
        MyResult myResult = new MyResult();
        myResult.setId(1);
        myResult.setName("木子");
        return myResult;
    }
}
