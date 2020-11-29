package com.sangbill.leecode.concurrent;

import java.util.concurrent.Semaphore;

class DiningPhilosophers {
	private int SIZE = 5;
	private Semaphore[] sems = new Semaphore[SIZE];// 0(4,0),1(0,1)，...

	public DiningPhilosophers() {
		for (int i = 0; i < SIZE; i++) {
			sems[i] = new Semaphore(1);
		}
	}

	// call the run() method of any runnable to execute its code
	public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
			Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
		Semaphore left = (philosopher > 0) ? sems[philosopher] : sems[SIZE - 1];
		Semaphore right = (philosopher > 0) ? sems[philosopher + 2] : sems[0];
		while (left.tryAcquire() && right.tryAcquire()) {
			left.wait();
			right.wait();
		}
		left.acquire();
		right.acquire();
		pickLeftFork.run();
		pickRightFork.run();
		eat.run();
		putLeftFork.run();
		pickRightFork.run();
		left.release();
		right.release();

	}
}