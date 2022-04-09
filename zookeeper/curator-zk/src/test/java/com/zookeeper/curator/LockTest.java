package com.zookeeper.curator;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/6 16:17
 * @describe 模拟12306
 */
public class LockTest {
    public static void main(String[] args) {
        Ticket12306 ticket12306 = new Ticket12306();
        //创建客户端
        Thread thread1 = new Thread(ticket12306,"携程");
        Thread thread2 = new Thread(ticket12306,"飞猪");
        thread1.start();
        thread2.start();
    }
}
