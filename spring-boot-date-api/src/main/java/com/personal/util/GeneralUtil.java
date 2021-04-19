package com.personal.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.function.BiFunction;

public class GeneralUtil {
	
	public static BiFunction<LocalDate, LocalDate, Long> daysDiff = (LocalDate fromDate, LocalDate toDate) -> { return ChronoUnit.DAYS.between(fromDate, toDate);};
	public static BiFunction<LocalDate, LocalDate, Long> monthsDiff = (LocalDate fromDate, LocalDate toDate) -> { return ChronoUnit.MONTHS.between(fromDate, toDate);};
	
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	public static String YES = "YES";
	public static String NO = "NO";
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
	
	public static long daysDiff(LocalDate fromDate, LocalDate toDate){
		return ChronoUnit.DAYS.between(fromDate, toDate);
	}
	
	public static long monthsDiff(LocalDate fromDate, LocalDate toDate){
		return ChronoUnit.MONTHS.between(fromDate, toDate);
	}
	
	
	public static long daysDiff(String fromDate, String toDate){
		return ChronoUnit.DAYS.between(LocalDate.parse(fromDate, formatter), LocalDate.parse(toDate, formatter));
	}
	
	public static long monthsDiff(String fromDate, String toDate){
		return ChronoUnit.MONTHS.between(LocalDate.parse(fromDate, formatter), LocalDate.parse(toDate, formatter));
	}
	
}
