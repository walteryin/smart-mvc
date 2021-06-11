package com.smart.core.ruler.sum;

import com.smart.core.ruler.Ruler;
import com.smart.core.ruler.object.ObjNotNullRuler;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ObjRuler {
	
	private static final Ruler NOT_NULL = new ObjNotNullRuler<>();

	public static <T> Ruler<T> notNull() {
        return NOT_NULL;
    }
}