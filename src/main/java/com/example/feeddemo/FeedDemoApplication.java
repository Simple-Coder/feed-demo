package com.example.feeddemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.feeddemo.mapper")
public class FeedDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedDemoApplication.class, args);
    }

}
