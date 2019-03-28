package com.sangbill.test;

public class And {
	private static final int COUNT_BITS = Integer.SIZE - 3;
	private static final int CAPACITY = (1 << COUNT_BITS) - 1;//将1向左移动29位

	private static int runStateOf(int c) {
		return c & ~CAPACITY;
	}

	private static int workerCountOf(int c) {
		return c & CAPACITY;
	}

	public static void main(String[] args) {
		System.out.println(bs(COUNT_BITS));
		System.out.println(bs(CAPACITY));
		System.out.println(bs(~CAPACITY));
		System.out.println(bs(CAPACITY).length());

		for (int i = 0; i < COUNT_BITS; i++) {
			System.out.println(String.format("%s: %s & ~%s= %s",i, bs(i),bs(CAPACITY),bs(runStateOf(i))));
		}
		for (int i = 0; i < COUNT_BITS; i++) {
			System.out.println(String.format("%s: %s & %s= %s",i, bs(i),bs(CAPACITY),bs(workerCountOf(i))));
		}

	}

	private static String bs(int num) {
		return Integer.toBinaryString(num);
	}
}
