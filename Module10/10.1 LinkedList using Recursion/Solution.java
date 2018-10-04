import java.util.Scanner;
public class Solution {
	private Solution() {

	}

	public static void main(String[] args) {
		LinkedListRecursion list = new LinkedListRecursion();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            switch(tokens[0]) {
            	case "insertAt":
            		if (Integer.parseInt(tokens[1]) < 0 || Integer.parseInt(
            			tokens[1]) > list.size() + 1) {
            			System.out.println("Can't insert at this position.");
            		} else {
            			list.insertAt(Integer.parseInt(tokens[1]),
            				Integer.parseInt(tokens[2]));
            			System.out.println(list.toString());
            		}
            	break;
            	// case"pushLeft":
             //        list.insertFront(Integer.parseInt(tokens[1]));
             //        System.out.println(list.toString());
             //    break;

            	case "reverse":
            		if (!list.isEmpty()) {
            			list.reverse();
            			System.out.println(list.toString());
            		} else {
            			System.out.println("No elements to reverse.");
            		}
            	break;
            }
        }
    }
}
