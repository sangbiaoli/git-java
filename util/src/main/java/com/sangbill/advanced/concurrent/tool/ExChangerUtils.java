package com.sangbill.advanced.concurrent.tool;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;

public class ExChangerUtils {
	public static void main(String[] args) {

		final int num = 10;

		final Exchanger<Chopsticks> exchanger = new Exchanger();

		final ConcurrentLinkedQueue<Chopsticks> dataQueue = new ConcurrentLinkedQueue();
		final ConcurrentLinkedQueue<Chopsticks> resultQueue = new ConcurrentLinkedQueue();

		for (int i = 0; i < num; i++) {
			Chopsticks chopsticks = new Chopsticks();
			dataQueue.offer(chopsticks);
		}

		ExecutorService producerExe1 = Executors.newSingleThreadExecutor();
		ExecutorService producerExe2 = Executors.newSingleThreadExecutor();

		producerExe1.submit(new Runnable() {
			@Override
			public void run() {
				while (true) {

					if (!dataQueue.isEmpty()) {
						Chopsticks chopsticks = dataQueue.poll();
						chopsticks.setChopstick1("chopstick1");
						try {
							Chopsticks changeChop = exchanger.exchange(chopsticks);
							changeChop.setChopstick1("chopstick1");
							if (!StringUtils.isBlank(changeChop.getChopstick2())) {
								resultQueue.offer(changeChop);
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						break;
					}

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				System.out.println("thread1 over");

			}
		});

		producerExe2.submit(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (!dataQueue.isEmpty()) {
						Chopsticks chopsticks = dataQueue.poll();
						chopsticks.setChopstick2("chopstick2");
						try {
							Chopsticks changeChop = exchanger.exchange(chopsticks);
							changeChop.setChopstick2("chopstick2");
							if (!StringUtils.isBlank(changeChop.getChopstick1())) {
								resultQueue.offer(changeChop);
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						break;
					}
				}
				System.out.println("thread2 over");
			}
		});

		new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (resultQueue.size() == num) {
						for (Chopsticks chopsticks : resultQueue) {
							System.out.println(chopsticks.toString());
						}
						break;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}.run();

	}

	public static class Chopsticks {
		public String chopstick1;
		public String chopstick2;

		public String getChopstick1() {
			return chopstick1;
		}

		public void setChopstick1(String chopstick1) {
			this.chopstick1 = chopstick1;
		}

		public String getChopstick2() {
			return chopstick2;
		}

		public void setChopstick2(String chopstick2) {
			this.chopstick2 = chopstick2;
		}

		@Override
		public String toString() {
			final StringBuffer sb = new StringBuffer("Chopsticks{");
			sb.append("chopstick1='").append(chopstick1).append('\'');
			sb.append(", chopstick2='").append(chopstick2).append('\'');
			sb.append('}');
			return sb.toString();
		}
	}
}