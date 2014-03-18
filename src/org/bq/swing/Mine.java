package org.bq.swing;

public class Mine {
	public static void main(String[] args) {
		int[][] a = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 5, 0 },
				{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		System.out.println(a.length);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				for (int m = -1; m <= 1; m++) {
					for (int n = -1; n <= 1; n++) {
						if (i + m > 0 && j + n > 0 && i + m < a[i].length
								&& j + n < a.length) {
							if (a[i + m][j + n] == 5) {
								a[i][j]++;
								a[i + m][j + n] = 5;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}

	}
}
