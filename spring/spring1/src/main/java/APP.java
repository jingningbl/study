import com.pojo.Man;
import com.pojo.Woman;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/2/4 11:11
 * @describe
 */
public class APP {
    /**
     * 传统方式
     * @param args
     */
//    public static void main(String[] args) {
//        Woman yuanyuan = new Woman();
//        yuanyuan.setName("媛媛");
//        yuanyuan.setAge(18);
//        yuanyuan.setOutlook("人美心善的");
//        System.out.println("一号女嘉宾的信息为:" + yuanyuan);
//        Man lulu = new Man();
//        lulu.setName("陆陆");
//        lulu.setFund("负债累累的");
//        System.out.println("一号男嘉宾的信息为:" + lulu);
//        System.out.println("=================================================");
//        System.out.println("================❤心动女生选择中❤===================");
//        lulu.setWoman(yuanyuan);
//        System.out.println("一号男嘉宾的心动女生为:" + lulu.getWoman());
//        System.out.println("==================================================");
//        System.out.println("====================开始求爱❤❤=====================");
//        lulu.proposal();
//    }

    /**
     * spring
     *
     * @param args
     */
    public static void main(String[] args) {
//        根据配置文件,初始化容器对象
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Woman yuanyuan = (Woman) context.getBean("yuanyuan");
        System.out.println("一号女嘉宾的信息为:" + yuanyuan);
        Man lulu = (Man) context.getBean("lulu");
        System.out.println("一号男嘉宾的信息为:" + lulu);
        lulu.proposal();
        /**
         * 反射机制
         */
//        Class<Woman> womanClass=Woman.class;
//        try {
//            Woman woman=womanClass.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        销毁容器
//        context.close();
        context.registerShutdownHook();
    }
}
