package com.smart.core.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.smart.core.dao.Dao;
import com.smart.core.model.Condition;
import com.smart.core.model.Page;
import com.smart.core.model.Persistent;
import com.smart.core.provider.DynamicSqlProvider;
import com.smart.core.service.Service;
import com.smart.core.util.ConvertUtils;


/**
 * Service基类，实现了数据的CRUD
 * 
 * @param <DAO>
 * @param <T>
 * @param <ID>
 * @author Joe
 */
public class ServiceImpl<DAO extends Dao<T>, T extends Persistent<ID>, ID extends Serializable>
		implements Service<T, ID> {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 自动根据子类传入DAO类型识别注入
	 */
	@Autowired
	protected DAO dao;

	@Override
    public List<T> selectAll() {
        return selectList(null);
    }
	
	protected List<T> selectList(Condition c) {
        return dao.selectByCondition(c, null);
    }
	
	protected T selectOne(Condition c) {
        List<T> list = selectList(c);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

	@Override
    public Page<T> selectPage(Page<T> p) {
        return selectPage(null, p);
    }
    
    protected Page<T> selectPage(Condition c, Page<T> p) {
        dao.selectByCondition(c, p);
        return p;
    }

    @Override
	public T get(ID id) {
		return dao.get(id);
	}

    @Override
    public List<T> selectByIds(Collection<ID> ids) {
        return selectList(Condition.create().in(DynamicSqlProvider.ID, ids));
    }

    @Override
	public void save(T t) {
		if (t.getId() == null) {
			insert(t);
		}
		else {
			update(t);
		}
	}

    @Override
    @Transactional
	public void save(Collection<T> ts) {
		for (T t : ts) {
			save(t);
		}
	}
	
    @Override
	public void insert(T t) {
        dao.insert(t);
    }

    @Override
    @Transactional
    public void insert(Collection<T> ts) {
        for (T t : ts) {
            insert(t);
        }
    }

    @Override
	public void update(T t) {
		dao.update(t);
	}

    @Override
    @Transactional
	public void update(Collection<T> ts) {
		for (T t : ts) {
			update(t);
		}
	}

	@Override
	public void delete(T t) {
		deleteById((ID) t.getId());
	}

	@Override
    public void delete(Collection<T> ts) {
        deleteByIds(ConvertUtils.convert(ts, t -> (ID)t.getId()));
	}

	@Override
	public void deleteById(ID id) {
	    deleteByCondition(Condition.create().eq(DynamicSqlProvider.ID, id));
	}

	@Override
	public void deleteByIds(Collection<ID> ids) {
	    deleteByCondition(Condition.create().in(DynamicSqlProvider.ID, ids));
	}
	
	protected void deleteByCondition(Condition c) {
	    dao.deleteByCondition(c);
    }
}
