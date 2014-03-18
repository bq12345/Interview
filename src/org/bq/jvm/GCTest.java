/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ��ǿ
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
			System.err.println(Runtime.getRuntime().maxMemory()); //�������ڴ棬��Ӧ-Xmx
			System.err.println(Runtime.getRuntime().freeMemory()); //��ǰJVM�����ڴ�
			System.err.println(Runtime.getRuntime().totalMemory()); //��ǰJVMռ�õ��ڴ���������ֵ�൱�ڵ�ǰJVM��ʹ�õ��ڴ漰freeMemory()���ܺ�
			Thread.sleep(100000);
	}

}
