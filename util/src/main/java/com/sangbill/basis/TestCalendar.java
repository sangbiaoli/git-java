package com.sangbill.basis;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TestCalendar {
	public static void main(String[] args) {
		getMyCalendar();
	}

	// print a complex calendar
	private static void getMyCalendar() {
		Calendar calendar = new GregorianCalendar(Locale.CHINA);
		String[] weekDays = { "Sunday", "Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday" };
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		String formate = String.format("%d年%d月%d日 %d:%d:%d %s", year, month,day, hour, minute, second, weekDays[dayOfWeek]);
		System.out.println(formate);
	}
}
