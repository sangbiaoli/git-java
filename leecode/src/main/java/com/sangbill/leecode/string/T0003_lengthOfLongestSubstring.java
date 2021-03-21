package com.sangbill.leecode.string;

import java.util.HashSet;

public class T0003_lengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		boolean[] visited = new boolean[256];
		int[] visitedIndex = new int[256];
		int res = 0;
		int cur = 0;
		int start = 0,end = 0;
		for (; end < s.length(); end++) {
			cur = s.charAt(end);
			if (visited[cur]) {
				//比如当前是"abcde"，此时遇到了'c'字符，先结算当前长度，然后找出之前出现'c'的位置，把abc重置为未访问
				res = Math.max(res, end - start);
				for (int j = start; j < visitedIndex[cur]; j++) {
					visited[s.charAt(j)] = false;
				}
				start = visitedIndex[cur] + 1;
			}
			visited[cur] = true;
			visitedIndex[cur] = end;
		}
		res = Math.max(res, end - start);
		return res;
	}

	public static void main(String[] args) {
		T0003_lengthOfLongestSubstring su  = new T0003_lengthOfLongestSubstring();
		String s = "bbbbbb";
		System.out.println(su.lengthOfLongestSubstring(s));
	}
}
