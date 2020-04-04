package com.sangbill.test.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Test8 {

	public static String convert(String s, int numRows) {
		if(numRows <= 1)
			return s;
		
		List<StringBuffer> list = new ArrayList<StringBuffer>();
		for(int i = 0;i < numRows;i++){
			list.add(new StringBuffer());
		}
		int index = 0;
		boolean b = true;
		for (int i = 0; i < s.length(); i++) {
			list.get(index).append(s.charAt(i));
			
			if(b){
				index ++;
			}else{
				index --;
			}
			
			if(index == numRows - 1){
				b = false;
			}
			if(index == 0){
				b = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));			
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		String s = "LEETCODEISHIRING";
		System.out.println(convert(s, 3));
	}
}
