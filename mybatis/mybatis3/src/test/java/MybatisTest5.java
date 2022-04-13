import com.mybatis.pojo.Student;
import com.mybatis.pojo.Student3;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/15 19:50
 * @describe 动态sql
 */
public class MybatisTest5 {
    @Test
    public void testDynamic1() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            Student param = new Student();
//            param.setId(3);
//            param.setName("耗");
//            param.setAddress("肃");
            List<Student> studentList = session.selectList("student.queryDynamic1",param);
            for (Student student : studentList) {
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
    @Test
    public void testUpdateByIdDynamic() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            Student param = new Student();
            param.setId(2);
            param.setName("坤坤被修改1");
//            param.setAddress("祖籍江西");
            int result = session.update("student.updateByIdDynamic",param);
            System.out.println("更新了" + result + "条数据");
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            assert session != null;
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
    @Test
    public void testDynamic2() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            Student param = new Student();
//            param.setId(3);
            param.setName("耗");
            param.setAddress("肃");
            List<Student> studentList = session.selectList("student.queryDynamic2",param);
            for (Student student : studentList) {
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
}
