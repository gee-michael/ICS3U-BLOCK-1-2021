package Week3;

public class WrapperClassExamples {
    public static void main(String[] args) {
        Integer n = new Integer(7);
        Double d = new Double(3.2);

        Integer num = 7;  // works. num -> 7
        int m = num;      // works. m -> num -> 7;
        
        int x = 6 + num; // works. x -> (num -> 7) + 6 -> 13
        int y = m + num; // auto-unboxing so we can add a primitive AND object wrapper together

        int z = num.intValue(); // same thing as z = num...
        double f = d.doubleValue(); // same thing as f = d...

        System.out.println(Integer.MAX_VALUE); // prints biggest integer
        System.out.println(Integer.MIN_VALUE); // prints smallest integer      
        System.out.println("error fixer " + n + x + y + z + f);
    }    
} 