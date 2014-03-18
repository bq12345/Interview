package org.bq.reflet;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReflectionDemo {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName("org.bq.reflet.Student");
		Student s = (Student) clazz.newInstance();
		s.setName("baiqiang");
		Date date=new Date();
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar.get(Calendar.YEAR));
		String str=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E").format(date);
		s.setDate(date);
		System.out.println(str);
		System.out.println(s.toString());
		Method[] methods = s.getClass().getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m.getName());
			Type[] types = m.getParameterTypes();
			for (Type t : types) {
				System.out.println(m+"-------"+t);
			}
		}
		Field[] fields = s.getClass().getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}
}
