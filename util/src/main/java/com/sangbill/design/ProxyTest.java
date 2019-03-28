package com.sangbill.design;

public class ProxyTest {
	public static void main(String[] args) {
		TimeProxy proxy = new TimeProxy(new MyInvocationHandler(new Bird()));
		proxy.fly();
	}
}
