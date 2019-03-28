package com.sangbill.basis;

import java.util.Date;

public class Test {
	private int count = 0;
	public void init(){
		count = 1;
	}
	public void increase(){
		count ++;
	}
	public int getCount(){
		return count;
	}
	
	public static void main(String[] args) {
		/*Test test = new Test();
		test.init();
		test.increase();
		System.out.println(test.getCount());
		test.increase();
		System.out.println(test.getCount());*/
		Long t = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {}
		Long t2 = System.currentTimeMillis();
		System.out.println(t2-t);
	}
}
