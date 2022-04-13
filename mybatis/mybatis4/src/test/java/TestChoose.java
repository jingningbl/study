import com.mybatis.pojo.Student;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/18 8:45
 * @describe
 */
public class TestChoose {
    @Test
    public void testFindStudent2() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSqlSession();
            Student student = new Student();
//            student.setName("子");
            student.setAddress("肃");
            List<Student> studentList = session.selectList("student.findStudent2", student);
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
