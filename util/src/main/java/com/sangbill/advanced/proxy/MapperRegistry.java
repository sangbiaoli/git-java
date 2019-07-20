package com.sangbill.advanced.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapperRegistry {
	private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<Class<?>, MapperProxyFactory<?>>();

	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> type) {
		final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
		MapperProxy<T> mapperProxy = new MapperProxy<T>();
		return mapperProxyFactory.newInstance(mapperProxy);
	}

	/**
	 * @since 3.2.2
	 */
	public void addMapper(String packageName) {
		addMappers(packageName, Object.class);
	}

	/**
	 * @since 3.2.2
	 */
	public void addMappers(String packageName, Class<?> superType) {
		ResolverUtil resolverUtil = new ResolverUtil();
		Set<Class<? extends Class<?>>> mapperSet = resolverUtil.getClasses(packageName);
		for (Class<?> mapperClass : mapperSet) {
			addMapper(mapperClass);
		}
	}

	public <T> void addMapper(Class<T> type) {
		if (type.isInterface()) {
			knownMappers.put(type, new MapperProxyFactory<T>(type));
		}
	}

	public Map<Class<?>, MapperProxyFactory<?>> getKnownMappers() {
		return knownMappers;
	}
}