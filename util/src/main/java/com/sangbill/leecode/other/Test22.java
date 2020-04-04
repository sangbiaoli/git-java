package com.sangbill.leecode.other;

public class Test22 {
	public static String reverseParentheses(String s) {
		StringBuilder sb = new StringBuilder(s);
		int cnt = 0;
		int left = 0;
		for(int i = 0;i < sb.length();i++){
			char c = sb.charAt(i);
			if(c == '('){
				cnt++;
				left = i;
			}
			if(cnt > 0 && c == ')'){
				reverse(sb,left,i);
				cnt--;
				if(cnt > 0){
					left--;
					while(left >= 0){
						if(sb.charAt(left) == '('){
							break;
						}
						left--;
					}
				}
			}
		}
		String result = sb.toString().replace(" ", "");
		return result;
	}

	
	
	private static void reverse(StringBuilder sb, int left, int right) {
		sb.setCharAt(left, ' ');
		sb.setCharAt(right, ' ');
		if(left + 1 < right){
			String s = sb.substring(left, right+1);
			int len = s.length();
			int index = len - 1;
			for(int i = left;i <= right;i++){
				sb.setCharAt(i, s.charAt(index));
				index--;
			}
		}
		
	}



	public static void main(String[] args) {
//		String s = "(ed(et(oc))el)";
//		String s = "ta()usw((((a))))";
		String s = "ta()usw((((a)))de(bc)fg(i)q)";
		System.out.println(reverseParentheses(s));
	}
}