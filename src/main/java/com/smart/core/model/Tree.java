package com.smart.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树结构父类
 * 
 * @author Joe
 */
public class Tree<T> implements Treeable<T>, Serializable {

	private static final long serialVersionUID = -1044939782544438879L;
	/** ID */
	private T id;
	/** 父ID */
	private T parentId;
	/** 名称 */
	private String name;
	/** ID路径 */
	private String path;
	/** 子节点 */
	private List<Tree<T>> children = new ArrayList<>();

	public Tree() {
		super();
	}

	public Tree(T id, T parentId, String name) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
	}

	@Override
	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public T getParentId() {
		return parentId;
	}

	public void setParentId(T parentId) {
		this.parentId = parentId;
	}

	public List<Tree<T>> getChildren() {
		return children;
	}

	public void setChildren(List<Tree<T>> children) {
		this.children = children;
	}
}