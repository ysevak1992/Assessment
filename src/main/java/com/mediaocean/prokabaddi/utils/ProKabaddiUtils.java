package com.mediaocean.prokabaddi.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class ProKabaddiUtils {
 
	
	public static String formatDate(Date actualDate) {
		return new SimpleDateFormat("dd-MM-yyyy").format(actualDate);
	}
	
	public static String formatString(String actualString) {
		return StringUtils.rightPad(actualString, 20, "");
	}
	
	public static Date parseDate(String startDate) {
		DateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
		try {
			return dateFormatter.parse(startDate);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
