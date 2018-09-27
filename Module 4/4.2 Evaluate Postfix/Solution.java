import java.util.Scanner;
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
        private char value;
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
    public char pop() {
        char value = head.value;
        head = head.next;
        return value;
    }
    /**.
     * { function_description }
     *
     * @param      value  The value
     */
    public void push(final char value) {
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
        