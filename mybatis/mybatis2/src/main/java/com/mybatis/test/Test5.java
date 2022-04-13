package com.mybatis.test;

import com.mybatis.pojo.StuClass;
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
 * @date 2022/3/11 14:01
 * @describe
 */
public class Test5 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        StuClass stuClass = new StuClass();
        stuClass.setCname("Java1803");
        stuClass.setSum(50);
        int result = session.insert("com.mybatis.pojo.StuClass.addStuClass01", stuClass);
        if (result > 0) {
            System.out.println("成功插入" + result + "条数据");
            System.out.println("插入主键的cid为:" + stuClass.getCid());
        } else {
            System.out.println("插入操作失败");
        }
        session.commit();
        session.close();
    }
}
