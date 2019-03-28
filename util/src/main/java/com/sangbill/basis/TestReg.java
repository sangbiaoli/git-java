package com.sangbill.basis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg {
	public static void main(String[] args) {
//		test1();
//		test2();
		test3();
	}

	private static void test3() {
		/*String s = "666676";
		Pattern pattern = Pattern.compile("^([\\d])\\1{3}");
		Matcher m = pattern.matcher(s);
		System.out.println(m.matches());*/
		int j = 0;
		for(int i = 0;i<4;i++){
			j++;
			System.out.println(j+"--"+i);
		}
		/*String s = "111101";
		int n = 6;
		for (int i = n; i >= 3; i--) {
			Pattern pattern = Pattern.compile("^1{" + i + "}");
			Matcher matcher = pattern.matcher(s);
			System.out.println(i+"----"+pattern.pattern()+"---"+matcher.matches());
		}*/
	}

	private static void test2() {
		String s = "IMG_0_1437099435091.jpg`,IMG_1_1437099464785.jpg";
		Pattern p = Pattern.compile("IMG_(\\d+)_");
		Matcher m = p.matcher(s);
	    while (m.find()) {
	    	System.out.println(m.group(0));
        }
	}

	private static void test1() {
		String s = "`v_adc`,`v_qe`";
		Pattern p = Pattern.compile("`v(\\w+)`");
	    Matcher m = p.matcher(s);
	    while (m.find()) {
	    	System.out.println(m.group(0));
        }		
	}
}
