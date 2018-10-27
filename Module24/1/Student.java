class Student {
	private String studentname;
	private double totalmarks;
	Student() {
		
	}
	Student(String name, double marks) {
		this.studentname = name;
		this.totalmarks = marks;
	}
	public String getname() {
		return this.studentname;
	}
	public double getmarks() {
		return this.totalmarks;
	}
	public String toString() {
		String str = "";
		str = str + this.studentname + this.totalmarks;
		return str;
	}
}
