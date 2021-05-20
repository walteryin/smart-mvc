package com.smart.mvc.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.smart.mvc.dao.Dao;
import com.smart.mvc.model.Condition;
import com.smart.mvc.model.DeleteFlagPersistent;
import com.smart.mvc.model.Page;
import com.smart.mvc.service.BaseService;

/**
 * Service基类，实现了数据的CRUD
 * 
 * @param <DAO>
 * @param <T>
 * @author Joe
 */
public class DeleteFlagServiceImpl<DAO extends Dao<T>, T extends DeleteFlagPersistent> extends StandardServiceImpl<DAO, T>
		implements BaseService<T> {
	
	@Override
	protected List<T> selectList(Condition c) {
		return super.selectList((c == null ? Condition.create() : c).eq(DeleteFlagPersistent.DELETE_FLAG,
				DeleteFlagPersistent.NORMAL));
	}

	@Override
	protected Page<T> selectPage(Condition c, Page<T> p) {
		return super.selectPage((c == null ? Condition.create() : c).eq(DeleteFlagPersistent.DELETE_FLAG,
				DeleteFlagPersistent.NORMAL), p);
	}
	
	@Override
	public T get(Integer id) {
		T t;
		if ((t = super.get(id)) == null || DeleteFlagPersistent.DELETED.equals(t.getDeleteFlag())) {
			return null;
		}
		return t;
	}
	
	@Override
	public void insert(T t) {
		t.setDeleteFlag(DeleteFlagPersistent.NORMAL);
		super.insert(t);
	}

	/**
	 * 注：多条逻辑删除，是通过单条update更新完成，所以需要增加事务注解
	 */
	@Override
	@Transactional
	public void delete(Collection<T> ts) {
		super.delete(ts);
	}

	@Override
	@Transactional
	public void deleteByIds(Collection<Integer> ids) {
		super.deleteByIds(ids);
	}

	@Override
	protected void deleteByCondition(Condition c) {
		List<T> selectList = selectList(c);
		if (!CollectionUtils.isEmpty(selectList)) {
			selectList.forEach(t -> t.setDeleteFlag(DeleteFlagPersistent.DELETED));
			super.update(selectList);
		}
	}
}
