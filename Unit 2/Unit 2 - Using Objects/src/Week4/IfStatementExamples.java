package Week4;

public class IfStatementExamples {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo(70);
        exampleThree();
    }

    private static void exampleOne() {
        /**
         *  if (boolean expression == true) {
         *      // do this
         *  }
         */ 
    
         int x = 7;

         if (x % 2 == 0) {
             System.out.println("x is even");
         } else {
             System.out.println("x is odd");
         } 
    }

    private static void exampleTwo(int mark) {
        System.out.print(mark + " gives you ");

        if (mark >= 80 || mark < 50){
            System.out.print("an ");
        } else {
            System.out.print("a ");
        }

        if (mark >= 90) {
            System.out.println("A+");
        } else if (mark >= 80) {
            System.out.println("A");
        } else if (mark >= 70) {
            System.out.println("B");
        } else if (mark >= 60) {
            System.out.println("C");
        } else if (mark >= 50) {
            System.out.println("D");
        } else {
            System.out.println("F");
        } 
    }

    private static void exampleThree() {
        //  OR -> ||    if(x > 7 || x < 6) {
        // AND -> &&    if(x > 7 && x > 6) {
        // also > < >= <= == (<- don't use with strings)
        // NOT -> !=    if(x != 6) OR !(x < 7)
        // wait this is not an example?
    }
}

