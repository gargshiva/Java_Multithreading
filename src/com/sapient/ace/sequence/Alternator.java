package com.sapient.ace.sequence;

import java.util.ArrayList;
import java.util.List;

public class Alternator {
	private int index = 1;
	private List<Thread> threads = null;
	private Object lock = null;
	private final static int MAXLIMIT = 100;

	public Alternator() {
		threads = new ArrayList<Thread>();
		lock = new Object();
	}

	private class Task implements Runnable {
		@Override
		public void run() {
			while (getIndex() <= MAXLIMIT) {
				synchronized (lock) {
					while (getIndex() <= MAXLIMIT
							&& !Thread.currentThread().equals(getThread())) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					if(getIndex() <= MAXLIMIT) {
						System.out.println(Thread.currentThread().getName()
								+ " <-> " + getIndex());
						index = getIndex() + 1;
						lock.notifyAll();
					}
				
				}
			}

		}
	}

	private synchronized Thread getThread() {
		return threads.get((getIndex() - 1) % threads.size());
	}

	private synchronized int getIndex() {
		return index;
	}

	private void papulateList(int threadCount, Runnable task) {
		for (int i = 0; i < threadCount; ++i) {
			threads.add(new Thread(task));
		}
	}

	private void doStart() {
		for (Thread thread : threads) {
			thread.start();
		}
	}

	public static void main(String[] args) {
		Alternator alternator = new Alternator();
		alternator.papulateList(3, alternator.new Task());
		alternator.doStart();

	}
}
