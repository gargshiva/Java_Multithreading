package org.sapient.ace.cyclicbarrier;

public class CustomizedCyclicBarrier {
	private int threadCount;
	private int previousState;

	public CustomizedCyclicBarrier(int threadCount) {
		this.threadCount = threadCount;
		this.previousState = threadCount;
	}

	public synchronized void await() {
		--threadCount;
		if (threadCount != 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (threadCount == 0) {
			this.notifyAll();
		}
	}

	public void resetBarrier() {
		threadCount = previousState;
	}
}
