package org.sapient.ace.countdownlatch;

public class ServiceTask extends Thread {

	private String serviceName;
	private CustomizedCountDownLatch customizedCountDownLatch;

	public ServiceTask(CustomizedCountDownLatch customizedCountDownLatch,
			String serviceName) {
		this.customizedCountDownLatch = customizedCountDownLatch;
		this.serviceName = serviceName;
	}

	@Override
	public void run() {
		if (serviceName.equalsIgnoreCase("Database service")) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Service started = " + serviceName);
		customizedCountDownLatch.countDown();
	}

}
