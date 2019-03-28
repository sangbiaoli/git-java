package com.sangbill.advanced.concurrent.base;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class UnsafeDemo {
	private static final Unsafe unsafe;
	private static final long idOffset;
	private String id;
	static {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			unsafe = (Unsafe) f.get(null);
			
			idOffset = unsafe.objectFieldOffset(UnsafeDemo.class.getDeclaredField("id"));
		} catch (Exception ex) {
			throw new Error(ex);
		}
	}
	
	public boolean updateId(String expect,String update){
        return unsafe.compareAndSwapObject(this, idOffset, expect, update);
	}

	public String getId() {
		return id;
	}
}
