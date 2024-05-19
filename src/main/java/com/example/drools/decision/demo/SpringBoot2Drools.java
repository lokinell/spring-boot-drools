package com.example.drools.decision.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.drools.decision.demo.mapper")
public class SpringBoot2Drools {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2Drools.class, args);
	}

}
