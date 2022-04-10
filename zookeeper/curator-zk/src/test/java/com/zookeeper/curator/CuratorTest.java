package com.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.nio.charset.StandardCharsets;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/6 16:17
 * @describe
 */
public class CuratorTest {

    private CuratorFramework client = null;

    /**
     * 建立连接
     */
    @Before
    public void testConnect() {
        /**
         *  @param connectString       连接字符串,zookeeper服务器的地址和端口号,多个地址用逗号分隔
         *  @param sessionTimeoutMs    session timeout 会话超时时间,ms
         *  @param connectionTimeoutMs connection timeout 连接超时,ms
         *  @param retryPolicy         重试策略
         *  @return client
         */
        /**
         * 重试策略
         * @param baseSleepTimeMs 休眠事件,ms
         * @param maxRetries 重试次数
         */
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 10);
        //第一种方式
//        CuratorFramework client = CuratorFrameworkFactory.newClient("node150",
//                60 * 1000, 15 * 1000, retryPolicy);
//        client.start();
        /**
         * 第二种方式
         * namespace("curator") 命名空间,可以理解为数据库,设置后默认使用curator
         */
        client = CuratorFrameworkFactory.builder().connectString("node1:2180").sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000).retryPolicy(retryPolicy).namespace("curator").build();
        client.start();
    }

    /**
     * 创建节点
     */
    @Test
    public void testCreate() {
        try {
            //基本创建
            //如果创建节点,没有指定数据,则默认将当前客户端的ip作为数据
            //String path = client.create().forPath("/app1");
            //如果创建节点,指定数据
            //String path = client.create().forPath("/app2", "哈哈".getBytes(StandardCharsets.UTF_8));
            //如果创建节点,指定数据和节点类型
            //String path = client.create().withMode(CreateMode.EPHEMERAL).forPath("/app3", "哈哈".getBytes(StandardCharsets.UTF_8));
            //创建多级节点,如果父节点不存在,则会自动创建creatingParentsIfNeeded
            String path = client.create().creatingParentsIfNeeded().forPath("/app4/p1");
            System.out.println(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询节点
     */
    @Test
    public void testGet() throws Exception {
        //查询数据
        //byte[] data = client.getData().forPath("/app2");
        //查询子节点
        //List<String> data = client.getChildren().forPath("/app4");
        //查询节点状态
        Stat status = new Stat();
        System.out.println(status);
        client.getData().storingStatIn(status).forPath("/app2");
        System.out.println(status);
    }

    /**
     * 修改节点数据
     */
    @Test
    public void testSet() throws Exception {
        //client.setData().forPath("/app2", "156".getBytes(StandardCharsets.UTF_8));
        //根据版本号修改,先查询节点的版本号,然后再修改,保证不被其他客户端干扰
        Stat status = new Stat();
        client.getData().storingStatIn(status).forPath("/app2");
        int version = status.getVersion();
        client.setData().withVersion(version).forPath("/app2", "888".getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 删除节点
     */
    @Test
    public void testDelete() throws Exception {
        //删除单个节点
        //client.delete().forPath("/app1");
        //删除带有子节点的节点
        //client.delete().deletingChildrenIfNeeded().forPath("/app4");
        //必须成功的删除,防止网络抖动,实际是多次重试
        //client.delete().guaranteed().forPath("/app2");
        //回掉函数inBackground
        client.delete().guaranteed().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println("删除成功");
                System.out.println(event);
            }
        }).forPath("/app1");
    }

    @After
    public void close() {
        if (client != null) {
            client.close();
        }
    }
}
