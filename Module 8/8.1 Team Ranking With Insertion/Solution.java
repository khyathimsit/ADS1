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
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        SelectionSort sort = new SelectionSort();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Team team = new Team(tokens[0], Integer.parseInt(tokens[1]),
             Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
            sort.add(team);
        }
        sort.selection();
        System.out.println(sort.toString());
    }
}
