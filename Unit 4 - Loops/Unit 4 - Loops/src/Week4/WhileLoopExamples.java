package Week4;

import java.util.Scanner;

public class WhileLoopExamples {
   public static void main(String[] args) {
      exampleOne();
      int sum = getSumInclusive(1, 9);
      System.out.println(sum);
      int numVowels = countVowels("This is a sentence with VOWELS!");
      System.out.println(numVowels);

      Scanner in = new Scanner(System.in);
      int num = getValidInput(10, 20);

   }

   private static int getValidInput(int i, int j) {
      return 0;
   }

   private static int getSumInclusive(int i, int j) {
      return 0;
   }

   private static int countVowels(String string) {
      return 0;
   }

   private static void exampleOne() {
      // sum the numbers from 1 - 100 and display on screen
      int count = 1;
      int num = 0;

      while(count <= 100){
         System.out.print(num + "");
         count++;
      }
   }
}