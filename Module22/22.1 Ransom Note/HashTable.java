public class HashTable {
	private int N = 50;
	private Node[] s = new Node[N];

	public static class Node {
		public String key;
		public int val;
		public Node next;

		Node(String key, int val, Node n) {
			this.key = key;
			this.val = val;
			this.next = n;
		}
	}

	private int hash(String key) {
		return (key.hashCode() & 0x7fffffff) % N;
	}

	public void put(String key, int val) {
		int i = hash(key);
		for (Node x = s[i]; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.val = val;
				return;
			}
		}
		s[i] = new Node(key, val, s[i]);
	}

	public int get(String key) {
		int i = hash(key);
		for (Node x = s[i]; x != null; x = x.next) {
			if (key.equals(x.key)) {
				return x.val;
			}
		}
		return -1;
	}

	public boolean contains(String k) {
		return get(k) != -1;
	}
}