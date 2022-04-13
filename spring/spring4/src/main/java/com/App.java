package com;

import com.service.IStudentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @Package com
 * @date 2022/2/19 14:06
 * @describe
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        IStudentService bean = context.getBean(IStudentService.class);
        bean.queryStudent();
    }
}
