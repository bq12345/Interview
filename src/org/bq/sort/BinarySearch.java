/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.sort;

/**
 * @author 白强
 * @version 1.0
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] a = { 0, 1, 5, 13, 24, 51, 63, 71, 85, 90 };
		int result = binarySearch(a, 50);
		System.out.println(result);
	}
	/**
	 * 对已经排好序的数组进行二分法查找
	 */
	public static int binarySearch(int[] array, int T) {
		int low, high, mid;
		low = 0;
		high = array.length - 1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (array[mid] < T) {
				low = mid + 1;
			} else if (array[mid] > T) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
