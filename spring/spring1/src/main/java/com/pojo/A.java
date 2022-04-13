package com.pojo;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/2/4 11:08
 * @describe
 */
public class A {
    public B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public A() {

    }

    public A(B b) {
        this.b = b;
    }

    public void callB() {
//        B b = new B();
        b.sayHello();
    }
}
