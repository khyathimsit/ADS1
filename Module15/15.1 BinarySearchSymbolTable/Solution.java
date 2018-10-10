import java.util.Scanner;
public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchST bs = new BinarySearchST();
		String line = sc.nextLine();
		String[] tokens = line.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			bs.put(tokens[i], i);
		}
		while(sc.hasNext()) {
			String input = sc.nextLine();
			String[] tokens1 = input.split(" ");
			switch (tokens1[0]) {
				case "get":
					System.out.println(bs.get(tokens1[1]));
				return;

				case "max":
					System.out.println(bs.max());
				return;

				case "floor":
					System.out.println(bs.floor(tokens1[1]));
				return;

				case "rank":
					System.out.println(bs.rank(tokens1[1]));
				return;

				case "contains":
					System.out.println(bs.contains(tokens1[1]));
				return;

				case "deleteMin":
					bs.deleteMin();
				return;

				case "keys":
					System.out.println(bs.keys());
				return;
			}
		}
	}
}
