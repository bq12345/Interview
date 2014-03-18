/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.klass;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public class TryCatchTest {

	public static void main(String[] args) {
		System.out.println(test());
	}
	public static String test() {
		int i=0;
		try {
			i=i/2;
			return "tryNormal";
		} catch (Exception e) {
			e.printStackTrace();
			return "tryCatch";
		}finally{
			System.out.println("--In fina");
			//return i;
		}
		
	}

}
