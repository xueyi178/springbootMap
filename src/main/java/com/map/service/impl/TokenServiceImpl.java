package com.map.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.common.Constant;
import com.map.common.ResponseCode;
import com.map.exception.ServiceException;
import com.map.service.ITokenService;
import com.map.utils.JedisUtil;
import com.map.utils.R;
import com.map.utils.RandomUtil;

import lombok.extern.slf4j.Slf4j;
/**
 * 1.创建token的业务逻辑层实现类
 * 项目名称：springbootMap 
 * 类名称：TokenServiceImpl
 * 开发者：Lenovo	
 * 开发时间：2019年6月8日下午6:52:20
 */
@Service
@Slf4j
public class TokenServiceImpl implements ITokenService{

	private static final String TOKEN_NAME = "token";

	@Autowired
	private JedisUtil jedisUtil;

	/**
	 * 1.创建token
	 */
	@Override
	public R createToken() {
		String str = RandomUtil.UUID32();
		StringBuffer token = new StringBuffer();
		token.append(Constant.Redis.TOKEN_PREFIX).append(str);
		jedisUtil.set(token.toString(), token.toString(), Constant.Redis.EXPIRE_TIME_MINUTE);
		return R.ok().put("data", token);
	}

	/**
	 * 2.查询token
	 */
	@Override
	public void checkToken(HttpServletRequest request) {
		String token = request.getHeader(TOKEN_NAME);
		// header中不存在token
		if (StringUtils.isBlank(token)) {
			// header中不存在token
			token = request.getParameter(TOKEN_NAME);
			// parameter中也不存在token
			if (StringUtils.isBlank(token)) {
				throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getMsg());
			}
		}
		
		if (!jedisUtil.exists(token)) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
		
		Long del = jedisUtil.del(token);
		if(del.intValue() != 0) {
			log.info("进入了TokenServiceImpl中checkToken方法,删除[{}]成功", token);
		}
	}
}
