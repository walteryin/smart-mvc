package com.smart.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.util.StringUtils;

import com.smart.core.enums.QueryTypeEnum;
import com.smart.core.enums.ValueTypeEnum;

/**
 * SQL查询条件
 * 
 * like the following:
 * Condition c = Condition.create()
 *      .sql("substr(name, 1, 2) = 'Jo'")
 *      .isNotNull("id")
 *      .in("id", Lists.newArrayList(1, 2))
 *      .between("id", 1, 10)
 *      .like("name", "Joe")
 *      .eq("account", "admin")
 *      .like("office_name", "研发")
 *      .orderBy("name desc, account asc");
 * 
 * @author Joe
 */
public class Condition implements Serializable {

    private static final long serialVersionUID = 1948446733871975127L;

    private String orderBy;

    private List<Criteria> criteriaList;

    private Condition() {
    	super();
    	criteriaList = new ArrayList<>();
    }
    
    /**
     * 构造方法
     * 
     * @return
     */
    public static Condition create() {
        return new Condition();
    }

	public Condition isNull(String column) {
		return append(column, QueryTypeEnum.IS_NULL);
	}

	public Condition isNull(boolean checker, String column) {
		return checker ? isNull(column) : this;
	}
	
	public Condition isNotNull(String column) {
		return append(column, QueryTypeEnum.IS_NOT_NULL);
	}

	public Condition isNotNull(boolean checker, String column) {
		return checker ? isNotNull(column) : this;
	}
	
	public Condition eq(String column, Object value) {
		return append(column, QueryTypeEnum.EQUAL, value);
	}
	
	public Condition eq(boolean checker, String column, Object value) {
		return checker ? eq(column, value) : this;
	}
	
	public Condition ne(String column, Object value) {
		return append(column, QueryTypeEnum.NOT_EQUAL, value);
	}
	
	public Condition ne(boolean checker, String column, Object value) {
		return checker ? ne(column, value) : this;
	}
	
	public Condition gt(String column, Object value) {
		return append(column, QueryTypeEnum.GREATER, value);
	}
	
	public Condition gt(boolean checker, String column, Object value) {
		return checker ? gt(column, value) : this;
	}
	
	public Condition ge(String column, Object value) {
		return append(column, QueryTypeEnum.GREATER_EQUAL, value);
	}
	
	public Condition ge(boolean checker, String column, Object value) {
		return checker ? ge(column, value) : this;
	}
	
	public Condition lt(String column, Object value) {
		return append(column, QueryTypeEnum.LESS, value);
	}
	
	public Condition lt(boolean checker, String column, Object value) {
		return checker ? lt(column, value) : this;
	}
	
	public Condition le(String column, Object value) {
		return append(column, QueryTypeEnum.LESS_EQUAL, value);
	}
	
	public Condition le(boolean checker, String column, Object value) {
		return checker ? le(column, value) : this;
	}
	
	public Condition in(String column, Collection<?> value) {
		return append(column, QueryTypeEnum.IN, value);
	}
	
	public Condition in(boolean checker, String column, Collection<?> value) {
		return checker ? in(column, value) : this;
	}
	
	public Condition notIn(String column, Collection<?> value) {
		return append(column, QueryTypeEnum.NOT_IN, value);
	}
	
	public Condition notIn(boolean checker, String column, Collection<?> value) {
		return checker ? notIn(column, value) : this;
	}
	
	public Condition between(String column, Object v1, Object v2) {
		return append(column, QueryTypeEnum.BETWEEN, v1, v2);
	}
	
	public Condition between(boolean checker, String column, Object v1, Object v2) {
		return checker ? between(column, v1, v2) : this;
	}
	
	public Condition notBetween(String column, Object v1, Object v2) {
		return append(column, QueryTypeEnum.NOT_BETWEEN, v1, v2);
	}
	
	public Condition notBetween(boolean checker, String column, Object v1, Object v2) {
		return checker ? notBetween(column, v1, v2) : this;
	}
	
	public Condition like(String column, String value) {
		return append(column, QueryTypeEnum.LIKE, "%" + value + "%");
	}
	
	public Condition like(boolean checker, String column, String value) {
		return checker ? like(column, value) : this;
	}
	
	public Condition notLike(String column, String value) {
		return append(column, QueryTypeEnum.NOT_LIKE, "%" + value + "%");
	}
	
	public Condition notLike(boolean checker, String column, String value) {
		return checker ? notLike(column, value) : this;
	}
	
	public Condition orderBy(boolean checker, String orderBy) {
		return checker ? orderBy(orderBy) : this;
	}
	
	public Condition orderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}
	
	public Condition sql(String sql) {
		if (StringUtils.isEmpty(sql)) {
            throw new IllegalArgumentException("sql cannot be null");
        }
        criteriaList.add(Criteria.create(sql, null, ValueTypeEnum.NO));
        return this;
	}
	
    private Condition append(String column, QueryTypeEnum queryType, Object... value) {
        criteriaList.add(Criteria.parse(column, queryType, value));
        return this;
    }
    
	public String getOrderBy() {
        return orderBy;
    }

    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }
}