package com.smart.mvc.model;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.CollectionUtils;

/**
 * 键值对基础接口
 * 
 * @author Joe
 */
public interface Itemable<T> {

	String getLabel();

	T getValue();

	/**
	 * 集合支持
	 * 
	 * @param enumClass
	 * @param value
	 * @return
	 */
	static <E extends Itemable<V>, V> E get(Collection<E> c, V value) {
		if (CollectionUtils.isEmpty(c)) {
			return null;
		}
		return c.stream().filter(a -> a.getValue().equals(value)).findAny().orElse(null);
	}

	static <E extends Itemable<V>, V> String getLabel(Collection<E> c, V value) {
		return Optional.ofNullable(get(c, value)).map(d -> d.getLabel()).orElse(null);
	}

	static <E extends Itemable<?>> E getByLabel(Collection<E> c, String label) {
		if (CollectionUtils.isEmpty(c)) {
			return null;
		}
		return c.stream().filter(a -> a.getLabel().equals(label)).findAny().orElse(null);
	}

	/**
	 * 枚举支持
	 * 
	 * @param enumClass
	 * @param value
	 * @return
	 */
	static <E extends Enum<E> & Itemable<V>, V> E get(Class<E> enumClass, V value) {
		return Stream.of(enumClass.getEnumConstants()).filter(a -> a.getValue().equals(value)).findAny().orElse(null);
	}

	static <E extends Enum<E> & Itemable<V>, V> String getLabel(Class<E> enumClass, V value) {
		return Optional.ofNullable(get(enumClass, value)).map(d -> d.getLabel()).orElse(null);
	}

	static <E extends Enum<E> & Itemable<?>> E getByLabel(Class<E> enumClass, String label) {
		return Stream.of(enumClass.getEnumConstants()).filter(a -> a.getLabel().equals(label)).findAny().orElse(null);
	}

	static <E extends Enum<E> & Itemable<?>> List<Item> getItemList(Class<E> enumClass) {
		return Stream.of(enumClass.getEnumConstants()).map(e -> Item.create(e.getLabel(), e.getValue()))
				.collect(Collectors.toList());
	}
}
