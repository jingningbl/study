import com.mybatis6.dao.StudentDao;
import com.mybatis6.dao.StudentDao1;
import com.mybatis6.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/24 19:59
 * @describe
 */
public class MybatisTest {
    /**
     * 一级缓存
     */
    @Test
    public void testCache1() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSqlSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            Student student1 = mapper.queryById(1);
            System.out.println(student1);
            Student student2 = mapper.queryById(1);
            System.out.println(student2);
            System.out.println(student1.hashCode());
            System.out.println(student2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    /**
     * 二级缓存
     */
    @Test
    public void testCache2() {
        SqlSession session1 = null;
        try {
            session1 = MybatisUtil.createSqlSession();
            StudentDao mapper = session1.getMapper(StudentDao.class);
            Student student1 = mapper.queryById(1);
            System.out.println(student1);
            Student student2 = mapper.queryById(1);
            System.out.println(student2);
            System.out.println(student1.hashCode());
            System.out.println(student2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session1);
        }
        SqlSession session2 = null;
        try {
            session2 = MybatisUtil.createSqlSession();
            StudentDao mapper = session2.getMapper(StudentDao.class);
            Student student3 = mapper.queryById(1);
            System.out.println(student3);
            Student student4 = mapper.queryById(1);
            System.out.println(student4);
            System.out.println(student3.hashCode());
            System.out.println(student4.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session2);
        }
    }
    /**
     * 分布式缓存
     */
    @Test
    public void testEhCache() {
        SqlSession session1 = null;
        try {
            session1 = MybatisUtil.createSqlSession();
            StudentDao1 mapper = session1.getMapper(StudentDao1.class);
            Student student1 = mapper.queryById(1);
            System.out.println(student1);
            Student student2 = mapper.queryById(1);
            System.out.println(student2);
            System.out.println(student1.hashCode());
            System.out.println(student2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session1);
        }
        SqlSession session2 = null;
        try {
            session2 = MybatisUtil.createSqlSession();
            StudentDao1 mapper = session2.getMapper(StudentDao1.class);
            Student student3 = mapper.queryById(1);
            System.out.println(student3);
            Student student4 = mapper.queryById(1);
            System.out.println(student4);
            System.out.println(student3.hashCode());
            System.out.println(student4.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session2);
        }
    }
}
