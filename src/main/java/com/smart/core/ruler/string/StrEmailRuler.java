package com.smart.core.ruler.string;

import java.util.Objects;

import com.smart.core.ruler.Ruler;
import com.smart.core.util.ValidateUtils;

public class StrEmailRuler implements Ruler<String> {

	@Override
	public boolean check(String value) {
		return Objects.isNull(value) || ValidateUtils.isEmail(value);
	}

	@Override
	public String getMessage() {
		return "必须符合邮箱格式";
	}
}