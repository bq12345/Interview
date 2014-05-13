/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.klass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 白强
 * @version 1.0 2014年03月08日11:00 2014年03月08日19:00 7小时00分 2014年03月08日11:00
 *          2014年03月08日14:00 7小时00分 2014年03月08日11:00 2014年03月08日18:00 7小时00分
 */
public class Late {

	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		int all = scanner.nextInt();
		int i = 0, j = 0;
		String[] ss = new String[all];
		scanner.nextLine();
		while (all > i) {
			ss[i] = scanner.nextLine();
			i++;
		}
		while (all > j) {
			System.out.println(parse(ss[j], j));
			j++;
		}

		scanner.close();
	}

	private static String parse(String string, int i) throws ParseException {
		String s = ":";
		String[] ss = string.split(" ");
		DateFormat format = new SimpleDateFormat("yyyy年MM月dd日hh:mm");
		DateFormat df = new SimpleDateFormat("hh小时mm分");
		Date start = format.parse(ss[0]);
		Date end = format.parse(ss[1]);
		Calendar cal = Calendar.getInstance();
		Date date = df.parse(ss[2]);
		cal.setTime(date);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		long time = (hour * 3600 + min * 60) * 1000;
		if (end.getTime() - start.getTime() > time) {
			s += "晚点";
		} else if (end.getTime() - start.getTime() == time) {
			s += "正点";
		} else {
			s += "早点";
		}
		return "Case" + (i + 1) + s;
	}

}
