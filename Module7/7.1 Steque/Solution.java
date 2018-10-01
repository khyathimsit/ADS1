/**.
 * { item_description }
 */
import java.util.Scanner;
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        /**.
         * Empty constructor
         */
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Steque steque = new Steque();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                    case "push":
                        steque.push(Integer.parseInt(tokens[1]));
                        System.out.println(steque.display());
                    break;

                    case "pop":
                        steque.pop();
                        if (steque.isEmpty()) {
                            System.out.println("Steque is empty.");
                        } else {
                            System.out.println(steque.display());
                        }
                    break;

                    case "enqueue":
                        steque.enqueue(Integer.parseInt(tokens[1]));
                        System.out.println(steque.display());
                    break;

                    default:
                    break;
                }
                if (tokens[0].equals("")) {
                    System.out.println();
                    break;
                }
            }
        }
    } 
}
