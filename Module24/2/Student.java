/**
 * Class for student details.
 */
class Student implements Comparable<Student> {
    /**
     * { variable for student name }.
     */
    protected String name;
    /**
     * { variable for student marks }.
     */
    protected double marks;
    /**
     * { variable for student rollnumber }.
     */
    protected int rollnumber;
    /**.
     * Constructs the object.
     */
    Student() {

    }
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     * @param      m     { parameter_description }
     * @param      o     { parameter_description }
     */
    Student(final String n, final String m, final String o) {
        this.name  = n;
        this.marks = Double.parseDouble(m);
        this.rollnumber = Integer.parseInt(o);
    }
    /**
     * { CompareTo function }.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Student that) {
        if (this.marks > that.marks) {
            return 1;
        }
        if (this.marks < that.marks) {
            return -1;
        }
        if (this.rollnumber > that.rollnumber) {
            return 1;
        }
        if (this.rollnumber < that.rollnumber) {
            return -1;
        }
        if (this.name.compareTo(that.name) > 0) {
            return 1;
        }
        if (this.name.compareTo(that.name) < 0) {
            return -1;
        }
        return 0;
    }
}
