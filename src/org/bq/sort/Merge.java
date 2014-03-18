/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.sort;

/**
 * @author 白强
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
	 * 和快速排序一样，都采用分治法 递归求解问题
	 */
	private static void mergeSort(int[] a, int start, int end) {
		if (start < end) {
			int i;
			i = (end + start) / 2;
			// 对前半部分进行排序
			mergeSort(a, start, i);
			// 对后半部分进行排序
			mergeSort(a, i + 1, end);
			// 合并前后两部分
			merge(a, start, i, end);
		}
	}

	private static void merge(int[] a, int start, int mid, int end) {
		// 两个临时数组来保存两半部分数组
		int[] temp1 = new int[10], temp2 = new int[10];
		int n1, n2;
		n1 = mid - start + 1;
		n2 = end - mid;
		// 拷贝前半部分数组
		for (int i = 0; i < n1; i++)
			temp1[i] = a[start + i];
		// 拷贝后半部分数组
		for (int i = 0; i < n2; i++)
			temp2[i] = a[mid + i + 1];
		// 把后面的元素设置的很大可以防止向后比较
		// 因为new int[10]后面肯定有部分是0
		temp1[n1] = temp2[n2] = 1000;
		// 逐个扫描介于start-end之间两部分数组然后放到相应的位置去
		for (int k = start, i = 0, j = 0; k <= end; k++) {
			// 如果前后两个数组对应的值是前面小于后面的话
			if (temp1[i] <= temp2[j]) {
				// 把当前的位置设置为第一个数组的
				a[k] = temp1[i];
				// 已经放好的就不再比较了
				i++;
				// 另外一种情况
			} else {
				a[k] = temp2[j];
				j++;
			}
		}
		// 每次合并后的情况
		print(a);
		System.out.println();
	}

}
