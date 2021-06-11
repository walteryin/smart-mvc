package com.smart.core.service.impl;

import com.smart.core.dao.Dao;
import com.smart.core.model.BasePersistent;
import com.smart.core.service.BaseService;

/**
 * 基础Service基类
 * 
 * @param <DAO>
 * @param <T>
 * @author Joe
 */
public class BaseServiceImpl<DAO extends Dao<T>, T extends BasePersistent> extends ServiceImpl<DAO, T, Integer>
		implements BaseService<T> {
}
