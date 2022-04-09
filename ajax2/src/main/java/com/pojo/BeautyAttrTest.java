package com.pojo;

import java.lang.reflect.Field;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/2/2 11:05
 * @describe
 */
public class BeautyAttrTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> clazz= Class.forName("com.pojo.Beauty");
//        获取自己所有属性,包括私有的
        Field[] fs=clazz.getDeclaredFields();
//        获取指定属性
//        Field f1=clazz.getField("age");
//        获取所有的属性
        Field[] fs2=clazz.getFields();
        for (Field f:fs){
            System.out.println(f.getName());
            if (!f.isAccessible()){
                f.setAccessible(true);
            }
        }
    }
}
