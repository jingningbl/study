package com.springboot1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author bai
 * @version V1.0
 * @date 2022/3/30 22:00
 * @describe
 */
@Configuration
public class CosConfig {
    @Bean
    public WebMvcConfigurer cosConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST")
                        .maxAge(3600);
            }
        };
    }
}