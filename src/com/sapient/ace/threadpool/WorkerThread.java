package com.sapient.ace.threadpool;

import java.util.concurrent.BlockingQueue;

public class WorkerThread extends Thread {
	private boolean isThreadPoolStopped = false;
	private BlockingQueue<Runnable> tasks = null;

	public WorkerThread(BlockingQueue<Runnable> tasks) {
		this.tasks = tasks;
	}

	@Override
	public void run() {
		while (!isThreadPoolStopped) {
			Runnable task = null;
			try {
				task = tasks.take();
				task.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void doStop() {
		isThreadPoolStopped = true;
		this.interrupt();
	}

}
