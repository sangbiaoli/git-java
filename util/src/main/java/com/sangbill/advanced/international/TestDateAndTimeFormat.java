package com.sangbill.advanced.international;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class TestDateAndTimeFormat {
	public static void main(String[] args) {
		showCalendar();
		showSampleDateFormat();
		showDateFormatSymbols();
	}
	
	private static void showDateFormatSymbols() {
		DateFormatSymbols symbols = new DateFormatSymbols();
		String[] monthName = symbols.getMonths();
		for (int i = 0; i < monthName.length; i++) {
			System.out.println(monthName[i]);
		}
		String[] weekdayName = symbols.getWeekdays();
		for (int i = 0; i < weekdayName.length; i++) {
			System.out.println(weekdayName[i]);
		}
	}

	private static void showSampleDateFormat() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
		Date currentTime = new Date();
		String dateString =  format.format(currentTime);
		System.out.println("Current time is "+dateString);
	}

	private static void showCalendar() {
		GregorianCalendar calendar = new GregorianCalendar();

		DateFormat format = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL, Locale.US);

		TimeZone timeZone = TimeZone.getTimeZone("CST");

		format.setTimeZone(timeZone);

		System.out.println("The local time is "
				+ format.format(calendar.getTime()));
	}
}
