import com.mybatis.pojo.Student;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/18 9:05
 * @describe
 */
public class TestSet {
    @Test
    public void testUpdateStudent() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSqlSession();
            Student student = new Student();
            student.setId("5");
            student.setName("张三");
            student.setAddress("上海");
            int result = session.update("student.updateStudent", student);
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
}
