package com.sapient.ace.downloadmanager;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
	ThreadExceptionHandler threadExceptionHandler = new ThreadExceptionHandler();

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(threadExceptionHandler);
		return t;
	}

	class ThreadExceptionHandler implements UncaughtExceptionHandler {

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println(t.getName() + " has thrown exception");
			e.printStackTrace();
		}

	}
}
