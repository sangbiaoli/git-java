package com.sangbill.advanced.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TestExecutor {
	public static void main(String[] args) {
		//Create a fixed thread pool with maxium three thread
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		//Submit runnable tasks to the executor
		executor.execute(new PrintChar('a', 100));
		executor.execute(new PrintChar('b', 100));
		executor.execute(new PrintNum(100));
		
		//Shutdown the executor,don`t accept more runnable task
		executor.shutdown();
	}

}
