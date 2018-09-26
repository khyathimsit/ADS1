/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * { item_description }
 */
import java.util.Arrays;
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
        int size = sc.nextInt();
        int[] array = new int[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int sum = 0;
        //int count = 0;
        int prev = array[0];
        for (int i = 1; i < size; i++) {
        	if (prev == array[i]) {
        		count++;
        	} else {
                count++;
        		sum += (count * (count - 1)) / 2;
                count = 0;
            }
            prev = array[i];
        }
        count++;
        sum += (count * (count - 1)) / 2;
        System.out.println(sum);
    }
}


