package org.bq.thread;

public class SyncTest implements Runnable {
	Timer timer = new Timer();

	public static void main(String[] args) {
		SyncTest test = new SyncTest();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		timer.add(Thread.currentThread().getName());
	}
}

class Timer {
	public static int num = 0;

	public void add(String s) {
		synchronized (this) {
			num++;
			System.out.println(num);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			System.out.println(s + "," + num);
		}

	}
}
