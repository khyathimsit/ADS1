/**.
 * importing util package
 */
import java.util.Scanner;
/**.
 * Class for stack linked list.
 */
class StackLL {
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
    StackLL() {
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

    /**.
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public char peek() {
        return head.value;
    }
}
/**
 * Class for solution.
 */
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
        int n = sc.nextInt();
        int val = 0;
        while (val < n) {
            String str = sc.next();
            if (isBalanced(str)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            val++;
        }
    }
    /**.
     * Determines if balanced.
     *
     * @param      s     { parameter_description }
     *
     * @return     True if balanced, False otherwise.
     */
    public static boolean isBalanced(final String s) {
        StackLL sll = new StackLL();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char character = s.charAt(i);
            if (character == '{' || character == '(' || character == '[') {
                sll.push(character);
            } else {
                if (sll.isEmpty()) {
                    return false;
                }
                if (character == ')' && sll.peek() == '(') {
                    sll.pop();
                } else if (character == ']' && sll.peek() == '[') {
                    sll.pop();
                } else if (character == '}' && sll.peek() == '{') {
                    sll.pop();
                } else {
                    return false;
                }
            }
        }
        return sll.isEmpty();
    }
}
