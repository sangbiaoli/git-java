package com.sangbill.leecode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class T0017_letterCombinations {
	char[][] chars = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

	public List<String> letterCombinations(String digits) {
		if(digits.length() == 0){
			return Collections.EMPTY_LIST;
		}
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		backtrack(list, digits, 0, sb);
		return list;
	}

	private void backtrack(List<String> list, String digits, int index, StringBuilder sb) {
		if (sb.length() == digits.length()) {
			list.add(sb.toString());
		} else {
			char[] letters = chars[digits.charAt(index) - '2'];
			for (int i = 0; i < letters.length; i++) {
				sb.append(letters[i]);
				backtrack(list, digits, index + 1, sb);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		T0017_letterCombinations su = new T0017_letterCombinations();
		String digits = "23";
		List<String> list = su.letterCombinations(digits);
		System.out.println(list.size());
	}
}