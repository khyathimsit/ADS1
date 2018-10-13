import java.util.Scanner;

class Stock implements Comparable<Stock> {
	private String name;
	private float change;
	Stock(String n, float c) {
		this.name = n;
		this.change = change;
	}
	public String getname() {
		return this.name;
	}
	public float getchange() {
		return this.change;
	}
	public int compareTo(Stock other) {
		if (this.change > other.change) {
			return 1;
		}
		if (this.change < other.change) {
			return -1;
		}
		if (this.name.compareTo(other.name) > 0) {
			return 1;
		}
		if (this.name.compareTo(other.name) < 0) {
			return -1;
		}
		return 0;
	}
	public String toString() {
		String str = "";
		str = str + this.name + " " + this.change;
		return str;
	}
}
class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchST<String, Integer> maxST = new  BinarySearchST<>();
		BinarySearchST<String, Integer> minST = new BinarySearchST<>();
		int num = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < 6; i++) {
			int count = 0;
			MinPQ<Stock> minpq = new MinPQ<>();
			MaxPQ<Stock> maxpq = new MaxPQ<>();
			while (count < num) {
				String[] details = scan.nextLine().split(",");
				Stock stock = new Stock(details[0], Float.parseFloat(details[1]));
				minpq.insert(stock);
				maxpq.insert(stock);
				count++;
			}
			for (int j = 0; j < 5; j++) {
				Stock max = maxpq.delMax();
				if (maxST.contains(max.getname())) {
					int value = maxST.get(max.getname());
					maxST.put(max.getname(), ++value);
				} else {
					maxST.put(max.getname(), 1);
				}
				System.out.println(max);
			}
			System.out.println();
			for (int k = 0; k < 5; k++) {
				Stock min = minpq.delMin();
				if (minST.contains(min.getname())) {
					int valuemin = minST.get(min.getname());
					minST.put(min.getname(), ++valuemin);
				} else {
					minST.put(min.getname(), 1);
				}
				System.out.println(min);
			}
			System.out.println();
		}
	}
}
