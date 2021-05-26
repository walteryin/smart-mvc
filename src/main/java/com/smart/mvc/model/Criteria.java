package com.smart.mvc.model;

import java.util.Collection;

import org.springframework.util.StringUtils;

import com.smart.mvc.enums.QueryTypeEnum;
import com.smart.mvc.enums.ValueTypeEnum;

public class Criteria extends Item {

	private static final long serialVersionUID = 1681191456328793646L;

	private ValueTypeEnum valueType;

	private Criteria(String label, Object value, ValueTypeEnum valueType) {
		super(label, value);
		this.valueType = valueType;
	}
	
	/**
	 * 构造方法
	 * 
	 * @param label
	 * @param value
	 * @param valueType
	 * @return
	 */
	public static Criteria create(String label, Object value, ValueTypeEnum valueType) {
		return new Criteria(label, value, valueType);
	}

	/**
	 * 解析方法
	 * 
	 * @param column
	 * @param queryType
	 * @param value
	 * @return
	 */
	public static Criteria parse(String column, QueryTypeEnum queryType, Object... value) {
		Object val = null;
		if (StringUtils.isEmpty(column)) {
			throw new IllegalArgumentException("column cannot be null");
		}
		if (queryType == null) {
			throw new IllegalArgumentException("queryType cannot be null");
		}
		if (queryType.getValue() != ValueTypeEnum.NO) {
			if (value == null) {
				throw new IllegalArgumentException("value cannot be null");
			}
			if (queryType.getValue() == ValueTypeEnum.SINGLE) {
				val = value[0];
			}
			else if (queryType.getValue() == ValueTypeEnum.COLLECTION) {
				if (!(value[0] instanceof Collection)) {
					throw new IllegalArgumentException("value type must be Collection");
				}
				else if (((Collection<?>) value[0]).isEmpty()) {
					throw new IllegalArgumentException("value can't be empty");
				}
				val = value[0];
			}
			else if (queryType.getValue() == ValueTypeEnum.TWO) {
				if (value.length == 2) {
					val = value;
				}
				else {
					throw new IllegalArgumentException("value length must be 2");
				}
			}
		}
		return create(column + " " + queryType.getLabel(), val, queryType.getValue());
	}

	public boolean isNoValue() {
		return valueType == ValueTypeEnum.NO;
	}

	public boolean isSingleValue() {
		return valueType == ValueTypeEnum.SINGLE;
	}

	public boolean isTwoValue() {
		return valueType == ValueTypeEnum.TWO;
	}

	public boolean isCollectionValue() {
		return valueType == ValueTypeEnum.COLLECTION;
	}
}