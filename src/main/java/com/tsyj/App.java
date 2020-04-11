package com.tsyj;

import mybatis.spring.annotation.ExtMapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ComponentScan(basePackages = "com.tsyj")
@ExtMapperScan({"com.tsyj.mapper"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
