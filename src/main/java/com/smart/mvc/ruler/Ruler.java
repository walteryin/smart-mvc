package com.smart.mvc.ruler;

@FunctionalInterface
public interface Ruler<T> {

	boolean check(T value);

	default String getMessage() {
		return "校验失败";
	}
}