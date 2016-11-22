package com.sapient.ace.semaphore;

import java.util.Random;

public class EvenThread extends Thread {
	private CustomizedSemaphore customizedSemaphore = null;
	private Signal signal = null;

	public EvenThread(CustomizedSemaphore customizedSemaphore, Signal signal) {
		this.customizedSemaphore = customizedSemaphore;
		this.signal = signal;
	}

	@Override
	public void run() {
		while (true) {
			if (signal.isSignal) {
				try {
					customizedSemaphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Random random = new Random();
				int num = random.nextInt() % 10;
				if (num % 2 == 0) {
					System.out.println("Even thread = " + num);
				} else {
					System.out.println("Even thread = " + (num - 1));
				}
			}
			signal.isSignal = false;
			customizedSemaphore.release();
		}
	}
}
