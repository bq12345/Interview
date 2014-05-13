/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.dp;

/**
 * @author 白强
 * @version 1.0
 */
public class LCS {

	/**
	 * 最长公共子序列求解算法
	 *
	 * @param lengthS1
	 *            第一个序列的长度
	 * @param lengthS2
	 *            第二个序列的长度
	 * @param s1
	 *            第一个序列头指针
	 * @param s2
	 *            第二个序列头指针
	 * @param result
	 *            最长公共子序列递推求解结果矩阵，m+1行,n+1列
	 * @param trace
	 *            最长公共子序列追踪矩阵，m+1行,n+1列
	 */
	static int LCSLength(int lengthS1, int lengthS2, char[] s1, char[] s2,
			int[][] result, int[][] trace) {

		trace[0][0] = 0; // trace[i][0]与trace[0][j]不用，可以用作标志位

		for (int i = 0; i <= lengthS1; i++)
			result[i][0] = 0;
		for (int j = 1; j <= lengthS2; j++)
			result[0][j] = 0;

		for (int i = 1; i <= lengthS1; i++) {
			for (int j = 1; j <= lengthS2; j++) {
				if (s1[i - 1] == s2[j - 1]) { // 两个序列尾部匹配
					result[i][j] = result[i - 1][j - 1] + 1;
					trace[i][j] = 1;// 1表示继续向左上[i-1][j-1]追踪
				} else if (result[i - 1][j] >= result[i][j - 1]) { // 当前最长序列由s1尾部前移一位与s2构成
					result[i][j] = result[i - 1][j];
					trace[i][j] = 2; // 2表示继续向上[i-1][j]追踪
				} else { // 当前最长序列由s2尾部前移一位与s1构成
					result[i][j] = result[i][j - 1];
					trace[i][j] = 3; // 3表示继续向上[i][j-1]追踪
				}
			}
		}
		return result[lengthS1][lengthS2];
	}

	/**
	 * 最长公共子序列追踪构造算法
	 * 
	 * @param tailS1
	 *            第一个序列尾部位置
	 * @param tailS2
	 *            第二个序列的尾部位置
	 * @param s1
	 *            第一个序列头指针，根据追踪矩阵在其中搜索公共子序列中字符
	 * @param trace
	 *            追踪矩阵
	 */

	static void LCSTraceback(int tailS1, int tailS2, char[] s1, int[][] trace) {

		if (tailS1 == 0 || tailS2 == 0)
			return;

		if (trace[tailS1][tailS2] == 1) { // 向左上追踪[i-1][j-1]
			LCSTraceback(tailS1 - 1, tailS2 - 1, s1, trace);
			System.out.print(s1[tailS1 - 1] + "\t");
		} else if (trace[tailS1][tailS2] == 2) { // 继续向上追踪[i-1][j]
			LCSTraceback(tailS1 - 1, tailS2, s1, trace);
		} else
			LCSTraceback(tailS1, tailS2 - 1, s1, trace);
	}

	public static void main(String[] args) {
		int lengthS1 = 7, lengthS2 = 6;
		char[] s1 = "abcbdab".toCharArray();
		char[] s2 = "bdcaba".toCharArray();
		System.out.print("s1: ");
		for (int i = 0; i < lengthS1; i++)
			System.out.print(" " + s1[i]);
		System.out.println();
		System.out.print("s2: ");
		for (int i = 0; i < lengthS2; i++)
			System.out.print(" " + s2[i]);
		System.out.println();
		int[][] resultMatrix = new int[lengthS1 + 1][lengthS2 + 1];// m+1行n+1列迭代结果矩阵
		int[][] traceMatrix = new int[lengthS1 + 1][lengthS2 + 1];// m+1行n+1列追踪矩阵
		System.out.println("The length of the longest common sequence is: "
				+ LCSLength(lengthS1, lengthS2, s1, s2, resultMatrix,
						traceMatrix));
		System.out.println("The longest common sequece is: ");
		LCSTraceback(lengthS1, lengthS2, s1, traceMatrix);
	}

}
