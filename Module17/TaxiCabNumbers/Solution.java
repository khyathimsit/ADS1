/**.
 * { item_description }
 */
import java.util.*;
/**.
 * Class for taxicab.
 */
class Taxicab implements Comparable<Taxicab> {
    /**.
     * { item_description }
     */
    int i,j;
    /**.
     * { var_description }
     */
    long sum;
    /**.
     * Constructs the object.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public Taxicab(int i, int j) {
        this.sum = (long) i*i*i + (long) j*j*j;
        this.i = i;
        this.j = j;
    }
    /**.
     * { function_description }
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(Taxicab that) {
        if (this.sum < that.sum) {
            return -1;
        } else if (this.sum > that.sum) {
            return +1;
        }
        else {
            return  0;
        }
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return i + "^3 + " + j + "^3";
    }

}
/**.
 * Class for solution.
 */
class Solution {
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] input = sc.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int n = 1000;
            MinPQ<Taxicab> pq = new MinPQ<Taxicab>();
            for (int i = 1; i <= n; i++) {
                pq.insert(new Taxicab(i, i));
            }
        int pair = 1;
        Taxicab prev = new Taxicab(0, 0);
        int pairCount = 0;
        while (!pq.isEmpty()) {
            Taxicab curr = pq.delMin();
            if (prev.sum == curr.sum) {
                pair++;
                if (pair == M){
                    pairCount = pairCount+1;
                }
                if(pairCount == N){
                    System.out.println(prev.sum);
                    break;
                }
            }
            else {
                pair = 1;
            }
            prev = curr;
            if (curr.j < n){
                pq.insert(new Taxicab(curr.i, curr.j + 1));
            }
        }

    }

}
}
