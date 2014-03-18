/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 白强
 * @version 1.0
 */
public class GCTest {

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Thread.sleep(4000);
			for(int i=0;i<1000000;i++){
				 GCTest  test=new GCTest(); List list=new ArrayList(); list.add(test);
				 Class.forName("org.bq.jvm.GCTest").newInstance();
			}
			//int i=0;
			Thread.sleep(4000);
			//System.gc();
			for(int i=0;i<1000000;i++){
				 GCTest  test=new GCTest(); 
				 List list=new ArrayList(); list.add(test);
				  Class.forName("org.bq.jvm.GCTest").newInstance();
			}
			Thread.sleep(4000);
			//System.gc();
			for(int i=0;i<1000000;i++){
				 GCTest  test=new GCTest(); List list=new ArrayList(); list.add(test);
				  Class.forName("org.bq.jvm.GCTest").newInstance();
			}
			Thread.sleep(4000);
			//System.gc();
			for(int i=0;i<1000000;i++){
				 GCTest  test=new GCTest(); List list=new ArrayList(); list.add(test);
				  Class.forName("org.bq.jvm.GCTest").newInstance();
			}
			
			Thread.sleep(4000);
			//System.gc();
			for(int i=0;i<1000000;i++){
				 GCTest  test=new GCTest(); List list=new ArrayList(); list.add(test);
				  Class.forName("org.bq.jvm.GCTest").newInstance();
			}
			Thread.sleep(4000);
			//System.gc();
			for(int i=0;i<1000000;i++){
				 GCTest  test=new GCTest(); List list=new ArrayList(); list.add(test);
				  Class.forName("org.bq.jvm.GCTest").newInstance();
			}
			Thread.sleep(4000);
			System.gc();
			for(int i=0;i<1000000;i++){
			GCTest test = new GCTest();
			List list = new ArrayList();
			list.add(test);
				  Class.forName("org.bq.jvm.GCTest").newInstance();
			}
			System.err.println(Runtime.getRuntime().maxMemory()); //最大可用内存，对应-Xmx
			System.err.println(Runtime.getRuntime().freeMemory()); //当前JVM空闲内存
			System.err.println(Runtime.getRuntime().totalMemory()); //当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和
			Thread.sleep(100000);
	}

}
