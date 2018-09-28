class Deque {
	LinkedList deque;
	int size;
	Deque() {
		deque = new LinkedList();
	}
	public void addFirst(int item) {
		deque.insertFront(item);
	}

	public void addLast(int item) {
		deque.insertBack(item);
	}

	public void deleteFirst() {
		deque.removeFront();
	}

	public void deleteLast() {
		deque.removeBack();
	}

	public int size() {
		return deque.size();
	}

	public String display() {
		return deque.toString();
	}
}
