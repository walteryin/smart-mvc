package com.smart.mvc.validator;

import com.smart.mvc.ruler.sum.StrRuler;

/**
 * 验证器
 * 
 * @author Joe
 */
public enum Validator {

	AMOUNT {

		@Override
		public void validate(String name, String value) {
			ValidateBuilder.create().add(value, name, StrRuler.amount()).buildThrow();
		}
	},

	CHINESE {

		@Override
		public void validate(String name, String value) {
			ValidateBuilder.create().add(value, name, StrRuler.chinese()).buildThrow();
		}
	},

	DATE {

		@Override
		public void validate(String name, String value) {
			ValidateBuilder.create().add(value, name, StrRuler.date()).buildThrow();
		}
	},

	DATE_TIME {

		@Override
		public void validate(String name, String value) {
			ValidateBuilder.create().add(value, name, StrRuler.dateTime()).buildThrow();
		}
	},

	EMAIL {

		@Override
		public void validate(String name, String value) {
			ValidateBuilder.create().add(value, name, StrRuler.email()).buildThrow();
		}
	},

	ID_CARD {

		@Override
		public void validate(String name, String value) {
			ValidateBuilder.create().add(value, name, StrRuler.idCard()).buildThrow();
		}
	},

	INTEGER {

		@Override
		public void validate(String name, String value) {
			ValidateBuilder.create().add(value, name, StrRuler.integer()).buildThrow();
		}
	},

	MOBILE {

		@Override
		public void validate(String name, String value) {
			ValidateBuilder.create().add(value, name, StrRuler.mobile()).buildThrow();
		}
	},

	NOT_BLANK {

		@Override
		public void validate(String name, String value) {
			ValidateBuilder.create().add(value, name, StrRuler.notEmpty()).buildThrow();
		}
	},

	URL {

		@Override
		public void validate(String name, String value) {
			ValidateBuilder.create().add(value, name, StrRuler.url()).buildThrow();
		}
	};

	/**
	 * 参数校验
	 * 
	 * @param name
	 *            参数的中文名称
	 * @param value
	 *            参数的值
	 * @throws Exception
	 */
	public abstract void validate(String name, String value);

	/**
	 * 根据验证器的名称获取验证器
	 * 
	 * @param validatorName
	 * @return
	 */
	public static Validator getValidator(Validator v) {
		for (Validator validator : values()) {
			if (validator == v) {
				return validator;
			}
		}
		return null;
	}
}
