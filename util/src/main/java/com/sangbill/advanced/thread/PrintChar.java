package com.sangbill.advanced.thread;

public class PrintChar implements Runnable {
	private char charToPrint;
	private int times;

	public PrintChar(char charToPrint, int times) {
		this.charToPrint = charToPrint;
		this.times = times;
	}

	public void run() {
		for (int i = 0; i < times; i++) {
			System.out.print(charToPrint);
		}
	}

}