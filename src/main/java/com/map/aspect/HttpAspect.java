package com.map.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
	
	private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * com.mdf.controller.*.*(..))")
	public void pointCut(){
	}
	
	@Before("pointCut()")
	public void doBefore(JoinPoint joinPoint){
		log.info("设置跨域解决方案");
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = servletRequestAttributes.getResponse();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		//日志记录调用过程
		log.info("url={}",request.getRequestURL());
		log.info("method={}",request.getMethod());
		log.info("ip={}",request.getRemoteAddr());
		log.info("args={}",joinPoint.getArgs());
		log.info("参数={}",request.getParameterMap());
		response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Methods", "POST, GET,PUT, OPTIONS, DELETE");  
		response.setHeader("Access-Control-Max-Age", "0");  
		response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");  
		response.setHeader("Access-Control-Allow-Credentials", "true");  
		response.setHeader("XDomainRequestAllowed","1");
	}
}
