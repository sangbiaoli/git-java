package com.sangbill.basis;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestDate {
	public static void main(String[] args) {
		String myDateStr = "2012/05/04";
	//	Date date = getDate(myDateStr);
	//	System.out.println(date);
	//	String between = getInterval(60);
//		String time = getStandarTime("2012-12");	
//		getNowDate();
//		getOneHoursAgoTime();
		System.out.println(formate("yyyy"));
		System.out.println(formate("yyyyMM"));
		System.out.println(formate("yyyyMMdd"));
	}
	/**
	 * 如果为空，返回""
	 * 不为空，按照日期格式返回
	 * @param formate
	 * @return
	 */
	public static String formate(String formate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		return sdf.format(new Date());
	}
	public   static  String  getOneHoursAgoTime () {
		 String oneHoursAgoTime = "";
         Calendar cal = Calendar.getInstance();         
         cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)-2);
         oneHoursAgoTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") .format(cal.getTime());
         SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date = null;
         try {
             date = formatDate.parse(oneHoursAgoTime);
             System.out.println(date);
             
         } catch (ParseException e) {
             e.printStackTrace();
         }
		return oneHoursAgoTime;
    }
	private static void getNowDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date  = new Date();
		System.out.println(format.format(date));
	}

	private static String getStandarTime(String timeStr) {
		StringBuffer time = new StringBuffer();
		time.append("0000-00-00 00:00:00");
		time.replace(0, timeStr.length(), timeStr);
		System.out.println(time.toString());
		return time.toString();
	}

	private static String getInterval(int time) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(time);
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String between = format.format(gc.getTime());
		System.out.print(between);
		return between;
	}
}