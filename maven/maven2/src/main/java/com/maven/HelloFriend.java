package com.maven;

/**
 * @author bai
 * @version V1.0
 * @Package com.maven
 * @date 2022/2/21 16:29
 * @describe
 */
public class HelloFriend {
    public String sayHelloToFriend(String name) {
        Hello hello = new Hello();
        return hello.sayHello(name) + "I am" + this.getMyName();
    }

    private String getMyName() {
        return "Idea";
    }
}
