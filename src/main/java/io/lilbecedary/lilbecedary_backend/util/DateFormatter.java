package io.lilbecedary.lilbecedary_backend.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
	
	private static final String DATE_PATTERN = "yyyy-MM-dd";
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
	
	private static final String TIME_PATTERN = "mm:ss";
	private static final SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(TIME_PATTERN);
	
	public static String formatDate(Date date) {
		return simpleDateFormat.format(date);
	}
	
	public static String formatTime(Date date) {
		return simpleTimeFormat.format(date);
	}
	
}
