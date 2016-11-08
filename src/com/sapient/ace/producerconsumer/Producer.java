package com.sapient.ace.producerconsumer;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread {
	private Queue<Integer> queue = null;
	private int size = 0;

	public Producer(Queue<Integer> queue, String name ,int size) {
		this.queue = queue;
		this.size = size;
		this.setName(name);
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.size() == size) {
					try {
						System.out.println("Queue is full , Producer ["
								+ Thread.currentThread().getName()
								+ "] is waiting");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// To avoid exception during mis signal
				if (queue.size() != size) {
					Random random = new Random();
					int number = random.nextInt() % 10;
					System.out.println("Producer ["
							+ Thread.currentThread().getName()
							+ "] produced = " + number);
					queue.add(number);
					queue.notifyAll();
				}

			}
		}

	}
}
