package com.map.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 1.在需要保证 接口限流 的Controller的方法上使用此注解
 * 项目名称：springbootMap 
 * 类名称：AccessLimit
 * 开发者：Lenovo
 * 开发时间：2019年6月9日上午11:34:59
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimit {

    int maxCount();// 最大访问次数

    int seconds();// 固定时间, 单位: s

}
