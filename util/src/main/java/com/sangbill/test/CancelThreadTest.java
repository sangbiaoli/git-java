package com.sangbill.test;

public class CancelThreadTest {

	public static void main(String[] args) throws Exception {
		PrimeGenerator gen = new PrimeGenerator();
		new Thread(gen).start();
		try {
			Thread.sleep(3000);
		} finally {
			gen.cancel();
		}
	}
}
