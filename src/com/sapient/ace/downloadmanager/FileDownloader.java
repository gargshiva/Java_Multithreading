package com.sapient.ace.downloadmanager;

import java.util.concurrent.Callable;

public class FileDownloader implements Callable<RandomFile> {
	private RandomFile randomFile;

	public FileDownloader(RandomFile randomFile) {
		this.randomFile = randomFile;
	}

	@Override
	public RandomFile call() throws Exception {
		Thread.sleep(3000);
		randomFile.setStatus(true);
		return randomFile;
	}

}
