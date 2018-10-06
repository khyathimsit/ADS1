/**.
 * { item_description }
 */
import java.util.Comparator;
/**.
 * Class for sorting.
 */
public final class Sorting {
    /**.
     * Constructs the object.
     */
    Sorting() {
      /**.
       * { item_description }
       */
    }
    /**.
     * { function_description }
     *
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     *
     * @return     { description_of_the_return_value }
     */
    //time complexity for this method is O(N)
    public int partition(final Comparable[] array,
      final int low, final int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(array[++i], array[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(array[low], array[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, low, j);
        System.out.println(toString(array));
        return j; 
    }
    /**.
     * Time complexity is O(1)
     */
    /**.
     * { function_description }
     *
     * @param      array   The array
     * @param      low     The low
     * @param      high    The high
     * @param      cutoff  The cutoff
     */
    private void sort(final Comparable[] array, final int low,
      final int high, final int cutoff){
      if (high <= low + cutoff - 1) {
        insertionSort(array, low, high);
        System.out.println("insertionSort called");
        return;
      }
      int j = partition(array, low, high);
      sort(array, low, j - 1, cutoff);
      sort(array, j + 1, high, cutoff);
    }

    /**.
     * Time complexity is O(1)
     */
  /**.
   * { function_description }
   *
   * @param      array   The array
   * @param      cutoff  The cutoff
   */
    public void sort(final Comparable[] array, final int cutoff) {
        sort(array, 0, array.length-1, cutoff);
    }
    /**.
     * Time complexity is O(N^2)
     */
  /**.
   * { function_description }
   *
   * @param      array  The array
   * @param      low    The low
   * @param      high   The high
   */
    public void insertionSort(final Comparable[] array,
      final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(array[j], array[j-1]); j--) {
                swap(array, j, j-1);
            }
        }
    }
    /**.
     * Time complexity is O(1)
     */
   /**.
    * { function_description }
    *
    * @param      array  The array
    * @param      i      { parameter_description }
    * @param      j      { parameter_description }
    */
    public void swap(final Comparable[] array,
      final int i, final int j) {
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
    /**.
     * Time complexity is O(1)
     */
  /**.
   * { function_description }
   *
   * @param      a     { parameter_description }
   * @param      b     { parameter_description }
   *
   * @return     { description_of_the_return_value }
   */
    public boolean less(final Comparable a,
      final Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**.
     * Time complexity is O(N)
     */
  /**.
   * Returns a string representation of the object.
   *
   * @param      a     { parameter_description }
   *
   * @return     String representation of the object.
   */
    public Object toString(final Object[] a) {
        String s = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            s += a[i] + ", ";
        }
        s = s + a[a.length - 1] + "]";
        return s;
    }
}
