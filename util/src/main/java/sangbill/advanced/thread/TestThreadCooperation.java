package com.sangbill.advanced.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThreadCooperation {

	private static Account account = new Account();

	public static void main(String[] args) {
		// Create a thread pool with two threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new DespositTask());
		executor.execute(new WithdrawTask());

		System.out.println("Thread 1\tThread 2\t\tBalance");
	}

	// Add some money to account
	private static class DespositTask implements Runnable {

		public void run() {
			try {
				while (true) {
					account.deposit((int) ((Math.random() * 10) + 1));
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Get some money from account
	private static class WithdrawTask implements Runnable {

		public void run() {
			while (true) {
				account.withdraw((int) ((Math.random() * 10) + 1));
			}
		}

	}

	private static class Account {
		private static Lock lock = new ReentrantLock();
		private static Condition newDeposit = lock.newCondition();

		private int balance = 0;

		public int getBalance() {
			return balance;
		}

		public void withdraw(int amount) {
			lock.lock();// Acquire the lock
			try {
				while (balance < amount)
					newDeposit.await();
				balance -= amount;
				System.out.println("\t\twithdraw " + amount + "\t\t"
						+ getBalance());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

		public void deposit(int amount) {
			lock.lock();
			try {
				balance += amount;
				System.out.println("Deposit " + amount + "\t\t\t\t"
						+ getBalance());
				newDeposit.signalAll();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();// Release the lock
			}
		}

	}
}
