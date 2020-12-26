package com.smart.mvc.validator;

import java.util.Arrays;

import org.springframework.util.StringUtils;

import com.smart.mvc.constant.ResultConstant;
import com.smart.mvc.exception.ValidateException;
import com.smart.mvc.model.Result;
import com.smart.mvc.ruler.Ruler;

public class ValidateBuilder {

	private Ruler<?> ruler;

	private int code;
	private String message;

	public static ValidateBuilder create() {
		return new ValidateBuilder();
	}

	@SafeVarargs
	public final <T> ValidateBuilder add(T value, Ruler<T>... rulers) {
		return add(value, null, null, rulers);
	}

	@SafeVarargs
	public final <T> ValidateBuilder add(T value, String name, Ruler<T>... rulers) {
		return add(value, name, null, rulers);
	}

	@SafeVarargs
	public final <T> ValidateBuilder add(T value, String name, Integer code, Ruler<T>... rulers) {
		if (ruler != null || rulers == null) {
			return this;
		}

		Ruler<T> errRuler = Arrays.stream(rulers).filter(t -> !t.check(value)).findAny().orElse(null);
		if (errRuler == null) {
			return this;
		}

		this.ruler = errRuler;
		this.code = code == null ? ResultConstant.VALIDATE_ERROR : code;
		this.message = StringUtils.isEmpty(name) ? errRuler.getMessage() : name + errRuler.getMessage();
		return this;
	}

	public void buildThrow() {
		if (ruler != null) {
			throw new ValidateException(code, message);
		}
	}

	public <T> Result<T> build() {
		if (ruler == null) {
			return Result.success();
		}
		else {
			return Result.create(code, message);
		}
	}
}