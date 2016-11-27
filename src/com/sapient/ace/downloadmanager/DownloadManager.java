package com.sapient.ace.downloadmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadManager {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5,
				new CustomThreadFactory());
		ExecutorCompletionService<RandomFile> completionService = new ExecutorCompletionService<RandomFile>(
				executorService);

		List<RandomFile> fileList = new ArrayList<RandomFile>();
		for (int i = 1; i <= 1000; ++i) {
			fileList.add(new RandomFile(i, false));
		}

		for (int i = 1; i <= 1000; ++i) {
			completionService.submit(new FileDownloader(fileList.get(i - 1)));
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 1; i <= 1000; ++i) {
			try {
				RandomFile file = completionService.take().get();
				System.out.println(file);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
