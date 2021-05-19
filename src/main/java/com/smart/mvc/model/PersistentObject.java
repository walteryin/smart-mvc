package com.smart.mvc.model;

/**
 * 持久化基类
 * 
 * @author Joe
 */
public class PersistentObject extends Persistent<Integer> {

	private static final long serialVersionUID = 1496181940497282708L;

	public PersistentObject() {
		super();
	}

	public PersistentObject(Integer id) {
		super(id);
	}
}