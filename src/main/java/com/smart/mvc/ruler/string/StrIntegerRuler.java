package com.smart.mvc.ruler.string;

import java.util.Objects;

import com.smart.mvc.ruler.Ruler;
import com.smart.mvc.util.ValidateUtils;

public class StrIntegerRuler implements Ruler<String> {

    @Override
	public boolean check(String value) {
		return Objects.isNull(value) || ValidateUtils.isInteger(value);
	}
    
    @Override
	public String getMessage() {
		return "必须为整数";
	}
}