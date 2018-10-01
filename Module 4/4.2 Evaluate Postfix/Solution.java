import java.util.Scanner;
import java.util.Arrays;
class LinkedStack {
    /**.
     * variable head of node type.
     */
    private Node head;
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
        /**.
         * Constructor
         */
        Node() {
        /**
        * { item_description }
        */
        }
    }
    /**.
     * Constructs the object.
     */
    LinkedStack() {
        head = null;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int pop() {
        int value = head.value;
        head = head.next;
        return value;
    }
    /**.
     * { function_description }
     *
     * @param      value  The value
     */
    public void push(final int value) {
        Node oldHead = head;
        head = new Node();
        head.value = value;
        head.next = oldHead;
    }
}

public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        /**.
         * { item_description }
         */
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int element1;
        int element2;
        String[] tokens = sc.nextLine().split(" ");
        LinkedStack s = new LinkedStack();
        for (int i = 0; i < tokens.length; i++) {
            if (!(Arrays.asList("+", "-", "*", "/").contains(tokens[i]))) {
                s.push(Integer.parseInt(tokens[i]));
            } else {
                element1 = s.pop();
                element2 = s.pop();
                if (tokens[i].equals("+")) {
                    s.push(element1 + element2);
                } else if (tokens[i].equals("-")) {
                    s.push(element1 - element2);
                } else if (tokens[i].equals("*")) {
                    s.push(element1 * element2);
                } else {
                    s.push(element1 / element2);
                }
            }
        }
        System.out.println(s.pop());
    }
}
