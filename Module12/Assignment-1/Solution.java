import java.util.Scanner;
public final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		Sorting sort = new Sorting();
		int number = Integer.parseInt(s.nextLine());
		int vacancies = Integer.parseInt(s.nextLine());
		int unreserved = Integer.parseInt(s.nextLine());
		int BC = Integer.parseInt(s.nextLine());
		int SC = Integer.parseInt(s.nextLine());
		int ST = Integer.parseInt(s.nextLine());
		int i = 0;
		Student[] st = new Student[number];
		while(number > 0){
			st[i] = new Student(s);
			//System.out.println(st[i]);
			i++;
			number--;
		}
		st = sort.sort(st);
		for (int j = 0; j < st.length; j++) {
            System.out.println(st[j]);
        }
        System.out.println();
    }
}
