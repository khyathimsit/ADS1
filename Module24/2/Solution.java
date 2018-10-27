import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() { }
	/**
	 * { Main function }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		RedBlackBST<Student, Integer> bst = new RedBlackBST<>();
		Student st = new Student();
		for (int i = 0; i < num; i++) {
            String[] tokens = scan.nextLine().split(",");
            st = new Student(tokens[1], tokens[2], tokens[0]);
            bst.put(st, Integer.parseInt(tokens[0]));
        }
		int querynum = Integer.parseInt(scan.nextLine());
		for (int j = 0; j < querynum; j++) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
			case "LE":
				double low = Double.parseDouble(tokens[1]);
				for (Student i : bst.keys()) {
					if (i.marks <= low) {
						System.out.println(i.name);
					}
				}
				break;
			}
			querynum--;
		}
	}
}
