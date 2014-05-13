/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public class FullPerm {
	private static int count=0;
	public static void main(String[] args) {
		List<Character> input=new ArrayList<Character>();
		input.add('A');
		input.add('B');
		input.add('C');
		input.add('D');
		perm(input, new ArrayList<Character>());
		System.out.println("COUNT:"+count);
		
	}
	public static void perm(List<Character> src,List<Character> des){
		if(src.size()==0){
			for(int i=0;i<des.size();i++)
				System.out.print(des.get(i)+" ");
			System.out.println();
			count++;
			return;
		}
		for(int i=0;i<src.size();i++){
			List<Character> ts=new ArrayList<Character>(src);
			List<Character> tr=new ArrayList<Character>(des);
			tr.add(ts.get(i));
			ts.remove(i);
			perm(ts, tr);
		}
	}

}
