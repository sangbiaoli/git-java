package com.sangbill.advanced.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TetCustomerProducer {

	private static Buffer buffer = new Buffer();
	private static int SLEEP_TIME = 5000;
	
	public static void main(String[] args) {
		// Create a fixed thread pool with two thread
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ProduceTask());
		executor.execute(new CustomTask());
		// Shutdown the executor,don`t accept more runnable task
		executor.shutdown();
	}

	// A task for adding an int to the buffer
	public static class ProduceTask implements Runnable {

		public void run() {
			try {
				int i = 1;
				while (true) {
					System.out.println("Producer writes " + i);
					buffer.write(i++);// Add a value to the buffer
					Thread.sleep((long) (Math.random() * SLEEP_TIME));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// A task for reading and deleting an int from the buffer
	public static class CustomTask implements Runnable {

		public void run() {
			try {
				while (true) {
					System.out.println("\t\tProducer reads " + buffer.read());
					Thread.sleep((long) (Math.random() * SLEEP_TIME));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static class Buffer {
		private static final int CAPACITY = 1;//buffer size
		private java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();

		// create a new lock
		private static Lock lock = new ReentrantLock();

		// create two conditions
		private static Condition notEmpty = lock.newCondition();
		private static Condition notFull = lock.newCondition();

		public void write(int value) {
			lock.lock();//Acquired the lock
			try {
				while (queue.size() == CAPACITY) {
					System.out.println("\t\twait for notFull condition");
					notFull.await();
				}
				
				queue.offer(value);
				notEmpty.signal();//Signal notEmpty condition
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();//Release the lock
			}
		}

		@SuppressWarnings("finally")
		public int read() {
			int value = 0;
			lock.lock();//Acquired the lock
			try {
				while (queue.isEmpty()) {
					System.out.println("\t\twait for notEmpty condition");
					notEmpty.await();
				}
				
				value = queue.remove();
				notFull.signal();//Signal notFull condition
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();//Release the lock
				return value;
			}	
		}

	}
}
