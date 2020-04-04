package com.sangbill.test.algorithm;

public class Test6 {

	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return s;

		int len = s.length();
		char[] chars = s.toCharArray();
		int[] rs = new int[len];
		int left, right;
		for (int i = 0; i < len; i++) {
			// with left
			int leftRs = 0;
			if (i > 0) {
				left = i - 1;
				right = i;
				while (left >= 0 && right < len) {
					if (chars[left] != chars[right]) {
						break;
					}
					leftRs += 2;
					left--;
					right++;
				}
			}
			// with mid
			int midRs = 1;
			if (i - 1 >= 0 && i + 1 < len) {
				left = i - 1;
				right = i + 1;
				while (left >= 0 && right < len) {
					if (chars[left] != chars[right]) {
						break;
					}
					midRs += 2;
					left--;
					right++;
				}
			}

			// with right
			int rigthRs = 0;
			if (i < len) {
				left = i;
				right = i + 1;
				while (left >= 0 && right < len) {
					if (chars[left] != chars[right]) {
						break;
					}
					rigthRs += 2;
					left--;
					right++;
				}
			}

			int flag = (leftRs > midRs) ? ((leftRs > rigthRs) ? 1 : 3) : ((midRs > rigthRs) ? 2 : 3);
			rs[i] = Math.max(leftRs, Math.max(midRs, rigthRs)) * 10 + flag;
		}
		
		int max = 0;
		int index = 0;
		for (int i = 0; i < rs.length; i++) {
			if(max < rs[i]){
				max = rs[i];
				index = i;
			}
		}
		
		int slen = max/10;
		int flag = max%10;
		if (flag == 1) {
			return s.substring(index - slen / 2, index+slen/2);
		} else if (flag == 2) {
			return s.substring(index - (slen - 1) / 2, (slen - 1) / 2 + index + 1);
		} else {
			return s.substring(index - slen / 2+1 , index + slen / 2+1);
		}
	}

	public static void main(String[] args) {
		String s = "ccc";
		System.out.println(longestPalindrome(s));
	}
}
