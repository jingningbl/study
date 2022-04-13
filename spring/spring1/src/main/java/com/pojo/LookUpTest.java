package com.pojo;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/2/13 11:59
 * @describe
 */
public abstract class LookUpTest {
    public void lunch(){
        getPeople().eat();
    }
//    public People getPeople(){
//        return new People() {
//            @Override
//            public void eat() {
//                System.out.println("吃中饭");
//            }
//        };
//    }
    public abstract People getPeople();
}
