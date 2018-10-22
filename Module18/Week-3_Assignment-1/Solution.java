/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
    /**.
     * { var_description }
     */
    private String name;
    /**.
     * { var_description }
     */
    private float change;
    /**.
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     * @param      c     { parameter_description }
     */
    Stock(final String n, final float c) {
        this.name = n;
        this.change = change;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getname() {
        return this.name;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public float getchange() {
        return this.change;
    }
    /**.
     * { function_description }
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Stock other) {
        if (this.change > other.change) {
            return 1;
        }
        if (this.change < other.change) {
            return -1;
        }
        if (this.name.compareTo(other.name) > 0) {
            return 1;
        }
        if (this.name.compareTo(other.name) < 0) {
            return -1;
        }
        return 0;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        str = str + this.name + " " + this.change;
        return str;
    }
}
/**.
 * { item_description }
 */
final class Solution {
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
        BinarySearchST<String, Integer> maxST = new  BinarySearchST<>();
        BinarySearchST<String, Integer> minST = new BinarySearchST<>();
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < 2 + 2 + 2; i++) {
            int count = 0;
            MinPQ<Stock> minpq = new MinPQ<>();
            MaxPQ<Stock> maxpq = new MaxPQ<>();
            while (count < num) {
                String[] details = scan.nextLine().split(",");
                Stock stock = new Stock(details[0],
                    Float.parseFloat(details[1]));
                minpq.insert(stock);
                maxpq.insert(stock);
                //count++;
            }
            for (int j = 0; j < 2 + 2 + 1; j++) {
                Stock max = maxpq.delMax();
                if (maxST.contains(max.getname())) {
                    int value = maxST.get(max.getname());
                    maxST.put(max.getname(), ++value);
                } else {
                    maxST.put(max.getname(), 1);
                }
                System.out.println(max.getname() + " " +max.getchange());
            }
            System.out.println();
            for (int k = 0; k < 2 + 2 + 1; k++) {
                Stock min = minpq.delMin();
                if (minST.contains(min.getname())) {
                    int valuemin = minST.get(min.getname());
                    minST.put(min.getname(), ++valuemin);
                } else {
                    minST.put(min.getname(), 1);
                }
                System.out.println(min.getname() + " " + min.getchange());
            }
            System.out.println();
            count++;
        }
        int n1 = Integer.parseInt(scan.nextLine());
        while (n1 > 0) {
            String[] tokens = scan.nextLine().split(",");
            switch(tokens[0]) {
                case "get":
                    if (tokens[1].equals("maxST")) {
                        if (maxST.contains(tokens[2])) {
                            System.out.println(maxST.get(tokens[2]));
                        } else {
                            System.out.println("0");
                        }
                    } else {
                       if (minST.contains(tokens[2])) {
                            System.out.println(minST.get(tokens[2]));
                        } else {
                            System.out.println("0");
                        } 
                    }
                break;
            }
        }
    }
}
