package org.sapient.ace.countdownlatch;

public class Application {
	public static void main(String[] args) {
		CustomizedCountDownLatch customizedCountDownLatch = new CustomizedCountDownLatch(
				2);
		ServiceTask cacheService = new ServiceTask(customizedCountDownLatch,
				"Cache service");
		ServiceTask databaseService = new ServiceTask(customizedCountDownLatch,
				"Database service");

		cacheService.start();
		databaseService.start();

		try {
			customizedCountDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Application Started");

	}
}
