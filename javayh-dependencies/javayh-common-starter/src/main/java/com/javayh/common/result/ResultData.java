package com.javayh.common.result;

import com.javayh.common.constant.ConstantUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 返回值封装
 * </p>
 *
 * @author Dylan-haiji
 * @version 1.0.0
 * @since 2020-03-01 21:13
 */
public class ResultData<T extends Object> {

	/**
	 * 返回状态码 0 :成功 1：失败
	 */
	private String code;

	private String msg;

	private T data;

	private ResultData(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	private ResultData(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public static <T> ResultData<T> success() {
		return new ResultData<T>(ConstantUtils.SUCCESS_CODE, ConstantUtils.SUCCESS_MSG,
				null);
	}

	public static <T> ResultData<T> success(T data) {
		return new ResultData<T>(ConstantUtils.SUCCESS_CODE, ConstantUtils.SUCCESS_MSG,
				data);
	}

	public static <T> ResultData<T> success(String msg, T data) {
		if (StringUtils.isEmpty(msg)) {
			msg = ConstantUtils.SUCCESS_MSG;
		}
		return new ResultData<T>(ConstantUtils.FAIL_CODE, msg, data);
	}

	public static <T> ResultData<T> fail() {
		return new ResultData<T>(ConstantUtils.FAIL_CODE, ConstantUtils.FAIL_MSG);
	}

	public static <T> ResultData<T> fail(String msg) {
		if (StringUtils.isEmpty(msg)) {
			msg = ConstantUtils.FAIL_MSG;
		}
		return new ResultData<>(ConstantUtils.FAIL_CODE, msg);
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
