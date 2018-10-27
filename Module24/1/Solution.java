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
    
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<Integer, Student> 
                    sc = new SeparateChainingHashST<>();
        Student st = new Student();
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String[] tokens = scan.nextLine().split(",");
            st = new Student(tokens[1], Double.parseDouble(tokens[2]));
            sc.put(Integer.parseInt(tokens[0]), st);
        }
        int querynum = Integer.parseInt(scan.nextLine());
        for (int j = 0; j < querynum; j++) {
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[0].equals("get")) {
                if (Integer.parseInt(tokens[2]) == 1) {
                    if (sc.get(Integer.parseInt(tokens[1])) != null) {
                        System.out.println(sc.get(Integer.parseInt(
                            tokens[1])).getname());
                    } else {
                        System.out.println("Student doesn't exists...");
                    }
                } else {
                    if (sc.get(Integer.parseInt(tokens[1])) != null) {
                        System.out.println(sc.get(
                            Integer.parseInt(tokens[1])).getmarks());
                    } else {
                        System.out.println("Student doesn't exists...");
                    }
                }
            }
        }
    }
}
