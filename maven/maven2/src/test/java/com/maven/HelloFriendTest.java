package com.maven;

import org.junit.Test;

/**
 * @author bai
 * @version V1.0
 * @Package com.maven
 * @date 2022/2/21 16:42
 * @describe
 */
public class HelloFriendTest {
    @Test
    public void testSayHelloToFriend(){
        HelloFriend helloFriend = new HelloFriend();
        String maven = helloFriend.sayHelloToFriend("maven");
        System.out.println(maven);
    }
}
