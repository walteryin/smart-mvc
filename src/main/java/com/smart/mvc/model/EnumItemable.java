package com.smart.mvc.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 枚举公用接口
 * 
 * @author Joe
 * @param <E>
 */
public interface EnumItemable<E extends Enum<E>> extends Itemable {
	
    static <E extends EnumItemable<?>> E get(Class<E> enumType, Object value) {
        return Stream.of(enumType.getEnumConstants()).filter(a -> a.getValue().equals(value)).findAny().orElse(null);
    }
    
    static <E extends EnumItemable<?>> String getLabel(Class<E> enumType, Object value) {
        return Optional.ofNullable(get(enumType, value)).map(d -> d.getLabel()).orElse(null);
    }

    static <E extends EnumItemable<?>> E getByLabel(Class<E> enumType, String Label) {
        return Stream.of(enumType.getEnumConstants()).filter(a -> a.getLabel().equals(Label)).findAny().orElse(null);
    }

    static <E extends EnumItemable<?>> List<Item> getItemList(Class<E> enumType) {
        return Stream.of(enumType.getEnumConstants()).map(e -> Item.create(e.getLabel(), e.getValue()))
            .collect(Collectors.toList());
    }
}
