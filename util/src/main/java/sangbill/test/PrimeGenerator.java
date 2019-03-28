package com.sangbill.test;

class PrimeGenerator implements Runnable {
	private boolean cancelled;
	@Override
	public void run() {
		while (!cancelled)		{
			System.out.println("Running...");
			// doingsomething here...
		}
	}

	public void cancel() {
		cancelled = true;
	}
}