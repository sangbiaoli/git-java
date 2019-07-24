package com.sangbill.design.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BirdInvocationHandler implements InvocationHandler {
	private Flyable flyable;

	public BirdInvocationHandler(Flyable flyable) {
		this.flyable = flyable;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
		long start = System.currentTimeMillis();
		Object obj = null;
		try {
			obj = method.invoke(flyable, new Object[] {});
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("Fly time = " + (end - start));

		return obj;
	}
}
