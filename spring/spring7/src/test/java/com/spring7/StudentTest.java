package com.spring7;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/8 8:57
 * @describe
 */
public class StudentTest {
    /**
     * 属性注入
     */
    @Test
    public void testStudent1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

    /**
     * 构造器注入
     */
    @Test
    public void testStudent2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        StudentClass aClass = context.getBean("aClass", StudentClass.class);
        System.out.println(aClass);
    }

    /**
     * 测试SpringBean的配置以及作用域
     * 当为单例时,多次调用拿到同一个对象
     */
    @Test
    public void testStudent3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        Student student1 = context.getBean("student1", Student.class);
        System.out.println(student1);
        Student student2 = context.getBean("student1", Student.class);
        System.out.println(student2);
        System.out.println(student1.hashCode() == student2.hashCode());
        context.registerShutdownHook();
    }
}
