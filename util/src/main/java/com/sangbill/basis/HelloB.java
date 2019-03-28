package com.sangbill.basis;

public class HelloB extends HelloA{
	public HelloB() {
		System.out.println("this is HelloB");
	}

	static {
		System.out.println("this is HelloB static");
	}
	{
		System.out.println("anouse method B");
	}
}