/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.sort;

/**
 * @author 白强
 * @version 1.0
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] a = { 1, 5, 6, 9, 8, 4, 2, 3, 0, 7 };
		sort(a);
		print(a);
	}

	private static void sort(int[] a) {

		for (int i = 0; i < a.length; i++) {
			// 当前点
			int temp = a[i];
			int j = 0;
			// 对当前位置之前所有的数字遍历
			for (j = i; j > 0; j--) {
				// 前面数字大于后面的则交换把大的值放在后面
				if (a[j - 1] > temp) {
					a[j] = a[j - 1];
				} else {
					break;
				}
			}
			// 前面数字大的话把那个位置的数字设置为a[i]
			a[j] = temp;
			System.out.print("第" + i + "次：\t");
			print(a);
			System.out.println();
		}
	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + "\t");
	}
}