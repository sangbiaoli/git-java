package com.sangbill.advanced.concurrent.tool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CountDownLatchUtils {
	private static final int count = 5;

	public static void main(String[] args) {

		final CountDownLatch countDownLatch = new CountDownLatch(count);
		final ExecutorService executorService = Executors.newFixedThreadPool(count);

		for (int i = 0; i < count; i++) {
			final int finalI = i;
			Future<?> future = executorService.submit(new Runnable() {
				@Override
				public void run() {
					try {
						dosomething(finalI);
						countDownLatch.countDown();// 执行一次减小1
						System.out.println(Thread.currentThread().getName() + " over");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}

		try {
			countDownLatch.await();// 阻塞
			System.out.println("所有线程执行成功！！！dosomething...");

			executorService.shutdown();
			if (!executorService.awaitTermination(10 * 1000, TimeUnit.MILLISECONDS)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void dosomething(int i) throws InterruptedException {
		Thread.sleep((i + 1) * 2000);
		System.out.println(Thread.currentThread().getName() + "任务执行完成");
	}
}