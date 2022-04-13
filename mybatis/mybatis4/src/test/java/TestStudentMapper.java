import com.mybatis.mapper.StudentMapper;
import com.mybatis.pojo.Student;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/18 10:11
 * @describe
 */
public class TestStudentMapper {
    @Test
    public void testSelect() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSqlSession();
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = mapper.selectStudent("1");
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    @Test
    public void testInsert() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSqlSession();
            Student student = new Student();
            student.setName("李四");
            student.setAddress("青海");
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            int result = mapper.insertStudent(student);
            if (result > 0) {
                System.out.println("插入了" + result + "条数据");
            } else {
                System.out.println("插入失败");
            }
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
    public void testUpdate() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSqlSession();
            Student student = new Student();
            student.setId("6");
            student.setName("王五");
            student.setAddress("西藏");
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            int result = mapper.updateStudent(student);
            if (result > 0) {
                System.out.println("更新了" + result + "条数据");
            } else {
                System.out.println("更新失败");
            }
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
    public void testDelete() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSqlSession();
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            int result = mapper.deleteStudent("5");
            if (result > 0) {
                System.out.println("删除了" + result + "条数据");
            } else {
                System.out.println("删除失败");
            }
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
    public void testParam() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSqlSession();
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            List<Student> studentList = mapper.selectByParam("李四", "青海");
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
    public void testL2Cache() {
        SqlSession session1 = null;
        try {
            session1 = MybatisUtil.createSqlSession();
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
            session2 = MybatisUtil.createSqlSession();
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

}
