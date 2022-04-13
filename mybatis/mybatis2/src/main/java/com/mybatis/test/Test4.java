package com.mybatis.test;

import com.mybatis.pojo.ClassInfo;
import com.mybatis.pojo.TeachInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.test
 * @date 2022/3/11 13:54
 * @describe
 */
public class Test4 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        ClassInfo classInfo = session.selectOne("com.mybatis.pojo.ClassInfo.findClassInfoByCid", 1);
        System.out.println("班级Id:" + classInfo.getCid() + "\n" + "班级名称:" + classInfo.getCname() +
                "\n" + "班级人数:" + classInfo.getSum() + "\n" + "学生信息:");
        List<TeachInfo> teachInfoList = classInfo.getTeachInfoList();
        for (TeachInfo teachInfo : teachInfoList) {
            System.out.println(teachInfo);
        }
        session.close();
    }
}
