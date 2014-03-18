package org.bq.thread;

public class DeadLockTest implements Runnable {
	public int flag = 1;
	static Object o1 = new Object(), o2 = new Object();

	public static void main(String[] args) {
		DeadLockTest test1= new DeadLockTest();
		DeadLockTest test2= new DeadLockTest();
		test1.flag=1;
		test2.flag=0;
		new Thread(test1).start();
		new Thread(test2).start();
	}

	@Override
	public void run() {
		System.out.println("flag:---" + flag);
		if (flag == 1) {
			synchronized (o1) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println(1);
				}
			}
		}
		if (flag == 0) {
			synchronized (o2) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println(0);
				}
			}
		}
	}

}
