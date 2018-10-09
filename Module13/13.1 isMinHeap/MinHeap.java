/**
 * Class for minimum heap.
 *
 * @param      <E>   { Generic type }.
 */
class MinHeap<E extends Comparable<E>> {
    /**
     * { Private value }.
     */
    private E[] array;
    /**
     * { Private value }.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      len   The length
     */
    protected MinHeap(final int len) {
        array = (E[]) new Comparable[len + 1];
        size = 0;
    }
    /**
     * { Insert method }.
     *
     * @param      value  The value
     *
     * @return     { Generic type }.
     *
     *Time Complexity:O(logN)
     */
    public boolean insert(final E value) {
        array[++size] = value;
        return (swim(size));
    }
    /**
     * { For checking minheap }.
     *
     * @param      k1     { Integer }.
     *
     * @return     { Boolean }.
     * Time Complexity:O(logN)
     */
    public boolean swim(final int k1) {
        int k = k1;
        while (k > 1 && less(k / 2, k)) {
            k = k / 2;
        }
        if (k > 1) {
            return false;
        }
        return true;
    }
    /**
     * { For compareTo }.
     *
     * @param      one   One
     * @param      two   Two
     *
     * @return     { boolean }.
     * Time Complexity : O(1)
     */
    public boolean less(final int one, final int two) {
        return ((array[one].compareTo(array[two])) <= 0);
    }
}
