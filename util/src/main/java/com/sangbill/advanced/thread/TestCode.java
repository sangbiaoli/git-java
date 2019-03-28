package com.sangbill.advanced.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class TestCode {

	public static class CodeThread implements Runnable {
		private String code;
		public CodeThread(String code) {
			this.code	 = code;
		}

		public void run() {
			resultQueue.offer(count +":"+code+"\t");
			synchronized(count){				
				count++;
				if(count >= MAX_SIZE){
					count = 0;				
				}
			}
		}

	}
	static LinkedBlockingQueue<String> codeQueue = new LinkedBlockingQueue<String>();
	static LinkedBlockingQueue<String> resultQueue = new LinkedBlockingQueue<String>();
	static ExecutorService pool = Executors.newFixedThreadPool(40);
	static Integer count = 0;
	final static Integer MAX_SIZE = 50;
	public static void main(String[] args) {
		new Thread(){
			public void run(){		
				String code = null;
				while(true){					
					while(codeQueue.size() == 0){		
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					code = codeQueue.poll();
					if(code != null){
						pool.execute(new CodeThread(code));
					}						
				}
			}
		}.start();
		
		new Thread(){
			public void run(){		
				while(true){		
					while(resultQueue.size() < MAX_SIZE){
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int i = 0; i < MAX_SIZE; i++) {						
						String code = resultQueue.poll();
						System.out.println(code);
					}					
				}
			}
		}.start();
		
		
		// 创建一个可重用固定线程数的线程池
		// 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
		while(true){
			String s = "a";
			int index = 0;
			while(index < 26){
				codeQueue.offer(s+index);
				index ++;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
