package kr.or.ddit.common.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	public static LocalDate getToday() {
		return LocalDate.now();
	}
	
	public static String getToday(String format) {
//		return sdf.format(new Date());
		
		return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
	}
	
	
	public static String getBeforeDayFromToday(int beforeDays, String format) {
		return LocalDate.now().minusDays(beforeDays).format(DateTimeFormatter.ofPattern(format));
	}
	
}
