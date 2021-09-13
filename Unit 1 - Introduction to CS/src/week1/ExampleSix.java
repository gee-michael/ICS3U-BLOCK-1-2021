package week1;

/** FINAL MODIFIER
 * used to make a variable constant (cannot be changed)
 */

public class ExampleSix {
    public static void main(String[] args) {
        final int x = 7;
        // x = 8; - syntax error because we cannot reassign a value >
        // > to a variable that has beed modified with final

        final int y;
        y = x; // no issue ! since it is the first time y is assigned

        final int NUMBER_OF_STUDENTS = 30; // constants usually are named in ALL CAPS + underscore
        System.out.println(NUMBER_OF_STUDENTS + y);
    }
}
