package com.sangbill.test.algorithm;

public class Test7 {

	public static int reverse(int x) {
		String s = x+"";
		StringBuffer sb = new StringBuffer();
		int base = 0;
		if(x < 0){
			sb.append("-");
			base = 1;
		}
		for (int i = s.length() -1; i >= base; i--) {
			sb.append(s.charAt(i));
		}
		try{
			Integer rs = Integer.parseInt(sb.toString());
			return rs;
		}catch(Exception e){
			return 0;
		}
        
    }

	public static void main(String[] args) {
		System.out.println(reverse(-1345300));
	}
}
