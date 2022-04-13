import com.mybatis.pojo.Student;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/18 8:25
 * @describe 测试<if></if>与一级,二级缓存;
 */
public class TestIf {
    @Test
    public void testFindStudent() {
        SqlSession session1 = null;
        try {
            session1 = MybatisUtil.createSqlSession();
            Student student = new Student();
            student.setName("耗");
            List<Student> studentList1 = session1.selectList("student.findStudent", student);
            for (Student student1 : studentList1) {
                System.out.println(student1);
            }
            List<Student> studentList2 = session1.selectList("student.findStudent", student);
            for (Student student2 : studentList2) {
                System.out.println(student2);
            }
            System.out.println("studentList1:" + studentList1.hashCode());
            System.out.println("studentList2:" + studentList2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session1);
        }

        SqlSession session2 = null;
        try {
            session2 = MybatisUtil.createSqlSession();
            Student student = new Student();
            student.setName("耗");
            List<Student> studentList3 = session2.selectList("student.findStudent", student);
            for (Student student1 : studentList3) {
                System.out.println(student1);
            }
            List<Student> studentList4 = session2.selectList("student.findStudent", student);
            for (Student student2 : studentList4) {
                System.out.println(student2);
            }
            System.out.println("studentList1:" + studentList3.hashCode());
            System.out.println("studentList2:" + studentList4.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session2);
        }
    }
}
