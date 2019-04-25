package com.map.utils;

import java.util.HashMap;
import java.util.Map;
/**
 * 1、响应体
 * 项目名称：sms-platform 
 * 类名称：R
 * 开发者：Lenovo
 * 开发时间：2019年1月15日上午10:34:26
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public R() {
		put("code", 0);
		put("msg", "SUCCESS");
	}

	public static R error() {
		return error(1, "ERROR");
	}

	public static R error(String msg) {
		return error(500, msg);
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	public static R ok() {
		return new R();
	}

	@Override
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
