package com.dhhe.demo.util;

import java.io.Serializable;

/**
 * 服务端响应对象
 * 
 * @author hedon
 *
 */
public class JsonResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean success = true;

	private T result = null;

	private String message = "";

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private JsonResponse() {
	}

	private JsonResponse(Boolean success, T result, String message) {
		this.success = success;
		this.result = result;
		this.message = message;
	}

	public static <T> JsonResponse<T> success(T result, String message) {
		return new JsonResponse<>(true, result, message);
	}

	public static JsonResponse<Void> fail(String message) {
		return new JsonResponse<>(false, null, message);
	}

	public static <T> JsonResponse<T> fail(T result, String message) {
		return new JsonResponse<>(false, result, message);
	}

	public static <T> JsonResponse<T> getInstance() {
		return new JsonResponse<>();
	}

}
