package com.map.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.map.annotation.WebLog;

/**
 * 1、日志
 * 项目名称：mdf-clientplatform 
 * 类名称：LogAspect
 * 开发者：Lenovo
 * 开发时间：2019年4月4日下午3:24:45
 */
@Aspect
@Component
public class LogAspect {
	
	//换行符
	private static final String LINE_SEPARATOR = System.lineSeparator();
	
	private Logger log = LoggerFactory.getLogger(getClass());

	private JSONObject jsonObject = new JSONObject();
	

	ThreadLocal<Long>  startTime = new ThreadLocal<Long>();
	
	// 申明一个切点 里面是 execution表达式
	@Pointcut("execution(public * com.map.controller.*.*(..))")
	private void controllerAspect() {
	}

	// 请求method前打印内容
	@Before(value = "controllerAspect()")
	public void methodBefore(JoinPoint joinPoint) throws Exception {
		 // 开始打印请求日志
		startTime.set(System.currentTimeMillis());
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		
		 // 获取 @WebLog 注解的描述信息
        String methodDescription = getAspectLogDescription(joinPoint);
		log.info("========================================== 请求内容开始 ==========================================");
		try {
			// 打印请求内容
			log.info("请求的接口描述   	: {}", methodDescription);
			log.info("请求URL地址		: {}", request.getRequestURL().toString());
			log.info("请求IP地址		: {}", request.getRemoteAddr());
			log.info("请求方式		: {}", request.getMethod());
			log.info("请求类		: {}", joinPoint.getSignature().getDeclaringTypeName());
			log.info("请求类方法		: {}", joinPoint.getSignature());
			log.info("请求类方法参数		: {}", Arrays.toString(joinPoint.getArgs()));
		} catch (Exception e) {
			log.error("###LogAspect.class methodBefore() ### ERROR:", e);
		}
		log.info("========================================== 请求内容结束 ==========================================" + LINE_SEPARATOR);
	}

	// 在方法执行完结后打印返回内容
	@SuppressWarnings("static-access")
	@AfterReturning(returning = "o", pointcut = "controllerAspect()")
	public void methodAfterReturing(Object o) {
		log.info("========================================== 返回内容开始 ==========================================");
		try {
			log.info("Response内容		: {}", jsonObject.toJSONString(o));
		} catch (Exception e) {
			log.error("###LogAspect.class methodAfterReturing() ### ERROR:", e);
		}
		log.info("请求处理时间为		: {} ", (System.currentTimeMillis() - startTime.get())+"MS");
		log.info("========================================== 返回内容结束 ==========================================" + LINE_SEPARATOR);
	}
	
	 /**
     * 获取切面注解的描述
     *
     * @param joinPoint 切点
     * @return 描述信息
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
	public String getAspectLogDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(WebLog.class).description());
                    break;
                }
            }
        }
        return description.toString();
    }

}
