package com.map.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 1.日志的注解
 * 项目名称：springbootMap 
 * 类名称：WebLog
 * 开发者：Lenovo
 * 开发时间：2019年6月8日上午11:26:08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {
    /**
     * 日志描述信息
     *
     * @return
     */
    String description() default "";

}


