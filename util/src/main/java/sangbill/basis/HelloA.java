package com.sangbill.basis;

public class HelloA {
	public HelloA() {
		System.out.println("this is HelloA");
	}

	static {
		System.out.println("this is HelloA static");
	}
	{
		System.out.println("anouse method A");
	}
}