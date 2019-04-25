package com.map.service;

import com.map.utils.R;
import com.map.utils.dto.Dto;

/**
 * 1、用户的业务逻辑接口
 * 项目名称：springbootMap 
 * 类名称：IMbUserService
 * 开发者：Lenovo
 * 开发时间：2019年4月25日下午9:12:49
 */
public interface IMbUserService {

	/**
	 * 1、添加用户
	 * @return
	 */
	R insertUser(Dto params);
	
	/**
	 * 2、查询用户
	 * @param params
	 * @return
	 */
	R listUser(Dto params);
}
