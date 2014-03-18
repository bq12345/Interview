/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.sort;

/**
 * @author 白强
 * @version 1.0
 */
public class SimpleQuick {

	public static void main(String[] args) {
		int[] a = { 5, 4, 3, 1, 8 };
		//调用快速排序算法
		quickSort(a, 0, a.length - 1);
		//打印排序后的元素
		for (int i : a) {
			System.out.print(i + "\t");
		}
	}
	//核心方法
	private static void quickSort(int[] a, int low, int high) {
		int q;
		//分治法思想的应用
		//当快速排序的递归调用可以进行
		if (low < high) {
			//用补坑法完成一次排序并再次递归
			q = partition(a, low, high);
			quickSort(a, low, q - 1);
			quickSort(a, q + 1, high);
		}
	}

	/**
	 *进行两次查找，从后往前和从前往后
	 *找到比基准小或比基准大的数就把基准数插入到那儿
	 *最后剩一个坑，把基准数填入即可
	 *返回坑的位置
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
