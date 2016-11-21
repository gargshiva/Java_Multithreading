package com.sapient.ace.prime;

import java.util.concurrent.Callable;

public class PrimeNumberTask implements Callable<PrimeNumber> {

	private int number;

	public PrimeNumberTask(int number) {
		this.number = number;
	}

	@Override
	public PrimeNumber call() throws Exception {
		PrimeNumber primeNumber = new PrimeNumber();
		primeNumber.setNum(number);
		boolean res = true;
		
		if (number == 1) {
			res = false;
		} else if (number == 2) {
			res = true;
		} else {
			for (int i = 2; i <= Math.sqrt(number); ++i) {
				if (number % i == 0) {
					res = false;
					break;
				}
			}
		}
		primeNumber.setRes(res);
		return primeNumber;
	}

}
