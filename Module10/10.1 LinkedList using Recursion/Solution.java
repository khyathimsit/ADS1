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
    // time complexity for this method:O(N)
    public static void main(final String[] args) {
        LinkedListRecursion list = new LinkedListRecursion();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "insertAt":
                    if (Integer.parseInt(tokens[1]) < 0 || Integer.parseInt(
                        tokens[1]) > list.size() + 1) {
                        System.out.println(
                            "Can't insert at this position.");
                    } else {
                        list.insertAt(Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]));
                        System.out.println(list.toString());
                    }
                break;
                // case"pushLeft":
             //        list.insertFront(Integer.parseInt(tokens[1]));
             //        System.out.println(list.toString());
             //    break;

                case "reverse":
                    if (!list.isEmpty()) {
                        list.reverse();
                        System.out.println(list.toString());
                    } else {
                        System.out.println("No elements to reverse.");
                    }
                break;

                default:
                break;
            }
        }
    }
}
