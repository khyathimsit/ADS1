/**.
 * { item_description }
 */
import java.util.Iterator;
/**.
 * { item_description }
 */
import java.util.NoSuchElementException;
/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
    
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<Integer, Student>
                    sc = new SeparateChainingHashST<>();
        Student st = new Student();
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String[] tokens = scan.nextLine().split(",");
            st = new Student(tokens[1], Double.parseDouble(tokens[2]));
            sc.put(Integer.parseInt(tokens[0]), st);
        }
        int querynum = Integer.parseInt(scan.nextLine());
        for (int j = 0; j < querynum; j++) {
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[0].equals("get")) {
                if (Integer.parseInt(tokens[2]) == 1) {
                    if (sc.get(Integer.parseInt(tokens[1])) != null) {
                        System.out.println(sc.get(Integer.parseInt(
                            tokens[1])).getname());
                    } else {
                        System.out.println("Student doesn't exists...");
                    }
                } else {
                    if (sc.get(Integer.parseInt(tokens[1])) != null) {
                        System.out.println(sc.get(
                            Integer.parseInt(tokens[1])).getmarks());
                    } else {
                        System.out.println("Student doesn't exists...");
                    }
                }
            }
        }
    }
}
// /**.
//  * { item_description }
//  */
// import java.util.Iterator;
// /**.
//  * { item_description }
//  */
// import java.util.NoSuchElementException;
/**.
 * List of .
 *
 * @param      <Item>  The item
 */
class Queue<Item> implements Iterable<Item> {
    /**.
     * { var_description }
     */
    private Node<Item> first;
    /**.
     * { var_description }
     */
    private Node<Item> last;
    /**.
     * { var_description }
     */
    private int n;
    /**.
     * Class for node.
     *
     * @param      <Item>  The item
     */
    private static class Node<Item> {
        /**.
         * { var_description }
         */
        private Item item;
        /**.
         * { var_description }
         */
        private Node<Item> next;
    }

    /**.
     * Initializes an empty queue.
     */
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    /**.
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**.
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**.
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /**.
     * Adds the item to this queue.
     *
     * @param  item the item to add
     */
    public void enqueue(final Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        n++;
    }

    /**.
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    /**.
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    /**.
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    /**.
     * Class for list iterator.
     *
     * @param      <Item>  The item
     */
    private class ListIterator<Item> implements Iterator<Item> {
        /**.
         * { var_description }
         */
        private Node<Item> current;
        /**.
         * Constructs the object.
         *
         * @param      first  The first
         */
        public ListIterator(Node<Item> first) {
            current = first;
        }
        /**.
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext()  {
            return current != null;
        }
        /**.
         * { function_description }
         */
        public void remove() { 
            throw new UnsupportedOperationException();
        }
        /**.
         * { function_description }
         *
         * @return     { description_of_the_return_value }
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}
