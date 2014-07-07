package com.inception.util;

import java.util.Date;

public class DateUtil {
	@SuppressWarnings("deprecation")
	public static String getDateTime(){
		return (new Date().toLocaleString());
	}

	public static String getTime() {
		return (new Date().getTime()) + "";
	}
}
