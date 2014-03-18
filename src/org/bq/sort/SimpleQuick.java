/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.sort;

/**
 * @author ��ǿ
 * @version 1.0
 */
public class SimpleQuick {

	public static void main(String[] args) {
		int[] a = { 5, 4, 3, 1, 8 };
		//���ÿ��������㷨
		quickSort(a, 0, a.length - 1);
		//��ӡ������Ԫ��
		for (int i : a) {
			System.out.print(i + "\t");
		}
	}
	//���ķ���
	private static void quickSort(int[] a, int low, int high) {
		int q;
		//���η�˼���Ӧ��
		//����������ĵݹ���ÿ��Խ���
		if (low < high) {
			//�ò��ӷ����һ�������ٴεݹ�
			q = partition(a, low, high);
			quickSort(a, low, q - 1);
			quickSort(a, q + 1, high);
		}
	}

	/**
	 *�������β��ң��Ӻ���ǰ�ʹ�ǰ����
	 *�ҵ��Ȼ�׼С��Ȼ�׼������Ͱѻ�׼�����뵽�Ƕ�
	 *���ʣһ���ӣ��ѻ�׼�����뼴��
	 *���ؿӵ�λ��
	 */
	private static int partition(int[] a, int low, int high) {
		int temp = a[low];
		while (low < high) {
			while (low < high && a[high] > temp) {
				high--;
			}
			a[low] = a[high];
			while (low < high && a[low] < temp) {
				low++;
			}
			a[high] = a[low];
		}
		a[low] = temp;
		return low;
	}

}
