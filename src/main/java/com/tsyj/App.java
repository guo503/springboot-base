package com.tsyj;

import com.tsyj.apollo.EnableMyConfig;
import mybatis.spring.annotation.ExtMapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ComponentScan(basePackages = "com.tsyj")
@ExtMapperScan({"com.tsyj.mapper"})
@EnableMyConfig
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
