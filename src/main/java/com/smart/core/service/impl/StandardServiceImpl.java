package com.smart.core.service.impl;

import java.util.Date;

import com.smart.core.dao.Dao;
import com.smart.core.model.StandardPersistent;
import com.smart.core.service.BaseService;

/**
 * 标准Service基类
 * 
 * @param <DAO>
 * @param <T>
 * @author Joe
 */
public class StandardServiceImpl<DAO extends Dao<T>, T extends StandardPersistent> extends BaseServiceImpl<DAO, T>
		implements BaseService<T> {
	
	@Override
	public void insert(T t) {
		Date now = new Date();
		t.setCreateDate(now);
		t.setUpdateDate(now);
		super.insert(t);
	}

	@Override
	public void update(T t) {
		t.setUpdateDate(new Date());
		super.update(t);
	}
}
