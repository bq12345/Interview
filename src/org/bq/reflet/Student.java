package org.bq.reflet;

import java.util.Date;

public class Student {
	private String name;
	private Date date;

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof Student) {
			Student s = (Student) obj;
			return this.name.equals(s.name) && this.date.equals(s.date);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", date=" + date + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Student(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}
	public Student() {
	}
}
