package com.sangbill.advanced.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * ArrayBlockingQueue is one kind of blocking queue(阻塞队列),we can directly initial an instance
 * blocking queue(阻塞队列) includes :ArrayBlockingQueue,LinkedBlockingQueue,PriorityBlockingQueue
 * @author sangbilllee
 *
 */
public class TetCustomerProducerUsingBlockQueue {

	private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<Integer>(2);
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
					buffer.put(i++);// Add a value to the buffer
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
					System.out.println("\t\tProducer reads " + buffer.take());
					Thread.sleep((long) (Math.random() * SLEEP_TIME));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	
}
