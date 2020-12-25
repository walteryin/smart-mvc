package com.smart.mvc.ruler.string;

import java.util.Objects;

import com.smart.mvc.ruler.Ruler;
import com.smart.mvc.util.StringUtils;

public class StrDateRuler implements Ruler<String> {

    @Override
	public boolean check(String value) {
		return Objects.isNull(value) || StringUtils.isDate(value);
	}
    
    @Override
	public String getMessage() {
		return "必须符合yyyy-MM-dd格式";
	}
}