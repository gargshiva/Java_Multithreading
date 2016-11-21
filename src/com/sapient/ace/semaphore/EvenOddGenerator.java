package com.sapient.ace.semaphore;

public class EvenOddGenerator {
	public static void main(String[] args) {
		CustomizedSemaphore binarySemphore = new CustomizedSemaphore(1);
		Signal signal = new Signal(false);
		EvenThread evenThread = new EvenThread(binarySemphore, signal);
		OddThread oddThread = new OddThread(binarySemphore, signal);

		evenThread.start();
		oddThread.start();
	}
}

class Signal {
	boolean isSignal;

	public Signal(boolean isSignal) {
		super();
		this.isSignal = isSignal;
	}

}