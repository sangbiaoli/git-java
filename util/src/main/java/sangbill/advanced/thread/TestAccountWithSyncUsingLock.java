package com.sangbill.advanced.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestAccountWithSyncUsingLock {
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

	// A thread for adding a penny to the account
	private static class AddPennyTask implements Runnable {

		public void run() {
			account.deposit(1);
		}
	}

	// an inner class for account
	private static class Account {
		private static Lock lock = new ReentrantLock();//create a lock
		private int balance = 0;

		public int getBalance() {
			return balance;
		}

		public void deposit(int amount) {
			lock.lock();// Acquired the lock
			try {
				int newBalance = balance + amount;
				Thread.sleep(5);
				balance = newBalance;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();//Release the lock
			}
		}

	}

}
