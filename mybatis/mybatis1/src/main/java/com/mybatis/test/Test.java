package com.mybatis.test;

import com.mybatis.pojo.Stu;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.test
 * @date 2022/3/11 12:56
 * @describe
 */
public class Test {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        Stu stu = session.selectOne("com.mybatis.pojo.Stu.findStudentBySid", 1);
        System.out.println(stu);
        session.close();
    }
}
