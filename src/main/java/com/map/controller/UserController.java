package com.map.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.service.IMbUserService;
import com.map.utils.R;
import com.map.utils.WebUtils;
import com.map.utils.dto.Dto;

/**
 * 1、控制层
 * 项目名称：springbootMap 
 * 类名称：BootMapController
 * 开发者：Lenovo
 * 开发时间：2019年4月25日下午8:44:46
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private IMbUserService mbUserService;
	
	/**
	 * 1、添加用户
	 * @param params
	 * @return
	 */
	@PostMapping(value="/insertUser")
	public R insertUser(HttpServletRequest request) {
		Dto inDto = WebUtils.getParamAsDto(request);
	   return mbUserService.insertUser(inDto);
	}
	
	/**
	 * 2、查询用户
	 * @param params
	 * @return
	 */
	@PostMapping(value="/listUser")
	public R listUser(HttpServletRequest request) {
		Dto inDto = WebUtils.getParamAsDto(request);
	   return mbUserService.listUser(inDto);
	}
	
}
