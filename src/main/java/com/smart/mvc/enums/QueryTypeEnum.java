package com.smart.mvc.enums;

import com.smart.mvc.model.Itemable;

/**
 * 查询类型
 * 
 * @author Joe
 */
public enum QueryTypeEnum implements Itemable<ValueTypeEnum> {
    IS_NULL("is null", ValueTypeEnum.NO), 
    IS_NOT_NULL("is not null", ValueTypeEnum.NO), 
    EQUAL("=", ValueTypeEnum.SINGLE), 
    NOT_EQUAL("<>", ValueTypeEnum.SINGLE),
    GREATER(">", ValueTypeEnum.SINGLE),
    GREATER_EQUAL(">=", ValueTypeEnum.SINGLE),
    LESS("<", ValueTypeEnum.SINGLE),
    LESS_EQUAL("<=", ValueTypeEnum.SINGLE),
    IN("in", ValueTypeEnum.COLLECTION),
    NOT_IN("not in", ValueTypeEnum.COLLECTION),
    BETWEEN("between", ValueTypeEnum.TWO),
    NOT_BETWEEN("not between", ValueTypeEnum.TWO),
    LIKE("like", ValueTypeEnum.SINGLE),
    NOT_LIKE("not like", ValueTypeEnum.SINGLE);

	private String label;
	private ValueTypeEnum value;

	private QueryTypeEnum(String label, ValueTypeEnum value) {
		this.label = label;
		this.value = value;
	}

	@Override
	public String getLabel() {
		return this.label;
	}

	@Override
	public ValueTypeEnum getValue() {
		return this.value;
	}
}