package com.sangbill.concurrent.executor;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class ExecutorDemo {

	class DirectExecutor implements Executor {
		public void execute(Runnable r) {
			r.run();
		}
	}

	class ThreadPerTaskExecutor implements Executor {
		public void execute(Runnable r) {
			new Thread(r).start();
		}
	}

	class SerialExecutor implements Executor {
		final Queue<Runnable> tasks = new ArrayDeque<Runnable>();
		final Executor executor;
		Runnable active;

		SerialExecutor(Executor executor) {
			this.executor = executor;
		}

		public synchronized void execute(final Runnable r) {
			tasks.offer(new Runnable() {

				@Override
				public void run() {
					try {
						r.run();
					} finally {
						scheduleNext();
					}

				}
			});
			if (active == null) {
				scheduleNext();
			}
		}

		private void scheduleNext() {
			active = tasks.poll();
			if ((active = tasks.poll()) != null) {
				executor.execute(active);
			}
		}
	}
}
