package com.sangbill.test.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test20 {

	public static String largestNumber(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		Collections.sort(list, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				String str1 = o1.toString();
				String str2 = o2.toString();
				return (str2+str1).compareTo(str1+str2);
			}
			
		});
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		if(sb.charAt(0) == '0'){
			return "0";
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 0,0};
		System.out.println(largestNumber(nums));
	}
}
