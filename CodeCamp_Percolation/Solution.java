import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        Percolation obj = new Percolation(input);
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(" ");
            obj.open(Integer.parseInt(tokens[0]) - 1,
                Integer.parseInt(tokens[1]) - 1);
        }
        System.out.println(obj.ispercolate());
    }
}
