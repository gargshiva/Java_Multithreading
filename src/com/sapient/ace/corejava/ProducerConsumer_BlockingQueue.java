package com.sapient.ace.corejava;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer_BlockingQueue {
	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(
				2);

		Producer producer = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);

		producer.start();
		consumer.start();
	}

}

class Producer extends Thread {
	private BlockingQueue<Integer> blockingQueue = null;

	public Producer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			Random random = new Random();
			int number = random.nextInt() % 10;
			try {
				blockingQueue.put(number);
				System.out.println("Producer has produced = " + number);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

class Consumer extends Thread {
	private BlockingQueue<Integer> blockingQueue = null;

	public Consumer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				int number = blockingQueue.take();
				System.out.println("Consumer has consumed = " + number);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}