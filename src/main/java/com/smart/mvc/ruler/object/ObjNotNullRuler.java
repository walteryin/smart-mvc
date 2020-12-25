package com.smart.mvc.ruler.object;

import java.util.Objects;

import com.smart.mvc.ruler.Ruler;

public class ObjNotNullRuler<T> implements Ruler<T> {

    @Override
    public boolean check(T value) {
        return !Objects.isNull(value);
    }
    
    @Override
	public String getMessage() {
		return "不能为Null";
	}
}