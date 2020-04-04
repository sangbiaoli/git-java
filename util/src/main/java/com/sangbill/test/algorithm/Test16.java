package com.sangbill.test.algorithm;

import java.util.regex.Pattern;

public class Test16 {

	public static int myAtoi(String str) {
		if(str == null)
			return 0;

		String string = str.replaceAll("\\s", "");
		Pattern p = Pattern.compile("^(+-\\d)");
		if(!p.matcher(string).matches())
			return 0;
			
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i < string.length();i++){
			
		}
		return 0;

	}

	public static void main(String[] args) {
		String str = "1231\t\t\n 123";
		int result = myAtoi(str);
		System.out.println(result);
	}
}
