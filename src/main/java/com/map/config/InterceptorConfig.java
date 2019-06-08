package com.map.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.map.interceptor.ApiIdempotentInterceptor;
/**
 * 1.配置拦截器
 * 项目名称：springbootMap 
 * 类名称：InterceptorConfig
 * 开发者：Lenovo
 * 开发时间：2019年6月8日下午11:20:35
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private ApiIdempotentInterceptor apiIdempotentInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(apiIdempotentInterceptor);
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
