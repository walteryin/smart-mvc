package com.smart.core.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 标准持久化基类
 * 
 * @author Joe
 */
public class StandardPersistent extends BasePersistent {

	private static final long serialVersionUID = 1496181940497282708L;

	/** 创建时间 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	/** 更新时间 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}