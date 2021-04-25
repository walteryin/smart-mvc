package com.smart.mvc.service;

import com.smart.mvc.model.PersistentObject;

/**
 * Service接口
 * 
 * @param <T>
 * @author Joe
 */
public interface BaseService<T extends PersistentObject> extends Service<T, Integer> {
}
