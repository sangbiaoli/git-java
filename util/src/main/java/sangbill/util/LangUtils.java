package com.sangbill.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LangUtils {
	public static Map<String,String> typeMap = new HashMap<String,String>();
	static{
		typeMap.put("varchar", "String");
		typeMap.put("datetime", "Date");
		typeMap.put("int", "Integer");
	}
	/**
	 * 对于字符串，中文按拼音顺序
	 * @param s1
	 * @param s2
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static int stringCompareTo(String s1, String s2) throws UnsupportedEncodingException {
		String str1 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
		String str2 = new String(s2.getBytes("GB2312"), "ISO-8859-1");
		return str1.compareTo(str2);
	}
	
	/**
	 * 对于数字的比较，统一成double比较
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int numCompareTo(double d1, double d2) {
		double d = d1 - d2;
		if(d>0)return 1;
		else if(d<0)return  -1;
		else return 0;
	}
	
	/**
	 * 对两个long型的比较
	 * @param long1
	 * @param long2
	 * @return
	 */
	public static int longCompareTo(Long long1, Long long2) {
		if(long1>long2)return 1;
		else if(long1<long2)return -1;
		else return 0;
	}
	
	/**
	 * 对两个布尔值比较
	 * @param boolean1
	 * @param boolean2
	 * @return
	 */
	private static int booleanCompareTo(boolean boolean1,boolean boolean2) {
		int t1 = (boolean1)?1:0;
		int t2 = (boolean2)?1:0;
		return t1-t2;
	}
	
	/**
	 * 根据值和类型返回笔记哦啊结果
	 * @param e1
	 * @param e2
	 * @param fieldType
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static int TCompareTo(String e1, String e2, Class<?> fieldType) throws UnsupportedEncodingException {
		int result = 0;			
		if(String.class.equals(fieldType)){
			result =  stringCompareTo(e1, e2);
		}else if(Integer.class.equals(fieldType)){
			result = Integer.parseInt(e1)-Integer.parseInt(e2);
		}else if(Long.class.equals(fieldType)){
			result = longCompareTo(Long.valueOf(e1),Long.valueOf(e2));
		}else if(Float.class.equals(fieldType)){
			result = numCompareTo(Float.parseFloat(e1), Float.parseFloat(e2));
		}else if(Double.class.equals(fieldType)){
			result = numCompareTo(Double.parseDouble(e1), Double.parseDouble(e2));
		}else if(Boolean.class.equals(fieldType)){
			result = booleanCompareTo(Boolean.parseBoolean(e1),Boolean.parseBoolean(e2));
		}
		return result;
	}

	public static String convertType(String dbDataType) {
		return typeMap.get(dbDataType);
	}

	public static String convertColToEntity(String colunmName) {
		String regex = "_(\\w{1})";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(colunmName);
		 while (m.find()) { 
			 colunmName = colunmName.replaceFirst(m.group(0),  m.group(1).toUpperCase());
		 }
		return colunmName;
	}
	
	public static String firstToLower(String model) {
		StringBuffer sb = new StringBuffer(model);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.toString();
	}
}
