package com.smart.mvc.model;

/**
 * 持久化基类
 * 
 * @author Joe
 */
public class DeleteFlagPersistentObject extends PersistentObject {

	private static final long serialVersionUID = 1472145516693079043L;
	
	public static final String DELETE_FLAG = "delete_flag";
	
	/** 删除 */
	public static final Integer DELETED = 1;
	
	/** 正常 */
	public static final Integer NORMAL = 0;
	
	private Integer deleteFlag;

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}