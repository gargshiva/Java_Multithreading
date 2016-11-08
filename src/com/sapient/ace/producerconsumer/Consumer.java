package com.sapient.ace.producerconsumer;

import java.util.Queue;

public class Consumer extends Thread {
	private Queue<Integer> queue = null;

	public Consumer(Queue<Integer> queue, String name) {
		this.queue = queue;
		this.setName(name);
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						System.out.println("Queue is empty , ["
								+ Thread.currentThread().getName()
								+ "] is waiting ");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (!queue.isEmpty()) {
					int pulledNumber = queue.remove();
					System.out.println("Consumer , ["
							+ Thread.currentThread().getName()
							+ "] consumed = " + pulledNumber);
					queue.notifyAll();
				}

			}
		}
	}

}
