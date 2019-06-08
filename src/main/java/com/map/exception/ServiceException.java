package com.map.exception;

/**
 * 业务逻辑异常
 */
public class ServiceException extends RuntimeException{

    /**
	 * 序列化
	 */
	private static final long serialVersionUID = -2868654132634899663L;
	
	private String code;
    private String msg;

    public ServiceException() {
    }

    public ServiceException(String msg) {
        this.msg = msg;
    }

    public ServiceException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
