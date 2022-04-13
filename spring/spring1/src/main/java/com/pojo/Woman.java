package com.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/2/4 11:40
 * @describe
 */
public class Woman  {
    private String name;
    private int age;
    private String outlook;
    private ApplicationContext applicationContext;

    public Woman() {
//        System.out.println("无参构造器");
    }

    public Woman(String name, int age, String outlook) {
        this.name = name;
        this.age = age;
        this.outlook = outlook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOutlook() {
        return outlook;
    }

    public void setOutlook(String outlook) {
        this.outlook = outlook;
    }

    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", outlook='" + outlook + '\'' +
                '}';
    }

//    @Override
//    public void setBeanName(String name) {
//        System.err.println(name);
//    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.err.println(applicationContext);
//        this.applicationContext = applicationContext;
//    }

//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.err.println("setBeanFactory:" + beanFactory);
//        for (String beanDefinitionName : ((DefaultListableBeanFactory) beanFactory).getBeanDefinitionNames()) {
//            System.err.println(beanDefinitionName);
//        }
//    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("自定义初始化");
//    }

    public void myInit() {
        System.out.println("init-method自定义初始化");
    }

//    @Override
//    public void destroy() throws Exception {
//        System.out.println("自定义销毁了");
//    }
    public void myDestroy(){
        System.out.println("destroy-method自定义销毁");
    }
}
