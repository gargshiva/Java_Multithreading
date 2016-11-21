package com.sapient.ace.prime;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		CompletionService<PrimeNumber> completionService = new ExecutorCompletionService<>(
				executorService);
		PrimeNumberTask task = null;
		Future<PrimeNumber> future = null;
		PrimeNumber res = null;

		for (int i = 1; i <= 100; ++i) {
			task = new PrimeNumberTask(i);
			completionService.submit(task);
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 1; i <= 100; ++i) {
			try {
				future = completionService.take();
				res = future.get();
				if (res.isRes())
					System.out.println(res);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
