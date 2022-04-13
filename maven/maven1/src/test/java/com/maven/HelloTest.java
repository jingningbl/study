package com.maven;

import org.junit.Test;

/**
 * @author bai
 * @version V1.0
 * @Package com.maven
 * @date 2022/2/21 15:54
 * @describe
 */
public class HelloTest {
    @Test
    public void testHello() {
        Hello hello = new Hello();
        String maven = hello.sayHello("maven");
        System.out.println(maven);
    }
}
