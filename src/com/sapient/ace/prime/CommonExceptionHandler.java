package com.sapient.ace.prime;

import java.lang.Thread.UncaughtExceptionHandler;

public class CommonExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t.getName() + " <-> has thrown exception ");
		e.printStackTrace();
	}

	private static class CommonExceptionHandlerHelper {
		private final static CommonExceptionHandler commonExceptionHandler = new CommonExceptionHandler();
	}

	public static CommonExceptionHandler getInstance() {
		return CommonExceptionHandlerHelper.commonExceptionHandler;
	}

}
