package com.project1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.project1.dao")
@MapperScan("com.project1.mapper")
public class GoodsmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsmanageApplication.class, args);
    }

}
