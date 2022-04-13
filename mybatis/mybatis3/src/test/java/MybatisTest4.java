import com.mybatis.pojo.Student;
import com.mybatis.pojo.Student3;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/15 19:50
 * @describe
 */
public class MybatisTest4 {
    @Test
    public void testInsertStudent() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            Student param = new Student();
//            param.setId(3);
            param.setName("耗子");
            param.setAddress("甘肃");
            int result = session.insert("student.insertStudent",param);
            System.out.println("新增了" + result + "条数据");
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            assert session != null;
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    /**
     * 先新增在修改同一条数据
     */
    @Test
    public void testInsertUpdate() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            Student3 param = new Student3();
//            param.setId(3);
            param.setName("耗子");
            param.setAddress("甘肃");
            session.insert("student3.insertStudentReturnId3",param);
            System.out.println(param.getId());
            param.setName("被修改");
            param.setAddress("被修改");
            session.update("student3.updateById",param);
            session.commit();
            param.getId();
        } catch (Exception e) {
            e.printStackTrace();
            assert session != null;
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    @Test
    public void testLoginIn() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            List<Student3> student = session.selectList("student3.queryById", "'' or 1=1");
            for (Student3 student1 : student) {
                System.out.println(student1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
}
