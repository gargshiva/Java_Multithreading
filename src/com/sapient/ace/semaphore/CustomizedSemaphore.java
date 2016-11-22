package com.sapient.ace.semaphore;

public class CustomizedSemaphore {

	private int permits;

	public CustomizedSemaphore(int permits) {
		if (permits < 1) {
			throw new IllegalArgumentException();
		}
		this.permits = permits;
	}

	public synchronized void acquire() throws InterruptedException {
		while (permits < 1) {
			this.wait();
		}

		if (permits >= 1) {
			--permits;
		}
	}

	public synchronized void release() {
		++permits;
		this.notifyAll();
	}

}
