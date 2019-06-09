package com.map.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.mapper.MbUserMapper;
import com.map.service.IMbUserService;
import com.map.utils.R;
import com.map.utils.dto.Dto;
/**
 * 1、业务逻辑层的实现类
 * 项目名称：springbootMap 
 * 类名称：MbUserServiceImpl
 * 开发者：Lenovo
 * 开发时间：2019年4月25日下午9:14:45
 */
@Service
public class MbUserServiceImpl implements IMbUserService {

	@Autowired
	private MbUserMapper mbUserMapper;
	
	/**
	 * 1、添加用户
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	public R insertUser(Dto params) {
		params.put("created", new Date());
		params.put("updated", new Date());
		int falg = mbUserMapper.insertUser(params);
		if(falg > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 2、查询用户
	 * @param params
	 * @return
	 */
	@SuppressWarnings("static-access")
	@Override
	public R listUser(Dto params) {
		List<Dto> primaryKey = mbUserMapper.selectByPrimaryKey(params);
		if(primaryKey != null && primaryKey.size() > 0) {
			return R.ok().put("data", primaryKey);
		}
		return R.error().put("msg", "用户信息不存在");
	}

	/**
	 * 3.根据id查询用户信息
	 */
	@Override
	public R getUser(Dto params) {
		Dto user = mbUserMapper.getUser(params);
		if(user != null) {
			return R.ok().put("data", user);
		}
		return R.error().put("msg", "用户信息不存在");
	}

}
