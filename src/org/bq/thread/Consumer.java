package org.bq.thread;

public class Consumer extends Thread {
	private Store s;

	public Consumer(Store s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			s.remove();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
