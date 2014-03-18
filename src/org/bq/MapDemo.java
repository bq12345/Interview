package org.bq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Student implements Comparable<Student> {
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {
		int i = this.getId() - o.getId();
		if (i < 0)
			return -1;
		else if (i == 0) {
			return 0;
		} else {
			return 1;
		}
		//return this.getId() - o.getId();
	}

}

public class MapDemo {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(2011303547, "bq");
		map.put(1, "wyj");
		map.put(2011, "baiqiang");
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.println(i);
			System.out.println(map.get(i));
		}
		for (Integer i : map.keySet()) {
			System.out.println(i);
			System.out.println(map.get(i));
		}
		System.out.println();
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1, "bq"));
		list.add(new Student(3, "baiqiang"));
		list.add(new Student(2, "hhhh"));
		for (Student s : list)
			System.out.println(s.getName());
		Collections.sort(list);
		for (Student s : list)
			System.out.println(s.getName());
		Comparator<Student> comp= Collections.reverseOrder();
		Collections.sort(list,comp);
		for (Student s : list)
			System.out.println(s.getName());
	}
}
