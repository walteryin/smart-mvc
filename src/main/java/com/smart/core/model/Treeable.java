package com.smart.core.model;

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
public interface Treeable<T> {

	T getParentId();

	T getId();

	/**
	 * 是否根节点
	 * 
	 * @return
	 */
	default boolean isRoot() {
		T parentId = getParentId();
		if (parentId == null) {
			return true;
		}
		else if (parentId instanceof Integer) {
			return Integer.valueOf(0).equals(parentId);
		}
		else if (parentId instanceof Long) {
			return Long.valueOf(0).equals(parentId);
		}
		else if (parentId instanceof String) {
			return "".equals(parentId);
		}
		else {
			return false;
		}
	}

	static <T extends Treeable<K>, E extends Tree<K>, K> List<E> build(Collection<T> c,
			Function<? super T, ? extends E> f) {
		if (CollectionUtils.isEmpty(c)) {
			return Collections.emptyList();
		}
		List<E> treeList = new ArrayList<>();
		for (T p : c) {
			if (p.isRoot()) {
				E tree = f.apply(p);
				tree.setPath(p.getId().toString());
				loopSub(tree, c, f);
				treeList.add(tree);
			}
		}
		return treeList;
	}

	static <T extends Treeable<K>, E extends Tree<K>, K> void loopSub(E tree, Collection<T> c,
			Function<? super T, ? extends E> f) {
		for (T p : c) {
			if (tree.getId().equals(p.getParentId())) {
				E subDto = f.apply(p);
				subDto.setPath(tree.getPath() + "," + subDto.getId());
				tree.getChildren().add(subDto);
				loopSub(subDto, c, f);
			}
		}
	}
}