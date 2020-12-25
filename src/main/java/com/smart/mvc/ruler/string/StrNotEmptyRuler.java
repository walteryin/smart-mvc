package com.smart.mvc.ruler.string;

import org.springframework.util.StringUtils;

import com.smart.mvc.ruler.Ruler;

public class StrNotEmptyRuler implements Ruler<String> {

    @Override
    public boolean check(String value) {
    	return !StringUtils.isEmpty(value);
    }
    
    @Override
	public String getMessage() {
		return "不能为空";
	}
}