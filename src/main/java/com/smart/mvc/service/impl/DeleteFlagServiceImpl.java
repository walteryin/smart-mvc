package com.smart.mvc.service.impl;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.smart.mvc.dao.Dao;
import com.smart.mvc.model.Condition;
import com.smart.mvc.model.DeleteFlagPersistentObject;
import com.smart.mvc.model.Page;
import com.smart.mvc.service.Service;

/**
 * Service基类，实现了数据的CRUD
 * 
 * @param <DAO>
 * @param <T>
 * @author Joe
 */
public class DeleteFlagServiceImpl<DAO extends Dao<T>, T extends DeleteFlagPersistentObject> extends ServiceImpl<DAO, T>
		implements Service<T> {
	
	@Override
	protected List<T> selectList(Condition c) {
		return super.selectList((c == null ? Condition.create() : c).eq(DeleteFlagPersistentObject.DELETE_FLAG,
				DeleteFlagPersistentObject.NORMAL));
	}

	@Override
	protected Page<T> selectPage(Condition c, Page<T> p) {
		return super.selectPage((c == null ? Condition.create() : c).eq(DeleteFlagPersistentObject.DELETE_FLAG,
				DeleteFlagPersistentObject.NORMAL), p);
	}
	
	@Override
	public T get(Integer id) {
		T t = super.get(id);
		if (DeleteFlagPersistentObject.NORMAL.equals(t.getDeleteFlag())) {
			return t;
		}
		else {
			return null;
		}
	}
	
	@Override
	public void insert(T t) {
		t.setDeleteFlag(DeleteFlagPersistentObject.NORMAL);
		super.insert(t);
	}

	@Override
	protected void deleteByCondition(Condition c) {
		List<T> selectList = selectList(c);
		if (!CollectionUtils.isEmpty(selectList)) {
			selectList.forEach(t -> t.setDeleteFlag(DeleteFlagPersistentObject.DELETED));
			super.update(selectList);
		}
	}
}
