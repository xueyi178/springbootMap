package com.map.heandler;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.map.utils.R;
/**
 * 1、全局异常
 * 项目名称：springbootMap 
 * 类名称：BaseHeandler
 * 开发者：Lenovo
 * 开发时间：2019年4月26日下午2:08:57
 */
@RestControllerAdvice
public class BaseHeandler {

	@ExceptionHandler				
    public R handleException(IllegalArgumentException e) {
        return R.error().put("msg", e.getMessage());
    }
	
	@ExceptionHandler				
    public R handleException(RuntimeException e) {
        return R.error().put("msg", e.getMessage());
    }
    
    @ExceptionHandler				
    public R handleException(MissingServletRequestParameterException e) {
        return R.error().put("msg", e.getMessage());
    }
}
