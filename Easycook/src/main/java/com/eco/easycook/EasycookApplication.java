package com.eco.easycook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.eco.easycook.mapper")
public class EasycookApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycookApplication.class, args);
    }
}
