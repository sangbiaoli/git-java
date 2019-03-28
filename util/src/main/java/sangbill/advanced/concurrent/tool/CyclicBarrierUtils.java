package com.sangbill.advanced.concurrent.tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierUtils {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService consumerExe = Executors.newFixedThreadPool(2);
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
			@Override
			public void run() {
				System.out.println("栅栏打开！继续执行任务！");
			}
		});

		for (int i = 0; i < 4; i++) {
			final int finalI = i;
			consumerExe.submit(new Runnable() {
				@Override
				public void run() {
					try {
						dosomething(finalI);
						int i = cyclicBarrier.await();
						System.out.println(Thread.currentThread().getName() + "等待完成i;返回码：" + i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			});
		}
		consumerExe.shutdown();
		boolean flag = consumerExe.awaitTermination(10 * 1000, TimeUnit.MILLISECONDS);
		if (!flag) {
			consumerExe.shutdownNow();
		}
	}

	public static void dosomething(int i) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName() + "任务执行完成");
	}
}