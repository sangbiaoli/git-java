package com.sangbill.leecode.string;

import java.util.HashSet;

public class T0003_lengthOfLongestSubstring {
	
	public static int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			HashSet<Character> set = new HashSet<Character>();
			set.add(s.charAt(i));
			for (int j = i + 1; j < s.length(); j++) {
				if(set.contains(s.charAt(j))){
					break;
				}else{
					set.add(s.charAt(j));
				}
				
			}
			if(max < set.size()){
				max = set.size();
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "bbbbbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
