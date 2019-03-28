package com.sangbill.design;

import java.lang.Override;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeProxy implements Flyable {
	private InvocationHandler handler;

	public TimeProxy(InvocationHandler handler) {
		this.handler = handler;
	}

	@Override
	public void fly() {
		try {
			Method method = Flyable.class.getMethod("fly");
			this.handler.invoke(this, method, null);
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
