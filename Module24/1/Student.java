/**.
 * Class for student.
 */
class Student {
    /**.
     * { var_description }
     */
    private String studentname;
    /**.
     * { var_description }
     */
    private double totalmarks;
    /**.
     * Constructs the object.
     */
    Student() {

    }
    /**.
     * Constructs the object.
     *
     * @param      name   The name
     * @param      marks  The marks
     */
    Student(final String name, final double marks) {
        this.studentname = name;
        this.totalmarks = marks;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(1)
     */
    public String getname() {
        return this.studentname;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(1)
     */
    public double getmarks() {
        return this.totalmarks;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     * Time complexity : O(1)
     */
    public String toString() {
        String str = "";
        str = str + this.studentname + this.totalmarks;
        return str;
    }
}
