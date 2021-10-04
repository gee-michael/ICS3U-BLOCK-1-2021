package week5;

import java.util.Scanner;

public class UsingScanner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        exampleOne(in); // asks for your name
        exampleTwo(in); // asks for an int (BAD)
        exampleThree(in); // asks for an int (GOOD)
        in.close();
    }

    private static void exampleOne(Scanner in) {
        System.out.print("Please enter your name: ");
        String name = in.nextLine();
        System.out.println("Hello, " + name + "!");
        in.close();
    }

    // Uses nextInt - crashes when not given an int
    private static void exampleTwo(Scanner in) {
        System.out.print("Please enter an integer: ");
        int num = in.nextInt();
        System.out.println(Math.pow(num, 2));
    }

    private static void exampleThree(Scanner in) {
        System.out.print("Please enter an integer: ");
        int num = 0;
        Boolean validInput = false;

        while(!validInput){
            try{
                num = Integer.parseInt(in.nextLine());
                validInput = true;
            }catch(Exception ex){  
                System.out.print("Invalid input, put in an integer.");
            }
        }
        
        System.out.println(Math.pow(num, 2));
    }
}