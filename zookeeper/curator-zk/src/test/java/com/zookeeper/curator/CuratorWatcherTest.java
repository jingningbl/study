package com.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/6 16:17
 * @describe Watcher事件监听机制
 */
public class CuratorWatcherTest {
    private CuratorFramework client = null;

    @Before
    public void testConnect() {
        //重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        //连接zookeeper
        client = CuratorFrameworkFactory.builder().connectString("node150").sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000).namespace("curator").retryPolicy(retryPolicy).build();
        client.start();
    }

    /**
     * 注册NodeCache监听器
     * 监听某个节点
     */
    @Test
    public void testNodeCache() throws Exception {
        //创建NodeCache对象
        NodeCache nodeCache = new NodeCache(client, "/app1");
        //注册监听
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("节点更新");
                //获取修改后的数据
                byte[] data = nodeCache.getCurrentData().getData();
                System.out.println(new String(data));
            }
        });
        //开启监听,当buildInitial为true,则在开启监听时,加载缓冲数据
        nodeCache.start(true);
        while (true) {

        }
    }

    /**
     * 注册PathChildrenCache监听器
     * 监听某节点的子节点
     */
    @Test
    public void testPathChildrenCache() throws Exception {
        //创建PathChildrenCache对象
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/app1", true);
        //注册监听器
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                System.out.println("子节点更新");
                System.out.println(pathChildrenCacheEvent);
                //监听子节点的数据变更,并且拿到更新数据
                //获取类型
                PathChildrenCacheEvent.Type type = pathChildrenCacheEvent.getType();
                //判断类型是否是update
                if (type.equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)) {
                    byte[] data = pathChildrenCacheEvent.getData().getData();
                    System.out.println(new String(data));
                }
            }
        });
        //开启监听
        pathChildrenCache.start(true);
        while (true) {

        }
    }
    /**
     * 注册TreeCache监听器
     * 监听某个节点及其子节点
     */
    @Test
    public void testTreeCache() throws Exception {
        //创建TreeCache对象
        TreeCache treeCache = new TreeCache(client, "/app1");
        //注册监听器
        treeCache.getListenable().addListener(new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                System.out.println("节点变化了");
                System.out.println(treeCacheEvent);
            }
        });
        treeCache.start();
        while (true) {

        }
    }

    @After
    public void close() {
        if (client != null) {
            client.close();
        }
    }
}
