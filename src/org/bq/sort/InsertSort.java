/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.sort;

/**
 * @author ��ǿ
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
			// ��ǰ��
			int temp = a[i];
			int j = 0;
			// �Ե�ǰλ��֮ǰ���е����ֱ���
			for (j = i; j > 0; j--) {
				// ǰ�����ִ��ں�����򽻻��Ѵ��ֵ���ں���
				if (a[j - 1] > temp) {
					a[j] = a[j - 1];
				} else {
					break;
				}
			}
			// ǰ�����ִ�Ļ����Ǹ�λ�õ���������Ϊa[i]
			a[j] = temp;
			System.out.print("��" + i + "�Σ�\t");
			print(a);
			System.out.println();
		}
	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + "\t");
	}
}