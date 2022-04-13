package com.factory;

import com.pojo.Woman;

/**
 * @author bai
 * @version V1.0
 * @Package com.factory
 * @date 2022/2/4 13:43
 * @describe
 */
public class WomanFactory {
    /**
     * 海选女嘉宾
     */
    public Woman selectWoman(String name, int age, String outlook) {
        System.out.println("我准备海选媛媛");
        Woman woman = new Woman();
        woman.setName(name);
        woman.setAge(age);
        woman.setOutlook(outlook);
        return woman;
    }

//    public static void main(String[] args) {
//        Woman woman = WomanStaticFactory.selectWoman();
//        System.out.println(woman);
//    }
}
