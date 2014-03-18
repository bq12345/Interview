/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.sort;

/**
 * @author ��ǿ
 * @version 1.0
 */
public class Merge {

	public static void main(String[] args) {
		int[] a = { 5, 1, 3, 4, 9, 2 };
		mergeSort(a, 0, a.length - 1);
		print(a);
	}

	private static void print(int[] a) {
		for (int i : a) {
			System.out.print(i + "\t");
		}
	}

	/**
	 * �Ϳ�������һ���������÷��η� �ݹ��������
	 */
	private static void mergeSort(int[] a, int start, int end) {
		if (start < end) {
			int i;
			i = (end + start) / 2;
			// ��ǰ�벿�ֽ�������
			mergeSort(a, start, i);
			// �Ժ�벿�ֽ�������
			mergeSort(a, i + 1, end);
			// �ϲ�ǰ��������
			merge(a, start, i, end);
		}
	}

	private static void merge(int[] a, int start, int mid, int end) {
		// ������ʱ�������������벿������
		int[] temp1 = new int[10], temp2 = new int[10];
		int n1, n2;
		n1 = mid - start + 1;
		n2 = end - mid;
		// ����ǰ�벿������
		for (int i = 0; i < n1; i++)
			temp1[i] = a[start + i];
		// ������벿������
		for (int i = 0; i < n2; i++)
			temp2[i] = a[mid + i + 1];
		// �Ѻ����Ԫ�����õĺܴ���Է�ֹ���Ƚ�
		// ��Ϊnew int[10]����϶��в�����0
		temp1[n1] = temp2[n2] = 1000;
		// ���ɨ�����start-end֮������������Ȼ��ŵ���Ӧ��λ��ȥ
		for (int k = start, i = 0, j = 0; k <= end; k++) {
			// ���ǰ�����������Ӧ��ֵ��ǰ��С�ں���Ļ�
			if (temp1[i] <= temp2[j]) {
				// �ѵ�ǰ��λ������Ϊ��һ�������
				a[k] = temp1[i];
				// �Ѿ��źõľͲ��ٱȽ���
				i++;
				// ����һ�����
			} else {
				a[k] = temp2[j];
				j++;
			}
		}
		// ÿ�κϲ�������
		print(a);
		System.out.println();
	}

}
