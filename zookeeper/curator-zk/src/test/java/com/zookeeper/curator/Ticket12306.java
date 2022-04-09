package com.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/6 16:17
 * @describe 模拟12306
 */
public class Ticket12306 implements Runnable {
    //数据库的票数
    private int ticket = 10;
    //分布式锁
    private InterProcessMutex lock;

    public Ticket12306() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 10);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("node150").sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000).retryPolicy(retryPolicy).build();
        client.start();
        lock = new InterProcessMutex(client, "/lock");
    }

    @Override
    public void run() {
        //加锁
        try {
            while (true) {
                lock.acquire(3, TimeUnit.SECONDS);
                if (ticket > 0) {
                    ticket--;
                    System.out.println(Thread.currentThread()+":"+ticket);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
