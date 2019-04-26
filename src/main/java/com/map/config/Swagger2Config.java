package com.map.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 1、Swagger2的配置类
 * 项目名称：mdf-clientplatform 
 * 类名称：Swagger2Config
 * 开发者：Lenovo
 * 开发时间：2019年1月15日上午10:26:44
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.map.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
