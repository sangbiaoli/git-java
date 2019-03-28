package com.sangbill.advanced.concurrent.tool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutrueTaskUtils {
	public static void main(String[] args) throws InterruptedException {

		FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(5 * 1000);
				System.out.println("futureTask任务执行成功");
				return "SUCCESS";
			}
		});
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 4; i++) {
			final int finalI = i;
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					try {
						dosomething(finalI);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			executorService.submit(futureTask);
		}
		try {
			System.out.println("futureTask任务，阻塞等待。。。");
			String str = futureTask.get();
			if ("SUCCESS".equals(str)) {
				System.out.println("futureTask任务完成");
				executorService.shutdown();
			}
			System.out.println(str);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public static void dosomething(int i) throws InterruptedException {
		Thread.sleep((i + 1) * 2000);
		System.out.println(Thread.currentThread().getName() + "任务执行完成");
	}
}