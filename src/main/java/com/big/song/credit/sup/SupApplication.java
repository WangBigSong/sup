package com.big.song.credit.sup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.big.song.credit.sup.mapper")
@EnableAsync
public class SupApplication {
    public static void main(String[] args) {
        SpringApplication.run(SupApplication.class, args);
    }
}
