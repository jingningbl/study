import com.mybatis.dao.StudentClassDao;
import com.mybatis.dao.StudentDao;
import com.mybatis.dto.ManyOneDto;
import com.mybatis.dto.OneManyDto;
import com.mybatis.entity.Student;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/20 21:52
 * @describe
 */
public class MybatisTest {
    /**
     * 一对一
     */
    @Test
    public void testSelectStudentById() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSqlSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            ManyOneDto student = mapper.selectStudentById(2);
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    /**
     * 一对多
     */
    @Test
    public void testSelectStudentFromClassByClassId() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSqlSession();
            StudentClassDao mapper = session.getMapper(StudentClassDao.class);
            OneManyDto studentClass = mapper.selectStudentFromClassByClassId(1);
            List<Student> studentList = studentClass.getStudentList();
            System.out.println("班级id:" + studentClass.getClassId() + "\t\t" + "班级名:" + studentClass.getName());
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
