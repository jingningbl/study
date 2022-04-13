import com.mybatis.pojo.Student;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/18 9:32
 * @describe
 */
public class TestBind {
    @Test
    public void testFindStudentByBind() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSqlSession();
            Student student = new Student();
            student.setName("耗子");
            List<Student> studentList = session.selectList("student.findStudentByBind", student);
            for (Student student1 : studentList) {
                System.out.println(student1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
}
