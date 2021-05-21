package com.smart.mvc.model;

/**
 * 基础持久化基类
 * 
 * @author Joe
 */
public class BasePersistent extends Persistent<Integer> {

	private static final long serialVersionUID = 1496181940497282708L;

	public BasePersistent() {
		super();
	}

	public BasePersistent(Integer id) {
		super(id);
	}

	/**
	 * 解决Spring使用BeanUtils.copyProperties泛型父类属性copy为null问题
	 */
	@Override
	public Integer getId() {
		return super.getId();
	}
}