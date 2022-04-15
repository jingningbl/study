import com.spring8.entity.Student;
import com.spring8.entity.Teacher;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    @Test
    public void testStudent() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        Student student1 = context.getBean("student", Student.class);
        System.out.println(student1);
        Student student2 = context.getBean("student", Student.class);
        System.out.println(student2);
        //该bean为单实例,所以拿到的是同一个对象
        System.out.println(student1.hashCode() == student2.hashCode());
        context.registerShutdownHook();
    }

    @Test
    public void testTeacher() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        Teacher teacher1 = context.getBean("teacher", Teacher.class);
        System.out.println(teacher1);
        Teacher teacher2 = context.getBean("teacher", Teacher.class);
        System.out.println(teacher2);
        System.out.println(teacher1.hashCode() == teacher2.hashCode());
    }
}
