package org.bq.enumtest;

public enum Color {
	RED("��ɫ", 1), GREEN("��ɫ", 2), BLANK("��ɫ", 3), YELLOW("��ɫ", 4);
	// ��Ա����
	private String name;
	private int index;

	// ���췽��
	private Color(String name, int index) {
		this.name = name;
		this.index = index;
	}

	// ��ͨ����
	public static String getName(int index) {
		for (Color c : Color.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "["+this.getIndex()+","+this.getName()+"]";
	}
	
}
