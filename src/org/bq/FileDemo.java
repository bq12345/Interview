package org.bq;

import java.io.File;
import java.util.Properties;

public class FileDemo {
	static Properties properties = System.getProperties();
	static String rootStr = FileDemo.class.getClassLoader().getResource(".")
			.getPath().substring(1);

	public static void main(String[] args) {
		for (Object o : properties.keySet()) {
			System.out.print(o);
			System.out.print(":");
			System.out.println(properties.get(o));
		}
		String root = properties.getProperty("user.dir");
		System.out.println(root);
		System.out.println(rootStr);
		File file = new File(root);
		new FileDemo().parse(file);
	}

	private void parse(File root) {
		if (root.isDirectory()) {
			for (File file : root.listFiles()) {
				parse(file);
			}
		} else {
			if (root.getName().endsWith(".class")
					|| root.getName().endsWith(".java")) {
				System.out.println(root.getName());
			}
		}
	}
}
