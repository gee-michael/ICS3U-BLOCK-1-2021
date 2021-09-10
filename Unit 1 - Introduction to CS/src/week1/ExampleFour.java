package week1;

/**
 * Variables! It stores information as data
 * Primitive data types : (int / double / char / boolean)
 * Assignment operator '=' assigns value to variable NOT equal sign
 */

public class ExampleFour {
    public static void main(String[] args) {
        int markOne = 75; //declares integer variable called markOne that stores value 75
        int markTwo = 80;
        int markThree = 87;
        int avg; //declared variable, no value
        avg = (markOne + markTwo + markThree) / 3;
        System.out.println(avg);
        System.out.println("The average of the marks is " + avg); //"+" joins variables and strings
    }
}
