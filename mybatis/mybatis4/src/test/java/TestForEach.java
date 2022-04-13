import com.mybatis.pojo.Student;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/18 9:24
 * @describe
 */
public class TestForEach {
    @Test
    public void testFindStudentByForEach() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSqlSession();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            List<Student> studentList = session.selectList("student.findStudentByForEach", list);
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
