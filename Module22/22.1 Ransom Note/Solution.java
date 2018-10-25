/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * { item_description }
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
        HashTable ht = new HashTable();
        String input = sc.nextLine();
        String[] tokens = input.split(" ");
        String line = sc.nextLine();
        String[] tokens1 = line.split(" ");
        for (int i = 0; i < tokens1.length; i++) {
            if (ht.contains(tokens1[i])) {
                ht.put(tokens1[i], ht.get(tokens1[i]) + 1);
            } else {
                ht.put(tokens1[i], 1);
            }
        }
        String line2 = sc.nextLine();
        String[] tokens2 = line2.split(" ");
        int[] array = new int[tokens2.length];
        for (int i = 0; i < tokens2.length; i++) {
            int value = ht.get(tokens2[i]);
            if (ht.contains(tokens2[i])) {
                array[i] = --value;
                ht.put(tokens2[i], value);
            } else {
                array[i] = value;
            }
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                count++;
                break;
            } else {
                count = 0;
            }
        }
        if (count == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
/**.
 * Class for hash table.
 */
class HashTable {
    /**.
     * { var_description }
     */
    private final int FIFTY = 50;
    /**.
     * { var_description }
     */
    private final int HEXA = 0x7fffffff;
    /**.
     * { var_description }
     */
    public int N = FIFTY;
    /**.
     * { var_description }
     */
    private Node[] s = new Node[N];
    /**.
     * Class for node.
     */
    public static class Node {
        /**.
         * { var_description }
         */
        private String key;
        /**.
         * { var_description }
         */
        private int val;
        /**.
         * { var_description }
         */
        private Node next;
        /**.
         * Constructs the object.
         *
         * @param      k   The key
         * @param      v   The value
         * @param      n     { parameter_description }
         */
        Node(final String k, final int v, final Node n) {
            this.key = k;
            this.val = v;
            this.next = n;
        }
    }
    /**.
     * { function_description }
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private int hash(final String key) {
        return (key.hashCode() & HEXA) % N;
    }
    /**.
     * { function_description }
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final String key, final int val) {
        int i = hash(key);
        for (Node x = s[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        s[i] = new Node(key, val, s[i]);
    }
    /**.
     * { function_description }
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final String key) {
        int i = hash(key);
        for (Node x = s[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return -1;
    }
    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final String k) {
        return get(k) != -1;
    }
}
