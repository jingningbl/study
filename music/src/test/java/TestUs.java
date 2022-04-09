import com.dao.UsDao;
import com.dao.UsDaoImpl;
import org.junit.jupiter.api.Test;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2021/12/7 16:45
 * @describe
 */
public class TestUs {
    UsDao usDao=new UsDaoImpl();
    @Test
    public void testUsSave(){
        usDao.save(1,3);
    }
    @Test
    public void testUsDelete(){
        usDao.delete(1,3);
    }
}
