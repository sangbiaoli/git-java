package com.sangbill.leecode.string;

public class T0009_isPalindrome {
	
	 public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        int rem=0,y=0;
        int quo=x;
        while(quo!=0){
            rem=quo%10;
            y=y*10+rem;
            quo=quo/10;
        }
        return y==x;
    }

	public static void main(String[] args) {
		int s = 123321;
		System.out.println(isPalindrome(s));
	}
}
