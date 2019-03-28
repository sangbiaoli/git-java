package com.sangbill.basis;

public class TestAssert {
	public static void main(String[] args) {
		final int SIZE = 10;
		int i = 0, sum = 0;
		for (; i < SIZE; i++) {
			sum += i;
		}
		assert i == SIZE;
		assert sum > 10 && sum < 5 * 10 : "sum is" + sum;
	}
}
