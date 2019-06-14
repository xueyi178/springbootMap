package com.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.annotation.WebLog;
import com.map.service.ITokenService;
import com.map.utils.R;

/**
 * 1.获取token的controller
 * 项目名称：springbootMap 
 * 类名称：TokenController
 * 开发者：Lenovo
 * 开发时间：2019年6月8日下午9:28:32
 */
@RestController
@RequestMapping(value= "/token")
public class TokenController {
	
	@Autowired
	private ITokenService tokenService;

	/**
	 * 1.获取token
	 * @return
	 */
	@PostMapping(value ="/gettoken")
	@WebLog(description = "获取token")
	public R token() {
		return tokenService.createToken();
	}
}
