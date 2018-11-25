package com.dhhe.demo.util;

/**
 * 响应编码
 * 
 * @author hedon
 *
 */
public enum ResponseCode {

	normal("0000");
	private String code;

	ResponseCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
