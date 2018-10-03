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
        Merge m = new Merge();
        Scanner s = new Scanner(System.in);
        final int len = 50;
        String[] tokens = new String[len];
        while (s.hasNextLine()) {
             tokens = s.nextLine().split(",");
             m.sort(tokens);
            System.out.println(m.print(tokens));
            System.out.println();
        }
    }
}
