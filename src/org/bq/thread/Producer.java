package org.bq.thread;

public class Producer extends Thread {
	private Store s;

	public Producer(Store s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			s.add();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
