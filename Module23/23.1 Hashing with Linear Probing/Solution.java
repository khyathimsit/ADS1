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
        HashTableLP lp = new HashTableLP();
        int n = sc.nextInt();
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] tokens = input.split(",");
            switch (tokens[0]) {
                case "put":
                    lp.put(tokens[1], Integer.parseInt(tokens[2]));
                break;
                case "get":
                   lp.get(tokens[1]);
                break;
                case "delete":
                    lp.delete(tokens[1]);
                break;
                case "display":
                    lp.display();
                default:
                break;
            }
        }
    }
}
