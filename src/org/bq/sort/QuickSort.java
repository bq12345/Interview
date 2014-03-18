/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.sort;

/**
 * @author 白强
 * @version 1.0
 */
public class QuickSort {
	public void quickSort(String[] strDate, int left, int right) {
		String middle, tempDate;
		int i, j;
		i = left;
		j = right;
		middle = strDate[(i + j) / 2];
		do {
			while (strDate[i].compareTo(middle) < 0 && i < right)
				i++; // 找出左边比中间值大的数
			while (strDate[j].compareTo(middle) > 0 && j > left)
				j--; // 找出右边比中间值小的数
			if (i <= j) { // 将左边大的数和右边小的数进行替换
				tempDate = strDate[i];
				strDate[i] = strDate[j];
				strDate[j] = tempDate;
				i++;
				j--;
			}
		} while (i <= j); // 当两者交错时停止
		if (i < right) {
			quickSort(strDate, i, right);// 从
		}
		if (j > left) {
			quickSort(strDate, left, j);
		}
	}
	public static void main(String[] args) {
		String[] strVoid = new String[] { "11", "66", "22", "0", "55", "22",
				"0", "32" };
		QuickSort sort = new QuickSort();
		sort.quickSort(strVoid, 0, strVoid.length - 1);
		for (int i = 0; i < strVoid.length; i++) {
			System.out.print(strVoid[i] + "\t ");
		}
	}
}
