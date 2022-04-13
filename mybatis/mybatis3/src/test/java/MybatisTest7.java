import com.mybatis.pojo.Student;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/15 19:50
 * @describe 一级缓存机制, 相同的sql查询, 第一次执行后结果进入缓存, 之后的查询在缓存中拿到结果, 对象为同一个, 事务提交后缓存会清空, 对象不同
 */
public class MybatisTest7 {
    @Test
    public void testL1Cache() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            Student student1 = session.selectOne("student.queryById", 1);
            System.out.println(student1);
            Student student2 = session.selectOne("student.queryById", 1);
            System.out.println(student2);
            System.out.println(student1 == student2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    @Test
    public void testL2Cache() {
        SqlSession session1 = null;
        try {
            session1 = MybatisUtil.createSession();
            System.out.println(session1);
            Student student1 = session1.selectOne("student.queryById", 1);
            System.out.println(student1);
            Student student2 = session1.selectOne("student.queryById", 1);
            System.out.println(student2);
            System.out.println(student1.hashCode() + ":::" + student2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session1);
        }

        SqlSession session2 = null;
        try {
            session2 = MybatisUtil.createSession();
            System.out.println(session2);
            Student student3 = session2.selectOne("student.queryById", 1);
            student3.setName("被修改的123");
            System.out.println(student3);
            Student student4 = session2.selectOne("student.queryById", 1);
            System.out.println(student4);
            //如果两个对象是同一个对象,则他们的hashCode值一定相同,反之不成立
            System.out.println(student3.hashCode() + ":::" + student4.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session2);
        }
    }

    @Test
    public void testL2CacheList() {
        SqlSession session1 = null;
        try {
            session1 = MybatisUtil.createSession();
            System.out.println(session1);
            List<Student> student1 = session1.selectList("student.queryAll");
            System.out.println(student1);
            List<Student> student2 = session1.selectList("student.queryAll");
            System.out.println(student2);
            System.out.println(student1.hashCode() + ":::" + student2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session1);
        }

        SqlSession session2 = null;
        try {
            session2 = MybatisUtil.createSession();
            System.out.println(session2);
            List<Student> student3 = session2.selectList("student.queryAll");
            System.out.println(student3);
            List<Student> student4 = session2.selectList("student.queryAll");
            System.out.println(student4);
            //如果两个对象是同一个对象,则他们的hashCode值一定相同,反之不成立
            System.out.println(student3.hashCode() + ":::" + student4.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session2);
        }
    }
}
