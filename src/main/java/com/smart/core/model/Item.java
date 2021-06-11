package com.smart.core.model;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 键值对存储模型
 * 
 * @author Joe
 */
public class Item implements Itemable<Object>, Serializable {
	
    private static final long serialVersionUID = -447313839033608947L;
    
    private String label;
    private Object value;
	
    protected Item() {
    }

    protected Item(String label, Object value) {
        this.label = label;
        this.value = value;
    }

    public static Item create() {
        return new Item();
    }
    
    public static Item create(String label, Object value) {
        return new Item(label, value);
    }
    
    public static <E extends Enum<E> & Itemable<?>> List<Item> createList(Class<E> enumClass) {
		return Stream.of(enumClass.getEnumConstants()).map(e -> Item.create(e.getLabel(), e.getValue()))
				.collect(Collectors.toList());
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
