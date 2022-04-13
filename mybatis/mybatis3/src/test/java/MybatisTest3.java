import com.mybatis.dto.BetweenDto;
import com.mybatis.pojo.Student;
import com.mybatis.pojo.Student2;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/15 19:50
 * @describe
 */
public class MybatisTest3 {

    @Test
    public void testSelectById() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            Student2 student = session.selectOne("student2.queryById", 1);
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
}
