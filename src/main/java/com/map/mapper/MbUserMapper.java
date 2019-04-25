package com.map.mapper;

import java.util.List;

import com.map.utils.dto.Dto;

public interface MbUserMapper {

	/**
	 * 1、添加用户
	 * @param params
	 * @return
	 */
	int insertUser(Dto params);
	
	/**
	 * 2、查询用户
	 * @param params
	 * @return
	 */
	List<Dto> selectByPrimaryKey(Dto params);
}
