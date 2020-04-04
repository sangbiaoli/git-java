package com.sangbill.leecode.other;

public class T_reverse {

	public static int reverse(int x) {
		int x1 = (x < 0)?-x:x;
		int y = 0;
		while(x1 > 0){
			int tmp = x1%10;
			y = y*10+tmp;
			x1 = x1/10;
		}
		if(x < 0){
			y = -y;
		}
		return y;
    }

	public static void main(String[] args) {
		System.out.println(reverse(-1345300));
	}
}
