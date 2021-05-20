package com.smart.mvc.service.impl;

import com.smart.mvc.dao.Dao;
import com.smart.mvc.model.BasePersistent;
import com.smart.mvc.service.BaseService;

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
