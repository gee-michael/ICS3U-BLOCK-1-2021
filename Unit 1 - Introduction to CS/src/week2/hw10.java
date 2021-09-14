package week2;

public class hw10 {
    public static void main(String[] args) {
        double a = 1.0, b = 2.0, c = 3.0;
        double xPos = ((b * -1) + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        double xNeg = ((b * -1) - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        System.out.println("The answer is " + xPos + " and " + xNeg + ".");  // prints NaN and NaN. WHY   
    }
}

/**     -b ± √b² - 4ac
 *  x = --------------
 *            2a
 */           

