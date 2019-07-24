package com.sangbill.advanced.proxy;

import java.lang.reflect.Proxy;

public class MapperProxyFactory<T> {
	private final Class<T> mapperInterface;

	public MapperProxyFactory(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@SuppressWarnings("unchecked")
	protected T newInstance(MapperProxy<T> mapperProxy) {
		return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface },
				mapperProxy);
	}
}