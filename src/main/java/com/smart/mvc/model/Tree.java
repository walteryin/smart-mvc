package com.smart.mvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树结构父类
 * 
 * @author Joe
 */
public class Tree implements Treeable, Serializable {

	private static final long serialVersionUID = -1044939782544438879L;
	/** ID */
	private Integer id;
	/** 父ID */
	private Integer parentId;
	/** 名称 */
	private String name;
	/** ID路径 */
	private String path;
	/** 子节点 */
	private List<Tree> children = new ArrayList<>();

	public Tree() {
		super();
	}

	public Tree(Integer id, Integer parentId, String name) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	}
}