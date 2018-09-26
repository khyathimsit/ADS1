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
        int size1 = sc.nextInt();
        int[] arr1 = new int[size];
        int[] arr2 = new int[size1];
        int[] result = new int[size + size1];

        if (size > 0) {
           String line = sc.next();
            String[] tokens = line.split(",");
            for (int n = 0; n < size; n++) {
                arr1[n] = Integer.parseInt(tokens[n]);
            }
        }

        if (size1 > 0) {
            String line1 = sc.next();
            String[] tokens1 = line1.split(",");
            for (int n = 0; n < size1; n++) {
                arr2[n] = Integer.parseInt(tokens1[n]);
            }
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < size && j < size1) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                k++;
                i++;
            } else {
                result[k] = arr2[j];
                k++;
                j++;
            }
        }

        while (i < size) {
            result[k] = arr1[i];
            k++;
            i++;
        }

        while (j < size1) {
            result[k] = arr2[j];
            k++;
            j++;
        }

        for (int n = 0; n < result.length - 1; n++) {
            System.out.print(result[n] + ",");
        }
        System.out.println(result[result.length - 1]);
    }
}

