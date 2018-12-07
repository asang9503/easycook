package com.eco.easycook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.eco.easycook.mapper") //标记Mybatis的接口
public class EasycookApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycookApplication.class, args);
    }
}
