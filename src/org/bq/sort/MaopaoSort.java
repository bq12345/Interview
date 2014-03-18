package org.bq.sort;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public class MaopaoSort {
		public static void main(String[] args) {
			int[] a={1,5,6,9,8,4,2,3,0,7};
			sort(a);
			print(a);
		}

		private static void print(int[] a) {
			for(int i=0;i<a.length;i++)
				System.out.print(a[i]+"\t");
		}

		private static void sort(int[] a) {
			for(int i=0;i<a.length;i++)
				for(int j=0;j<a.length-1;j++){
					if(a[j]>a[j+1]){
						int temp=a[j+1];
						a[j+1]=a[j];
						a[j]=temp;
					}
				}
		}
}
