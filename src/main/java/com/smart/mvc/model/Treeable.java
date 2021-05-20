package com.smart.mvc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.springframework.util.CollectionUtils;

/**
 * 树接口
 * 
 * @author Joe
 */
public interface Treeable {

	Integer getParentId();

	Integer getId();
	
	default boolean isTopParent() {
		return getParentId() == null || Integer.valueOf(0).equals(getParentId());
	}

	static <T extends Treeable, E extends Tree> List<E> build(Collection<T> c, Function<? super T, ? extends E> f) {
		if (CollectionUtils.isEmpty(c)) {
			return Collections.emptyList();
		}
		List<E> treeList = new ArrayList<>();
		for (T p : c) {
			if (p.isTopParent()) {
				E treeDto = f.apply(p);
				treeDto.setPath(p.getId().toString());
				loopSub(treeDto, c, f);
				treeList.add(treeDto);
			}
		}
		return treeList;
	}

	static <T extends Treeable, E extends Tree> void loopSub(E treeDto, Collection<T> c,
			Function<? super T, ? extends E> f) {
		for (T p : c) {
			if (treeDto.getId().equals(p.getParentId())) {
				E subDto = f.apply(p);
				subDto.setPath(treeDto.getPath() + "," + subDto.getId());
				treeDto.getChildren().add(subDto);
				loopSub(subDto, c, f);
			}
		}
	}
}