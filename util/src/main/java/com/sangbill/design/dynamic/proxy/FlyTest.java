package com.sangbill.design.dynamic.proxy;

import java.lang.reflect.Proxy;

public class FlyTest {
	public static void main(String[] args) {
		Flyable bird = new Bird();
		Flyable flyable = (Flyable)Proxy.newProxyInstance(bird.getClass().getClassLoader(), Bird.class.getInterfaces(), new BirdInvocationHandler(bird));
		flyable.fly();
	}
}
