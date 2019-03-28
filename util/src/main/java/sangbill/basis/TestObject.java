package com.sangbill.basis;

public class TestObject {
	public static void main(String[] args) {
		Object obj = new Object();
		Class objClass = obj.getClass();
		System.out.println(objClass.cast(new Object()));
		System.out.println(objClass.desiredAssertionStatus());
		System.out.println(objClass.equals(new Object()));
		System.out.println(objClass.getCanonicalName());
		System.out.println(objClass.getModifiers());
		System.out.println(objClass.getName());
		System.out.println(objClass.getSimpleName());
		System.out.println(objClass.hashCode());
		System.out.println(objClass.isAnnotation());
		System.out.println(objClass.isLocalClass());
		System.out.println(objClass);
	}
	
}
