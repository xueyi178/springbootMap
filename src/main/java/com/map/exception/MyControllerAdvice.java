package com.map.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.map.common.ResponseCode;
import com.map.utils.R;
/**
 * 1.统一全家异常处理
 * 项目名称：springbootMap 
 * 类名称：MyControllerAdvice
 * 开发者：Lenovo
 * 开发时间：2019年6月8日下午11:38:18
 */
@ControllerAdvice
@Slf4j
public class MyControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public R serviceExceptionHandler(ServiceException se) {
        return R.error(se.getMsg());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R exceptionHandler(Exception e) {
        log.error("Exception: ", e);
        return R.error(ResponseCode.SERVER_ERROR.getMsg());
    }

}
