package com.map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 1、启动类
 * 项目名称：springbootMap 
 * 类名称：Application
 * 开发者：Lenovo
 * 开发时间：2019年4月25日下午9:23:49
 */
@SpringBootApplication
@MapperScan("com.map.mapper")
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
