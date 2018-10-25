/**.
 * Class for hash table.
 */
public class HashTable {
    /**.
     * { var_description }
     */
    private int N = 50;
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
        public String key;
        /**.
         * { var_description }
         */
        public int val;
        /**.
         * { var_description }
         */
        public Node next;
        /**.
         * Constructs the object.
         *
         * @param      key   The key
         * @param      val   The value
         * @param      n     { parameter_description }
         */
        Node(String key, int val, Node n) {
            this.key = key;
            this.val = val;
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
        return (key.hashCode() & 0x7fffffff) % N;
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
