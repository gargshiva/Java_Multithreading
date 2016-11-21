package com.sapient.ace.prime;

public class PrimeNumber {
	private boolean res;
	private int num;

	public boolean isRes() {
		return res;
	}

	public void setRes(boolean res) {
		this.res = res;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "PrimeNumber [res=" + res + ", num=" + num + "]";
	}

}
