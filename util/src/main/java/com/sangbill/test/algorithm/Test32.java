package com.sangbill.test.algorithm;

public class Test32 {

	public static int countPrimes(int n) {
		if (n < 3)
			return 0;

		int[] b = new int[n + 1];
		b[0] = b[1] = 1;

		int cnt = 1;
		for (int i = 3; i < n; i = i + 2) {
			if (b[i] == 0) {
				if (isPrime(i)) {
					cnt++;
				} else {
					for (int j = 2; j * i < n; j++) {
						b[j * i] = 1;
					}
				}
			}
		}
		return cnt;
	}

	private static boolean isPrime(int num) {
		if (num <= 1 || (num % 2 == 0 && num > 2))
			return false;

		for (int i = 3; i * i <= num; i = i + 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(2));
	}
}