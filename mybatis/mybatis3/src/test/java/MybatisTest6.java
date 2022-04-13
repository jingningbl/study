import com.mybatis.dto.BatchDto;
import com.mybatis.dto.BetweenDto;
import com.mybatis.pojo.Student;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/15 19:50
 * @describe 批处理
 */
public class MybatisTest6 {
    @Test
    public void testBatchInsertTraditional() {
        long start = System.currentTimeMillis();
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            for (int i = 0; i < 10000; i++) {
                //@TODO:实际工作不可以循环中new对象,极易发生OOM
                Student student = new Student();
                student.setName("木子" + i);
                student.setAddress("湖北武汉");
                session.insert("student.insertStudent", student);
            }
            session.commit();
            System.out.println("耗时:" + (System.currentTimeMillis() - start) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
            assert session != null;
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    @Test
    public void testBatchInsertForeach() {
        long start = System.currentTimeMillis();
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            List<Student> param = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                //@TODO:实际工作不可以循环中new对象,极易发生OOM
                Student student = new Student();
                student.setName("木子" + i);
                student.setAddress("湖北武汉");
                param.add(student);
            }
            session.insert("student.batchInsertStudent", param);
            session.commit();
            System.out.println("耗时:" + (System.currentTimeMillis() - start) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
            assert session != null;
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    @Test
    public void testSelectByArray() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            int[] param = {1, 10, 100, 1000, 1000};
            List<Student> student = session.selectList("student.selectByArray", param);
            for (Student student1 : student) {
                System.out.println(student1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    @Test
    public void testSelectByMap() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            Map<Object, Object> param = new HashMap<>();
            int[] aaa = {1, 10, 100, 1000, 1000};
            List<Integer> bbb = new ArrayList<>();
            bbb.add(2);
            bbb.add(20);
            bbb.add(200);
            bbb.add(2000);
            param.put("xxx", aaa);
            param.put("yyy", bbb);
            List<Student> student = session.selectList("student.selectByMap", param);
            for (Student student1 : student) {
                System.out.println(student1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
    @Test
    public void testSelectByDto() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            BatchDto param = new BatchDto();
            int[] xxx = {1, 10, 100, 1000, 1000};
            List<Integer> yyy = new ArrayList<>();
            yyy.add(2);
            yyy.add(20);
            yyy.add(200);
            yyy.add(2000);
            param.setAaa(xxx);
            param.setBbb(yyy);
            List<Student> student = session.selectList("student.selectByDto", param);
            for (Student student1 : student) {
                System.out.println(student1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
}
