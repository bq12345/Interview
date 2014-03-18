package org.bq.thread;

public class Store {
		private final int MAX_SIZE;
		private int count;
		public Store(int n){
			MAX_SIZE=n;
			count=0;
		}
		public synchronized void add(){
			while(count>=MAX_SIZE){
				System.out.println("Full------Full");
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			count++;
			System.out.println(Thread.currentThread().toString()+"put"+count);
			this.notifyAll();
		}
		public synchronized void remove(){
			while(count<=0){
				System.out.println("Enpty------");
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().toString()+"remove"+count);
			count--;
			this.notifyAll();
		}
		public static void main(String[] args) {
			Store s=new Store(5);
			Thread pro=new Producer(s);
			Thread con=new Consumer(s);
			Thread pro2=new Producer(s);
			Thread con2=new Consumer(s);
			pro.setName("producer1");
			con.setName("consumer1");
			pro2.setName("producer2");
			con2.setName("consumer2");
			//Start all threads
			pro.start();
			con.start();
			pro2.start();
			con2.start();
		}
}
