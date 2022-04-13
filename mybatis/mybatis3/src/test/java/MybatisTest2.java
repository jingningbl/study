import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
 * @describe
 */
public class MybatisTest2 {

    @Test
    public void testSelectById() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            Student student = session.selectOne("student.queryById", 1);
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            List<Student> student = session.selectList("student.queryAll");
            for (Student student1 : student) {
                System.out.println(student1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    /**
     * selectList传多个参数,使用map集合,或者包装类
     * 不可使用数组或集合
     */
    @Test
    public void testSelectBetween() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
//            Map<String,Object> param = new HashMap<>();
//            param.put("min",1);
//            param.put("max",2);
            ArrayList<Object> param = new ArrayList<>();
            param.add(1);
            param.add(2);
            List<Student> student = session.selectList("student.selectBetween", param);
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
    public void testSelectBetween2() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            BetweenDto param = new BetweenDto();
            param.setMin(1);
            param.setMax(2);
            //建议包装类作为参数,后面映射文件中标签最好指定parameterType="com.mybatis.dto.BetweenDto"(全类名)
            List<Student> student = session.selectList("student.selectBetween2", param);
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
    public void testInsertStudent() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            Student param = new Student();
//            param.setId(3);
            param.setName("耗子");
            param.setAddress("甘肃");
            int result = session.insert("student.insertStudent", param);
            System.out.println("新增了" + result + "条数据");
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
    public void testUpdateStudent() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            Student param = new Student();
            param.setId(2);
            param.setName("坤坤");
            param.setAddress("江西");
            int result = session.update("student.updateById", param);
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

    @Test
    public void testDeleteStudent() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            int result = session.delete("student.deleteById", 3);
            System.out.println("删除了" + result + "条数据");
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
    public void testSelectAllByPage() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            PageHelper.startPage(3, 10);
            Page<Student> page = (Page) session.selectList("student.queryAll");
            for (Student student1 : page.getResult()) {
                System.out.println(student1);
            }
            System.out.println("总数据量:" + page.getTotal());
            System.out.println("总页数:" + page.getPages());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
}
