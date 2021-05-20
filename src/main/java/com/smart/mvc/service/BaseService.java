package com.smart.mvc.service;

import com.smart.mvc.model.BasePersistent;

/**
 * 基础Service接口
 * 
 * @param <T>
 * @author Joe
 */
public interface BaseService<T extends BasePersistent> extends Service<T, Integer> {
}
