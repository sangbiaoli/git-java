package com.sangbill.leecode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 分割回文串
 * @author Bill
 *
 */
public class T0131_partition {
	
	public List<List<String>> partition(String s) {
		List<List<String>> list = new ArrayList<>();
		Stack<String> stack = new Stack<String>();
		sdf(list, stack, s, 0);
		return list;
	}

	private void sdf(List<List<String>> list, Stack<String> stack, String s, int i) {
		if (i == s.length()) {
			list.add(new ArrayList<>(stack));
			return;
		}
		for (int j = i + 1; j <= s.length(); j++) {
			String temp = s.substring(i, j);
			if (check(temp)) {
				stack.push(temp);
				sdf(list, stack, s, j);
				stack.pop();
			}
		}
	}

	private boolean check(String s) {
		if (s.length() == 1) {
			return true;
		}
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		T0131_partition su = new T0131_partition();
		List<List<String>> list = su.partition("aaaaa");
		System.out.println(list.size());
	}
}