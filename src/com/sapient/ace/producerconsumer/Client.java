package com.sapient.ace.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Client {
	public static void main(String[] args) {
		Queue<Integer> sharedQueue = new LinkedList<Integer>();
		final int size = 10;
		Producer producer = null;
		Consumer consumer = null;
		for (int i = 1; i <= 10; ++i) {
			producer = new Producer(sharedQueue, "Producer-" + i, size);
			producer.start();
		}

		for (int i = 1; i <= 10; ++i) {
			consumer = new Consumer(sharedQueue, "Consumer-" + i);
			consumer.start();
		}

	}
}
