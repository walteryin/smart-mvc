package com.smart.mvc.ruler.string;

import java.util.Objects;

import com.smart.mvc.ruler.Ruler;

public class StrLengthBetweenRuler implements Ruler<String> {

    private int len1;
    private int len2;

    public StrLengthBetweenRuler(int len1, int len2) {
        this.len1 = len1;
        this.len2 = len2;
    }

    @Override
    public boolean check(String value) {
		return Objects.isNull(value) || (value.length() >= len1 && value.length() <= len2);
    }

    @Override
	public String getMessage() {
		return String.format("长度必须%d到%d之间", len1, len2);
	}
}