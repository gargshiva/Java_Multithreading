package org.sapient.ace.countdownlatch;

public class CustomizedCountDownLatch {
	private int threadCount;

	public CustomizedCountDownLatch(int threadCount) {
		this.threadCount = threadCount;
	}

	public synchronized void await() throws InterruptedException {
		while (threadCount != 0) {
			this.wait();
		}
	}

	public synchronized void countDown() {
		--threadCount;
		this.notifyAll();
	}
}
