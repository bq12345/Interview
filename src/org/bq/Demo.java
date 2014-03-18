package org.bq;

import static java.lang.System.out;

public class Demo {
	public static int staticVar = 0;
	public int instanceVar = 0;

	public Demo() {
		staticVar++;
		instanceVar++;
		System.out.println("staticVar=" + staticVar + ",instanceVar="
				+ instanceVar);
	}

	public static void main(String[] args) {
		Object o = new Object() {
			public String toString() {
				return "My own Object";
			}
		};
		out.println(o.toString());
		int i = 0;
		while (i < 10) {
			new Demo();
			i++;
		}
	}
}