package com.map.common;
/**
 * 1.redis工具类
 * 项目名称：springbootMap 
 * 类名称：Constant
 * 开发者：Lenovo
 * 开发时间：2019年6月8日下午6:33:57
 */
public class Constant {
	public interface Redis {
		String OK = "OK";

		// 过期时间, 60s, 一分钟
		int EXPIRE_TIME_MINUTE = 60;

		// 过期时间, 一小时
		int EXPIRE_TIME_HOUR = 60 * 60;

		// 过期时间, 一天
		int EXPIRE_TIME_DAY = 60 * 60 * 24;

		String TOKEN_PREFIX = "token:";

		String ACCESS_LIMIT_PREFIX = "accessLimit:";
	}

}
