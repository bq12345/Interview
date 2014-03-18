package org.bq.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2, 0,
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
		pool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread test1");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		pool.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread test2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
pool.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread test3");
			}
		});
	}
}
