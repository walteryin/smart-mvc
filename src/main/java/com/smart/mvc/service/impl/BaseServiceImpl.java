package com.smart.mvc.service.impl;

import com.smart.mvc.dao.Dao;
import com.smart.mvc.model.BasePersistent;
import com.smart.mvc.service.BaseService;

/**
 * Service基类，实现了数据的CRUD
 * 
 * @param <DAO>
 * @param <T>
 * @author Joe
 */
public class BaseServiceImpl<DAO extends Dao<T>, T extends BasePersistent> extends ServiceImpl<DAO, T, Integer>
		implements BaseService<T> {
}
