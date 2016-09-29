package com.hzit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.boot.context.web.SpringBootServletInitializer;
/**
 * Created by Administrator on 2016/9/26.
 */
@SpringBootApplication
@ComponentScan({"com.fc","com.hzit"})
@MapperScan("com.hzit.dao.mapper")
public class StartSpring extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(StartSpring.class,args);
    }
    @Bean
    public Object getObj(){
        System.out.println("该方法一旦运行，就会产生一个new Object对象");
        return new Object();
    }
}
