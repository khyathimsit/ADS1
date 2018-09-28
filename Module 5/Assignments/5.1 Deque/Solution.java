import java.util.Scanner;
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Deque d = new Deque();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
				case"pushLeft":
					d.addFirst(Integer.parseInt(tokens[1]));
					System.out.println(d.display());
				break;

				case"pushRight":
					d.addLast(Integer.parseInt(tokens[1]));
					System.out.println(d.display());
				break;

				case"popLeft":
					d.deleteFirst();
					System.out.println(d.display());
				break;

				case"popRight":
					d.deleteLast();
					System.out.println(d.display());
				break;
				
				case"size" :
					System.out.println(d.size());
				break;
				
				default:
				break; 
			}
		}
	}
}