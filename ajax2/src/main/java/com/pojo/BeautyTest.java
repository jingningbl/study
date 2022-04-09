package com.pojo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * @title: BeautyTest
 * @projectName vip2105-web
 * @description: TODO
 * @date 2022/1/13 20:57
 */
public class BeautyTest {
    public static void main(String[] args) throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //获得他的class对象
        //Beauty b=new Beauty();
        Class clazz1 = Class.forName("com.pojo.Beauty");//推荐写法
        System.out.println(clazz1.getName());
        System.out.println(clazz1.getSimpleName());
        //以下两种也可以获取class对象,但是没有体现动态意义
        Class clazz2 = Beauty.class;
        //Class clazz3=new Beauty().getClass();

        //获得对象
        //返回的是一个Object类型
        //默认调用无参数构造器
        Object obj1 = clazz1.newInstance();
        System.out.println(obj1);

        //获得构造器对象:有参数的构造器有可能有多个,需要根据参数的类别去匹配
        //参数类型,对应的是构造器里面参数的类型.class
        Constructor<Beauty> cb = clazz1.getConstructor(String.class, Integer.class);
        //访问构造器,参数对应的是构造器的参数
        Object obj2 = cb.newInstance("高圆圆", 22);
        if (obj2 instanceof Beauty) {
            Beauty b = (Beauty) obj2;
            System.out.println(b.getName());
        }
        //Method
        //1.获得所有自己生命的方法,包括私有方法
        Method[] ms = clazz1.getDeclaredMethods();
        for (Method m : ms) {
            System.out.println("方法名:" + m.getName());
            System.out.println("方法的访问修饰符:" + m.getModifiers());
            System.out.println("方法的返回类型:" + m.getReturnType().getName());
            System.out.println("方法的参数列表个数:" + m.getParameterCount());
            //针对私有方法
            if (m.getName().contains("f1")) {
                //私有方法不能直接调用访问,需要修改访问权限
                //非常不推荐直接访问私有的,这样会破坏Java的封装性
                m.setAccessible(true);
                System.out.println("111111111111111111");
                m.invoke(obj2, "123");
            }
        }
        //2.获得指定的方法("方法名",参数列表)
        Method mymethod = clazz1.getMethod("setAge", Integer.class);
        System.out.println("参数列表");
        Class<?>[] pm = mymethod.getParameterTypes();
        for (Class<?> c : pm) {
            System.out.println(c.getName());
        }
        //3.执行方法 invoke(方法所属的对象,参数)
        mymethod.invoke(obj2, 55);
        //4.获得继承过来的方法对象
        System.out.println("=====================================");
        Method[] ms2 = clazz1.getMethods();
        for (Method m : ms2) {
            System.out.println(m.getName());
        }
        //[了解]:针对私有方法
        //直接无法获取私有方法!!!
        //Method pm2=clazz1.getMethod("f1", String.class);
        //System.out.println(pm2.getName());
    }
}
