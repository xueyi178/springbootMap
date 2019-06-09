package com.map.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  1.在需要保证 接口幂等性 的Controller的方法上使用此注解
 * 项目名称：springbootMap 
 * 类名称：ApiIdempotent
 * 开发者：Lenovo
 * 开发时间：2019年6月9日下午1:31:07
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIdempotent {
	
}
