import com.context.ClassPathXmlPojoContext;
import com.pojo.Cartoon;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/2/14 9:12
 * @describe
 */
public class App {
    public static void main(String[] args) {
//        拿到容器
        ClassPathXmlPojoContext context = new ClassPathXmlPojoContext();
//        根据id从容器中拿到对象
        Cartoon kai = (Cartoon) context.getDean("kai");
        System.out.println(kai);
    }
}
