/**.
 * Class for linked list recursion.
 */
class LinkedListRecursion {
    /**.
     * { var_description }
     */
	private Node head;
	/**.
     * { var_description }
     */
    private Node tail;
    /**.
     * { var_description }
     */
    public int size;
    /**.
     * { var_description }
     */
    private static int index;
	/**.
     * Class for node.
     */
    private class Node {
        /**.
         * { var_description }
         */
        private int value;
        /**.
         * { var_description }
         */
        private Node next;
    }
    /**.
     * Constructs the object.
     */
    LinkedListRecursion() {
        head = null;
        tail = null;
    }
    /**.
     * { function_description }
     *
     * @param      value  The value
     */
    // time complexity for this method:O(1)
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
    // time complexity for this method:O(1)
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
    // time complexity for this method:O(1)
    public void removeFront(){
    	if (head != null) {
            //int value = head.value;
            head = head.next;
            size--;
            //return value;
        }
    }
    // time complexity for this method:O(1)
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
    // time complexity for this method:O(1)
    public void insertAt(int position, int value) {
        insertAt(head, position, value);
    }
    // time complexity for this method:O(N)
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
    // time complexity for this method:O(1)
    public void reverse() {
    	head = reverseRecursive(head);
    }
    // time complexity for this method:O(N)
    public Node reverseRecursive(Node head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	Node temp = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null; 
        return temp;
    }
    // time complexity for this method:O(1)
    public boolean isEmpty() {
        return head == null;
    }
    // time complexity for this method:O(1)
    public int size() {
        return size;
    }
    // time complexity for this method:O(N)
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
