package com.mybatis.test;

import com.mybatis.pojo.StuClass;
import com.mybatis.pojo.StuInfo;
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
 * @date 2022/3/11 13:17
 * @describe
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        StuClass stuClass = session.selectOne("com.mybatis.pojo.StuClass.findStuCardByCid", 1);
        System.out.println("班级Id:" + stuClass.getCid() + "\n" + "班级名称:" + stuClass.getCname() +
                "\n" + "班级人数:" + stuClass.getSum() + "\n" + "学生信息:");
        List<StuInfo> stuInfoList = stuClass.getStuInfoList();
        for (StuInfo stuInfo : stuInfoList) {
            System.out.println(stuInfo);
        }
        session.close();
    }
}
