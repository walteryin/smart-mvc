package com.smart.core.exception;

import com.smart.core.constant.ResultConstant;

/**
 * 验证异常
 * 
 * @author Joe
 */
public class ValidateException extends ApplicationException {

	private static final long serialVersionUID = 5214146953001236471L;

	public static final String MESSAGE = "验证异常";

	public ValidateException() {
		super(MESSAGE);
	}

	public ValidateException(String message) {
		super(message);
		this.code = ResultConstant.VALIDATE_ERROR;
	}
	
	public ValidateException(int code, String message) {
		super(message);
		this.code = code;
	}
}
