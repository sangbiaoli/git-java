package com.sangbill.test;

public class Singleton {

	private static Singleton instance = null;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (instance) {
				instance = new Singleton(); // 非原子操作
			}
		}
		return instance;
	}
}