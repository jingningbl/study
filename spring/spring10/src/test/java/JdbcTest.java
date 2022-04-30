import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author: bai
 * @date: 2022/4/29 8:28
 * @description:
 */
public class JdbcTest {

    @Test
    public void testInsert() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into spring_jdbc.student(name, age, address) values (?,?,?)";
        int insert = jdbcTemplate.update(sql, "张三", 15, "北京");
        if (insert > 0) {
            System.out.println("新增" + insert + "条数据");
        } else {
            System.out.println("失败");
        }
    }

    @Test
    public void testDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from spring_jdbc.student where id=?";
        int delete = jdbcTemplate.update(sql, 3);
        if (delete > 0) {
            System.out.println("删除" + delete + "条数据");
        } else {
            System.out.println("失败");
        }
    }

    @Test
    public void testUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update spring_jdbc.student set name=?,age=?,address=? where id=?";
        int update = jdbcTemplate.update(sql, "小刘", 20, "甘肃", 4);
        if (update > 0) {
            System.out.println("更新" + update + "条数据");
        } else {
            System.out.println("失败");
        }
    }

    @Test
    public void testSelect() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from spring_jdbc.student";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    public void testDatabase() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "create table spring_jdbc.student1(\n" +
                "    id integer primary key auto_increment,\n" +
                "    name varchar(20),\n" +
                "    age integer,\n" +
                "    address varchar(20)\n" +
                ")";
        try {
            jdbcTemplate.execute(sql);
            System.out.println("创建表成功");
        } catch (Exception e) {
            throw new RuntimeException("失败");
        }
    }
}
