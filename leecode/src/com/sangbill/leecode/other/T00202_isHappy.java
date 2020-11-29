package com.sangbill.leecode.other;

import java.util.HashSet;
import java.util.Set;

public class T00202_isHappy {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		int y = 0;
		while (!set.contains(n) && n != 1) {
			set.add(n);
			y = 0;
			while (n > 0) {
				y += (n % 10) * (n % 10);
				n = n / 10;
			}
			n = y;
			if (n < 100) {
				y = (n % 10) * 10 + n / 10;
				if(n != y){
					set.add(y);
				}
			}
		}
		return (n == 1);
	}

	public static void main(String[] args) {
		T00202_isHappy test = new T00202_isHappy();
		System.out.println(test.isHappy(226));
	}
}
