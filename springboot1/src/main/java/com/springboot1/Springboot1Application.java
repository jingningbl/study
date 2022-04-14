package com.springboot1;

import com.springboot1.config.MyConfig;
import com.springboot1.service.StudentService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author q1425
 */
@SpringBootApplication
//exclude设置不需要的自动配置
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
//Mybatis扫描接口包
@MapperScan("com.springboot1.dao")
//开启定时任务
@EnableScheduling
/** public class Springboot1Application extends SpringBootServletInitializer { */
public class Springboot1Application {

    @Autowired
    private StudentService studentService;
    @Autowired
    private MyConfig myConfig;

    static Logger logger = LoggerFactory.getLogger(Springboot1Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Springboot1Application.class, args);
//        System.out.println("==============================");
//        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName);
//        }
//        System.out.println("===============================");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }

    @GetMapping("hello")
    public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
        studentService.selectList();
        System.out.println(myConfig);
        return String.format("Hello %s!", name);
    }

    /**
     * 配置外置tomcat时,要继承SpringBootServletInitializer,重写configure,
     * 告诉其该项目的入口,并设置打war包
     *
     * @param builder
     * @return
     */
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(Springboot1Application.class);
//    }
}