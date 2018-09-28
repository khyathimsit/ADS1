class LinkedList {
	private Node head;
	private Node tail;
    public int size;
	
    private class Node {
        private int value;
        private Node next;
    }

    LinkedList() {
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
    	Node temp = null;
        Node pop = tail;
        Node head1 = head;
    	while (head1 != tail){
    		temp = head1;
            head1 = head1.next;
    	}
    	//int item = temp.next.value;
    	
    	tail = temp;
        //tail.next = null;
        size--;
    	//return item;
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (size != 0) {
            String str = "[";
            Node temp = head;
            while (temp.next != null) {
                str += temp.value + ", ";
                temp = temp.next;
            }
            return str + str.substring(0, str.length() - 2) + "]";
        }
        return "[]";
    }
}
