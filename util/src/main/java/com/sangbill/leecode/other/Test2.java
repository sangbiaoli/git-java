package com.sangbill.leecode.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test2 {
    public static void main(String[] args){
//        int[] nums = {999999998,999999997,999999999};
//    	int[] nums = {0,0,0};
    	int[]nums = {1,2,3,4,5,6,7,8,9,0}; 
//        int[] nums = {3,30,34,5,9};
        String largeNumber = getLargestNumber(nums);
        System.out.println(largeNumber);
    }

    private static String getLargestNumber(int[] nums) {
        List<Integer> numbers = new ArrayList<Integer>();
        int zeroCnt = 0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0){
				zeroCnt ++;
			}
			numbers.add(nums[i]);
		}
        if(numbers.size() == zeroCnt)
            return "0";
        
        Collections.sort(numbers, new Comparator<Integer>() {        
            public int compare(Integer a, Integer b) {    
            	String s1 = a.toString();
            	String s2 = b.toString();
            	int maxLen = Math.max(s1.length() , s2.length());
            	for(int i = 0; i < maxLen;i++){
            		char c1 = (i < s1.length())?s1.charAt(i):s1.charAt(s1.length() - 1);
            		char c2 = (i < s2.length())?s2.charAt(i):s2.charAt(s2.length() - 1);
            		if(c1 > c2){
            			return -1;
            		}else if(c1 < c2){
            			return 1;
            		}
            	}
            	return 0;
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numbers.size(); i++) {
        	sb.append(numbers.get(i));
		}
        return sb.toString();
    }
}
