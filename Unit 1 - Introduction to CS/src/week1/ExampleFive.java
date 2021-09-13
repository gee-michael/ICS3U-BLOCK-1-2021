package week1;

/** INTEGER TYPES
 *  int, double
 */

public class ExampleFive {
    public static void main(String[] args) {
        int x = 80, y, z;   // declared 3 variables, x = 80
        y = 75;
        z = 87;
        double avg = (x + y + z) / 3; // is divided by integer -> output 80.0
        System.out.println(avg);
        avg = (x + y + z) / 3.0;  // is divided by double -> output 80.66667
        System.out.print(avg);
    }
}
