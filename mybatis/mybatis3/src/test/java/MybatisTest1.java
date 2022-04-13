import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/15 19:50
 * @describe
 */
public class MybatisTest1 {
    @Test
    public void testConnection() {
        try {
//            加载mybatis配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            System.out.println(sqlSession.getConnection());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUtil() {
        SqlSession session = null;
        try {
            session = MybatisUtil.createSession();
            System.out.println(session.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
}
