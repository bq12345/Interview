/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public class ScannerTest {

	public static void main(String[] args) {
		Scanner scanner1 = null;
		Scanner scanner2 = null;
		try {
			Thread.sleep(50000);
			scanner1 = new Scanner(new File("D:\\baiqiang.c"));
			scanner2 = new Scanner("nihao baiqiang wyj").useDelimiter(" ");
			while (scanner1.hasNextLine()) {
				System.out.println(scanner1.nextLine());
			}
			while (scanner2.hasNext()) {
				System.out.println(scanner2.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (scanner1 != null) {
				scanner1.close();
			}
			if (scanner2 != null) {
				scanner2.close();
			}
		}
	}

}
