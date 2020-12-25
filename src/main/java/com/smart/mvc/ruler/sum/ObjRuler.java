package com.smart.mvc.ruler.sum;

import com.smart.mvc.ruler.Ruler;
import com.smart.mvc.ruler.object.ObjNotNullRuler;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ObjRuler {
	
	private static final Ruler NOT_NULL = new ObjNotNullRuler<>();

	public static <T> Ruler<T> notNull() {
        return NOT_NULL;
    }
}