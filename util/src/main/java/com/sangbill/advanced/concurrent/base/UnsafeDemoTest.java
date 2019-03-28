package com.sangbill.advanced.concurrent.base;

public class UnsafeDemoTest {
	public static void main(String[] args) {
		UnsafeDemo demo = new UnsafeDemo();
		demo.updateId(null, "1");
		System.out.println(demo.getId());
		demo.updateId("2", "3");
		System.out.println(demo.getId());
	}
}
