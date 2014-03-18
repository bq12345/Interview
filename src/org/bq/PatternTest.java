package org.bq;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public class PatternTest {
	public static void main(String[] args) {
		Pattern p=Pattern.compile("[abc]+");
		Matcher m=p.matcher("aaaa");
		System.out.println(m.matches());
		boolean b = Pattern.matches("1[3458]\\d{9}", "13609128888");
		System.out.println(b);
		String s="aaaaab,hhhh,sgsdg,sge";
		String[] strs=s.split("\\,");
		System.out.println(strs.length);
	}
}
