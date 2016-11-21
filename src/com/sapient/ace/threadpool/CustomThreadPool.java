package com.sapient.ace.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;

public class CustomThreadPool {
	int threadcount;
	private List<WorkerThread> threads = null;
	private BlockingQueue<Runnable> tasks = null;
	private boolean isStopped = false;

	public CustomThreadPool(int threadCount) {
		threads = new ArrayList<WorkerThread>();
		tasks = new LinkedBlockingQueue<Runnable>();

		this.threadcount = threadCount;
		for (int i = 0; i < threadCount; ++i) {
			WorkerThread workerThread = new WorkerThread(tasks);
			threads.add(workerThread);
			workerThread.start();
		}
	}

	public synchronized void execute(Runnable task) {
		if (isStopped)
			throw new RejectedExecutionException();

		tasks.add(task);
	}

	public void shutdown() {
		isStopped = true;
		for (WorkerThread workerThread : threads) {
			workerThread.doStop();
		}
	}

}
