package week1;

/** 
 *  type casting - primitives
 */

public class ExampleEight {
    public static void main(String[] args) {
        final int NUM_MARKS = 5;
        int markOne = 84, markTwo = 78, markThree = 87, markFour = 97, markFive = 63;

        //cast the int NUM_MARKS as a double for this calculation
        double average = (markOne + markTwo + markThree + markFour + markFive) / (double)NUM_MARKS;
        
        double z = 4.5;
        int y = (int) z; // chops the decimal off! 4.5 >> 4

        // narrow conversion : double >> int 
        // widen conversion : int >> double 

        System.out.println("The average is: " + average + y); //81.8
    }
}
