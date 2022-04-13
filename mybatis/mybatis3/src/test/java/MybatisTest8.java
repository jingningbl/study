import com.mybatis.dao.CourseDao;
import com.mybatis.dto.ManyToOneDto;
import com.mybatis.dto.OneToManyDto;
import com.mybatis.io.MyVfs;
import com.mybatis.pojo.Course;
import com.mybatis.pojo.Student;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/15 19:50
 * @describe 代理模式和级联查询
 */
public class MybatisTest8 {
    /**
     * 日志中DefaultVFS打印乱码,重写VFS,没有得到解决,是mybatis的bug
     */
    @BeforeClass
    public static void BeforeClass(){
        VFS.addImplClass(MyVfs.class);
    }
    @Test
    public void testProxy() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
//            Student student1 = session.selectOne("student.queryById", 1);
//            System.out.println(student1);
//            Student student2 = session.selectOne("student.queryById", 1);
//            System.out.println(student2);
//            System.out.println(student1 == student2);
            CourseDao courseDao = session.getMapper(CourseDao.class);
            Course course = courseDao.queryById(1);
            System.out.println(course);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    /**
     * 已知某学生id,查询其信息和课程
     */
    @Test
    public void testManyToOne() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            ManyToOneDto dto = session.selectOne("student.selectManyToOne2", 1);
            System.out.println(dto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
    @Test
    public void testOneToMany() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            CourseDao courseDao = session.getMapper(CourseDao.class);
            OneToManyDto oneToManyDto = courseDao.selectOneToMany(1);
//            List<Student> studentList = oneToManyDto.getStudentList();
//            for (Student student : studentList) {
//                System.out.println(student);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
}
