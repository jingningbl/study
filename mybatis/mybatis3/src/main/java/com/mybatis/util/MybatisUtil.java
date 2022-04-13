package com.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.util
 * @date 2022/3/15 20:50
 * @describe
 */
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    //    初始化
    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
//            抛出初始化异常,让调用者知道
            throw new ExceptionInInitializerError(e);
        }
    }

    //创建SqlSession
    public static SqlSession createSession() {
        return sqlSessionFactory.openSession();
    }

    //关闭SqlSession连接
    public static void closeSession(SqlSession sqlSession) {
        //dataSource type=POOLED close表示将连接返回连接池
        //dataSource type=UNPOOLED close表示关闭连接
        //dataSource type=JNDI close表示将连接交还给应用服务器
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
