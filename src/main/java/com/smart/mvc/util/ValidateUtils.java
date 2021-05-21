package com.smart.mvc.util;

import java.util.regex.Pattern;

/**
 * 验证工具类
 * 
 * @author Joe
 */
public class ValidateUtils {
	
	private static final Pattern MOBILE_PATTERN = Pattern.compile("[1][3456789]\\d{9}");
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
	
	private static final Pattern INTEGER_PATTERN = Pattern.compile("^-?[1-9]\\d*$");
	private static final Pattern AMOUNT_PATTERN = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,8})?$");
	
	private static final Pattern CHINESE_PATTERN = Pattern.compile("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$");
	
	private static final Pattern ID_CARD_PATTERN1 = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
	private static final Pattern ID_CARD_PATTERN2 = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$");
	
	private static final Pattern DATE_PATTERN = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}");
	private static final Pattern DATE_TIME_PATTERN = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}");

	/**
	 * 是否手机号
	 * 
	 * @param value
	 */
	public static boolean isMobile(String value) {
		return MOBILE_PATTERN.matcher(value).matches();
	}
	
	/**
	 * 是否邮件
	 * 
	 * @param value
	 */
	public static boolean isEmail(String value) {
		return EMAIL_PATTERN.matcher(value).matches();
	}
	
	/**
	 * 是否整数
	 * 
	 * @param value
	 */
	public static boolean isInteger(String value) {
		return INTEGER_PATTERN.matcher(value).matches();
	}

	/**
	 * 是否金额
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isAmount(String value) {
		return AMOUNT_PATTERN.matcher(value).matches();
	}
	
	/**
	 * 是否中文
	 * 
	 * @param value
	 */
	public static boolean isChinese(String value) {
		return CHINESE_PATTERN.matcher(value).matches();
	}
	
	/**
	 * 是否身份证号
	 * 
	 * @param value
	 */
	public static boolean isIdCard(String value) {
		return ID_CARD_PATTERN1.matcher(value).matches() || ID_CARD_PATTERN2.matcher(value).matches();
	}

	/**
	 * 是否日期
	 * 
	 * @param value
	 */
	public static boolean isDate(String value) {
		return DATE_PATTERN.matcher(value).matches();
	}
	
	/**
	 * 是否时间
	 * 
	 * @param value
	 */
	public static boolean isDateTime(String value) {
		return DATE_TIME_PATTERN.matcher(value).matches();
	}
	
	/**
	 * 是否url
	 * 
	 * @param value
	 */
	public static boolean isUrl(String value) {
		return value.startsWith("http://") || value.startsWith("https://");
	}
}
