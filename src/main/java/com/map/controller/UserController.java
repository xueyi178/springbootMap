package com.map.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.map.aspect.AccessLimit;
import com.map.aspect.ApiIdempotent;
import com.map.aspect.WebLog;
import com.map.service.IMbUserService;
import com.map.utils.R;
import com.map.utils.WebUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 1、控制层
 * 项目名称：springbootMap 
 * 类名称：BootMapController
 * 开发者：Lenovo
 * 开发时间：2019年4月25日下午8:44:46
 */
@RestController
@RequestMapping(value="/user")
@Api(tags= {"user操作的API"})
public class UserController {

	@Autowired
	private IMbUserService mbUserService;
	
	/**
	 * 1、添加用户
	 * @param params
	 * @return
	 */
	@PostMapping(value="/insertUser")
	@ApiOperation(httpMethod = "POST", value = "添加用户")	
	public R insertUser(HttpServletRequest request) {
	   return mbUserService.insertUser(WebUtils.getParamAsDto(request));
	}
	
	/**
	 * 2、根据id查询用户信息
	 * @param params
	 * @return
	 */
	@ApiIdempotent
	@PostMapping(value="/getUser")
	@WebLog(description = "根据id查询用户信息")
	@ApiOperation(httpMethod = "POST", value = "根据id查询用户信息")	
	public R getUser(
			@ApiParam(name="id", value="用户id", required= true)@RequestParam("id") Integer id, HttpServletRequest request) {
	   return mbUserService.getUser(WebUtils.getParamAsDto(request));
	}
	
	/**
	 * 3.查询用户信息
	 * @param request
	 * @return
	 */
	@AccessLimit(maxCount = 5, seconds = 1)
	@PostMapping(value="/listUser")
	@WebLog(description = "查询用户信息")
	@ApiOperation(httpMethod = "POST", value = "查询用户信息")	
	public R listUser(HttpServletRequest request) {
		return mbUserService.listUser(WebUtils.getParamAsDto(request));
	}
	
}
