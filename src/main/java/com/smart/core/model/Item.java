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
public class Item<T> implements Itemable<T>, Serializable {
	
    private static final long serialVersionUID = -447313839033608947L;
    
    private String label;
    private T value;
	
    protected Item() {
    }

    protected Item(String label, T value) {
        this.label = label;
        this.value = value;
    }

    public static <T> Item<T> create() {
        return new Item<>();
    }
    
    public static <T> Item<T> create(String label, T value) {
        return new Item<>(label, value);
    }
    
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public static <E extends Enum<E> & Itemable<K>, K> List<Item<K>> createList(Class<E> enumClass) {
		return Stream.of(enumClass.getEnumConstants()).map(e -> Item.create(e.getLabel(), e.getValue()))
				.collect(Collectors.toList());
	}
}
