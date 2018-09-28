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
        Deque d = new Deque();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case"pushLeft":
                    d.addFirst(Integer.parseInt(tokens[1]));
                    System.out.println(d.display());
                break;

                case"pushRight":
                    d.addLast(Integer.parseInt(tokens[1]));
                    System.out.println(d.display());
                break;

                case"popLeft":
                if (!d.isEmpty()) {
                    d.deleteFirst();
                    System.out.println(d.display());
                } else {
                    System.out.println("Deck is empty");
                }
                break;

                case"popRight":
                    if (!d.isEmpty()) {
                        d.deleteLast();
                        System.out.println(d.display());
                    } else {
                    System.out.println("Deck is empty");
                }
                break;
                case"size" :
                    System.out.println(d.size());
                break;
                default:
                break; 
            }
        }
    }
}
