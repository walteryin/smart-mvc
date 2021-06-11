package com.smart.core.ruler.sum;

import com.smart.core.ruler.Ruler;
import com.smart.core.ruler.string.StrAmountRuler;
import com.smart.core.ruler.string.StrChineseRuler;
import com.smart.core.ruler.string.StrDateRuler;
import com.smart.core.ruler.string.StrDateTimeRuler;
import com.smart.core.ruler.string.StrEmailRuler;
import com.smart.core.ruler.string.StrIdCardRuler;
import com.smart.core.ruler.string.StrIntegerRuler;
import com.smart.core.ruler.string.StrLengthBetweenRuler;
import com.smart.core.ruler.string.StrMobileRuler;
import com.smart.core.ruler.string.StrNotEmptyRuler;
import com.smart.core.ruler.string.StrUrlRuler;

public class StrRuler {

	private static final Ruler<String> AMOUNT = new StrAmountRuler();
	private static final Ruler<String> CHINESE = new StrChineseRuler();
	private static final Ruler<String> DATE = new StrDateRuler();
	private static final Ruler<String> DATE_TIME = new StrDateTimeRuler();
	private static final Ruler<String> EMAIL = new StrEmailRuler();
	private static final Ruler<String> ID_CARD = new StrIdCardRuler();
	private static final Ruler<String> INTEGER = new StrIntegerRuler();
	private static final Ruler<String> MOBILE = new StrMobileRuler();
	private static final Ruler<String> NOT_EMPTY = new StrNotEmptyRuler();
	private static final Ruler<String> URL = new StrUrlRuler();

	public static Ruler<String> amount() {
		return AMOUNT;
	}

	public static Ruler<String> chinese() {
		return CHINESE;
	}

	public static Ruler<String> date() {
		return DATE;
	}

	public static Ruler<String> dateTime() {
		return DATE_TIME;
	}

	public static Ruler<String> email() {
		return EMAIL;
	}

	public static Ruler<String> idCard() {
		return ID_CARD;
	}

	public static Ruler<String> integer() {
		return INTEGER;
	}

	public static Ruler<String> mobile() {
		return MOBILE;
	}

	public static Ruler<String> notEmpty() {
		return NOT_EMPTY;
	}

	public static Ruler<String> url() {
		return URL;
	}
	
	public static Ruler<String> lengthBetween(int len1, int len2) {
        return new StrLengthBetweenRuler(len1, len2);
    }
}