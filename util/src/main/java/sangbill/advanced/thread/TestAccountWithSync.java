package com.sangbill.advanced.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestAccountWithSync {
	private static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		// create and launch 100 threads
		for (int i = 0; i < 100; i++) {
			executor.execute(new AddPennyTask());
		}

		executor.shutdown();

		// wait until all tasks finished
		while (!executor.isTerminated()) {
		}

		System.out.println("what is balance ? " + account.getBalance());
	}

	private static class AddPennyTask implements Runnable {

		public void run() {
			account.deposit(1);
		}
	}

	private static class Account {
		private int balance = 0;

		public int getBalance() {
			return balance;
		}

		public synchronized void deposit(int amount) {
			int newBalance = balance + amount;
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance = newBalance;
		}

	}

}
