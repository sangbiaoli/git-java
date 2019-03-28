package com.sangbill.advanced.concurrent.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreUtils {

	private final static Semaphore semaphore = new Semaphore(4);
	private final static ExecutorService produceExe = Executors.newCachedThreadPool();

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 6; i++) {
			produceExe.submit(new Runnable() {
				@Override
				public void run() {
					try {
						eat();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			});

		}
		produceExe.shutdown();
		produceExe.awaitTermination(10, TimeUnit.SECONDS);

	}

	public static void eat() throws InterruptedException {
		semaphore.acquire();
		System.out.println(Thread.currentThread().getName() + ":得到碗筷，开始吃饭");
		Thread.sleep(2000);
		semaphore.release();
		System.out.println(Thread.currentThread().getName() + ":释放碗筷。。。");
	}
}