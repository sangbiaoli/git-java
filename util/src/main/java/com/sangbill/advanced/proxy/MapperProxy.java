package com.sangbill.advanced.proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy <T> implements InvocationHandler, Serializable {
	private static final long serialVersionUID = -8545401269875370785L;

	
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		System.out.println(arg1.getDeclaringClass());
		System.out.println(arg1.getName());
		System.out.println(arg2);
		return null;
	}

}
