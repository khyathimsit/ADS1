class Steque {
	public Node head;
	public Node tail;
    public int size;
    
    private class Node {
        private int value;
        private Node next;
    }

    Steque() {
    	head = null;
        tail = null;
    }

    public void enqueue (final int value){
    	if (tail == null || head == null) {
           //Node oldTail = tail;
           Node temp = new Node();
           temp.value = value;
           temp.next = null;
           head = temp;
           tail = temp;
        } else {
           Node oldTail = tail;
    	   Node temp = new Node();
    	   temp.value = value;
    	   temp.next = null;
           oldTail.next = temp;
           tail = temp;
        }
        size++;
    }

    public void push (final int value) {
        if (head == null) {
            Node node = new Node();
            node.value = value;
            node.next = null;
            head = node;
            tail = node;
        } else {
            Node oldHead = head;
            Node temp = new Node();
            temp.value = value;
            temp.next = oldHead;
            head = temp; 
        }
        size++;
    }

    public int pop () {
    	if (head != null) {
            int value = head.value;
            head = head.next;
            size--;
            return value;
        }
        //return tail.value;
        return 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null || tail == null;
    }

    public String display() {
        if (size != 0) {
            String str = "";
            Node temp = head;
            while (temp != null) {
                str += temp.value + ", ";
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2);
        }
        return "";
    }
}
