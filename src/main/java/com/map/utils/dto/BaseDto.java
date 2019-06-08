package com.map.utils.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.map.HashedMap;

import ch.qos.logback.core.net.SyslogOutputStream;
/**
 * 1、BaseDto
 * 项目名称：springbootMap 
 * 类名称：BaseDto
 * 开发者：Lenovo
 * 开发时间：2019年4月25日下午10:21:15
 */
@SuppressWarnings("rawtypes")
public class BaseDto extends HashMap implements Dto, Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -8610580972738326520L;

	public BaseDto(){}

	@SuppressWarnings("unchecked")
	public BaseDto(String key, Object value){
		System.out.println("KEY"+ key+ "VALUE"+ value);
		put(key, value);
	}

	public BaseDto(Boolean success){
		setSuccess(success);
	}

	public BaseDto(Boolean success, String msg){
		setSuccess(success);
		setMsg(msg);
	}

	/**
	 * 以BigDecimal类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return BigDecimal 键值
	 */
	public BigDecimal getAsBigDecimal(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "BigDecimal", null);
		if (obj != null)
			return (BigDecimal) obj;
		else
			return null;
	}

	/**
	 * 以Date类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Date 键值
	 */
	public Date getAsDate(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Date", "yyyy-MM-dd");
		if (obj != null)
			return (Date) obj;
		else
			return null;
	}

	/**
	 * 以Integer类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Integer 键值
	 */
	public Integer getAsInteger(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Integer", null);
		if (obj != null)
			return (Integer) obj;
		else
			return null;
	}

	/**
	 * 以Long类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Long 键值
	 */
	public Long getAsLong(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Long", null);
		if (obj != null)
			return (Long) obj;
		else
			return null;
	}

	/**
	 * 以String类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return String 键值
	 */
	public String getAsString(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "String", null);
		if (obj != null)
			return (String) obj;
		else
			return "";
	}

	/**
	 * 以List类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return List 键值
	 */
	public List getAsList(String key){
		return (List)get(key);
	}

	/**
	 * 以Timestamp类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Timestamp 键值
	 */
	public Timestamp getAsTimestamp(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Timestamp", "yyyy-MM-dd HH:mm:ss");
		if (obj != null)
			return (Timestamp) obj;
		else
			return null;
	}

	/**
	 * 以Boolean类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Timestamp 键值
	 */
	public Boolean getAsBoolean(String key){
		Object obj = TypeCaseHelper.convert(get(key), "Boolean", null);
		if (obj != null)
			return (Boolean) obj;
		else
			return null;
	}

	/**
	 * 给Dto压入第一个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	@SuppressWarnings("unchecked")
	public void setDefaultAList(List pList) {
		put("defaultAList", pList);
	}

	/**
	 * 给Dto压入第二个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	@SuppressWarnings("unchecked")
	public void setDefaultBList(List pList) {
		put("defaultBList", pList);
	}

	/**
	 * 获取第一个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	public List getDefaultAList() {
		return (List) get("defaultAList");
	}

	/**
	 * 获取第二个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	public List getDefaultBList() {
		return (List) get("defaultBList");
	}

	/**
	 * 给Dto压入一个默认的Json格式字符串
	 * @param jsonString
	 */
	@SuppressWarnings("unchecked")
	public void setDefaultJson(String jsonString){
		put("defaultJsonString", jsonString);
	}

	/**
	 * 获取默认的Json格式字符串
	 * @return
	 */
	public String getDefaultJson(){
		return getAsString("defaultJsonString");
	}

	/**
	 * 将此Dto对象转换为XML格式字符串
	 * 
	 * @param pStyle
	 *            XML生成方式(可选：节点属性值风格和节点元素值风格)
	 * @return string 返回XML格式字符串
	 */
	public String toXml(String pStyle) {
		String strXml = null;

		return strXml;
	}

	/**
	 * 将此Dto对象转换为XML格式字符串<br>
	 * 默认为节点元素值风格
	 * 
	 * @return string 返回XML格式字符串
	 */
	public String toXml() {
		String strXml = null;

		return strXml;
	}

	/**
	 * 将此Dto对象转换为Json格式字符串<br>
	 * 
	 * @return string 返回Json格式字符串
	 */
	public String toJson() {
		String strJson = null;

		return strJson;
	}

	/**
	 * 将此Dto对象转换为Json格式字符串(带日期时间型)<br>
	 * 
	 * @return string 返回Json格式字符串
	 */
	public String toJson(String pFormat){
		String strJson = null;

		return strJson;
	}

	/**
	 * 设置交易状态
	 * 
	 * @param pSuccess
	 */
	@SuppressWarnings("unchecked")
	public void setSuccess(Boolean pSuccess){
		put("success", pSuccess);
		if (pSuccess) {
			//put("bflag", "1");
		}else {
			//put("bflag", "0");
		}

	}

	/**
	 * 获取交易状态
	 * 
	 * @param pSuccess
	 */
	public Boolean getSuccess(){
		return getAsBoolean("success");
	}

	/**
	 * 设置交易提示信息
	 * 
	 * @param pSuccess
	 */
	@SuppressWarnings("unchecked")
	public void setMsg(String pMsg){
		put("msg", pMsg);
	}

	/**
	 * 获取交易提示信息
	 * 
	 * @param pSuccess
	 */
	public String getMsg(){
		return getAsString("msg");
	}

	/**
	 * 打印DTO对象
	 * 
	 */
	public void println(){
		System.out.println(this);
	}

}
