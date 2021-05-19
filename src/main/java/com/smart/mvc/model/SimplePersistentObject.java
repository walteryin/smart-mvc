package com.smart.mvc.model;

import java.util.Date;

/**
 * 持久化基类
 * 
 * @author Joe
 */
public class SimplePersistentObject extends PersistentObject {

	private static final long serialVersionUID = 1496181940497282708L;

	/** 创建者 */
	private Integer createBy;
	/** 创建时间 */
	private Date createDate;
	/** 更新者 */
	private Integer updateBy;
	/** 更新时间 */
	private Date updateDate;

	public SimplePersistentObject() {
		super();
	}

	public SimplePersistentObject(Integer id) {
		super(id);
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}