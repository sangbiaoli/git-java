package com.sangbill.advanced.thread;

public class PrintNum implements Runnable {
	private int num;

	public PrintNum(int num) {
		this.num = num;
	}

	public void run() {
		for (int i = 1; i <= num; i++) {
			System.out.print(" " + i);
		}
	}

}