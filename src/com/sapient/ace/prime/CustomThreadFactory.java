package com.sapient.ace.prime;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(CommonExceptionHandler.getInstance());
		return t;
	}
}
