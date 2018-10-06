import java.util.Scanner;
class Student {
	String name; 
	String dob;
	int marks1; 
	int marks2;
	int marks3; 
	int total; 
	String category;

	Student(final Scanner sc) {
		String[] input = sc.nextLine().split(",");
		name = input[0];
		dob = input[1];
		marks1 = Integer.parseInt(input[2]);
		marks2 = Integer.parseInt(input[3]);
		marks3 = Integer.parseInt(input[4]);
		total = Integer.parseInt(input[5]);
		category = input[6];
	}

	public String getName() {
		return this.name;
	}
	public String getDOB() {
		return this.dob;
	}
	public int getTotal() {
		return this.total;
	}
	public String getCategory() {
		return this.category;
	}
	public int getMarks1() {
		return this.marks1;
	}
	public int getMarks2() {
		return this.marks2;
	}
	public int getMarks3() {
		return this.marks3;
	}

	public String toString() {
        String str = name + "," + Integer.toString(total) + "," + category;
        return str;
    }
}
	