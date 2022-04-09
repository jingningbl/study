import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.pojo.User;
import org.junit.jupiter.api.Test;

/**
 * user的测试类
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2021/12/7 14:41
 * @describe
 */
public class TestUser {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void testUserSave(){
        String username="王麻";
        String pwd="123489";
        User user=new User(1,username,pwd);
        userDao.save(user);
    }
    @Test
    public void testUserDelete(){
        userDao.delete("王麻");
    }
    @Test
    public void testUserFindUsername(){
        System.out.println(userDao.findUsername("张三").toString());
    }
}
