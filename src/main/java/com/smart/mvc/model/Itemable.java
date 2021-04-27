package com.smart.mvc.model;

import java.util.Collection;
import java.util.Optional;

import org.springframework.util.CollectionUtils;

/**
 * 键值对基础接口 
 * 
 * @author Joe
 */
public interface Itemable {

	String getLabel();

	Object getValue();
	
	static <E extends Itemable> E get(Collection<E> c, Object value) {
		if (CollectionUtils.isEmpty(c)) {
			return null;
		}
		return c.stream().filter(a -> a.getValue().equals(value)).findAny().orElse(null);
	}
	
	static <E extends Itemable> String getLabel(Collection<E> c, Object value) {
        return Optional.ofNullable(get(c, value)).map(d -> d.getLabel()).orElse(null);
    }
	
    static <E extends Itemable> E getByLabel(Collection<E> c, String Label) {
    	if (CollectionUtils.isEmpty(c)) {
			return null;
		}
        return c.stream().filter(a -> a.getLabel().equals(Label)).findAny().orElse(null);
    }
}
