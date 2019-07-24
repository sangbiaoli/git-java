package com.sangbill.advanced.proxy;

import com.sangbill.advanced.proxy.mapper.RoleMapper;

public class MapperTest {
	public static void main(String[] args) {
		MapperRegistry registry = new MapperRegistry();
		registry.addMapper("com.sangbill.advanced.proxy.mapper");
		RoleMapper mapper = registry.getMapper(RoleMapper.class);
		System.out.println(mapper.getRole(1l));
	}
}
