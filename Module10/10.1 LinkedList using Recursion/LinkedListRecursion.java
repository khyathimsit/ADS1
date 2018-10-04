class LinkedListRecursion {
	private Node head;
	private Node tail;
    public int size;
    private static int index;
	
    private class Node {
        private int value;
        private Node next;
    }

    LinkedListRecursion() {
        head = null;
        tail = null;
    }

    public void insertFront(final int value){
    	if (head == null) {
            Node oldHead = head;
            head = new Node();
            head.value = value;
            head.next = null;
            tail = head;
        } else {
            Node oldHead = head;
            head = new Node();
            head.value = value;
            head.next = oldHead;
        }
        size++;
    }
    public void insertBack(final int value){
    	if (tail == null) {
            Node oldTail = tail;
           tail = new Node();
           tail.value = value;
           tail.next = null;
           head = tail;
        }
        else {
            Node oldTail = tail;
    	   tail = new Node();
    	   tail.value = value;
    	   tail.next = null;
           oldTail.next = tail;
        }
        size++;
    }
    public void removeFront(){
    	if (head != null) {
            //int value = head.value;
            head = head.next;
            size--;
            //return value;
        }
    }

    public void removeBack(){
    	if (tail != null) {
            Node temp = null;
            Node pop = tail;
            Node head1 = head;
            while (head1 != tail){
                temp = head1;
                head1 = head1.next;
            } 
            //int item = temp.next.value;
            tail = temp;
            tail.next = null;
            size--;
            //return item; 
        }
    }
    public void insertAt(int position, int value) {
        insertAt(head, position, value);
    }

    public void insertAt(Node head, int position, int value) {
        if (position == 0) {
            insertFront(value);
            return;
        }

        if (index + 1 == position) {
            Node newnode = new Node();
            newnode.value = value;
            newnode.next = head.next;
            head.next = newnode;
            index = 0;
            return;
        }
        index++;
        insertAt(head.next, position, value);
    }
    public void reverse() {
    	head = reverseRecursive(head);
    }
    public Node reverseRecursive(Node head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	Node temp = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null; 
        return temp;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return size;
    }

    public String toString() {
        if (size != 0) {
            String str = "";
            Node temp = head;
            while (temp != null) {
                str += temp.value + ", ";
                // System.out.println(str);
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2);
        }
        return "";
    }
}
