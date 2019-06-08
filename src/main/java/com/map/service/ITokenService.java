package com.map.service;

import javax.servlet.http.HttpServletRequest;

import com.map.utils.R;


/**
 * 1.创建token的业务逻辑层接口
 * 项目名称：springbootMap 
 * 类名称：ITokenService
 * 开发者：Lenovo
 * 开发时间：2019年6月8日下午6:43:53
 */
public interface ITokenService {
	/**
	 * 1.创建token
	 * @return
	 */
	R createToken();

	/**
	 * 2.查询token
	 * @param request
	 */
	void checkToken(HttpServletRequest request);
}
