package Week6;

public class CompareFor {
    public static void main (String[] args) {
        System.out.println("abc".compareTo("bcde")); // "bcde" > "abc";
        System.out.println("g".compareTo("a")); // -6
        System.out.println("a".compareTo("g")); //  6
        System.out.println("g".compareTo("g")); //  0 
        System.out.println("g".compareTo("G")); // 32 - Capital letters are separated by 32
        System.out.println("go".compareTo("Get")); // "go" > "get" SINCE "o" > "e"
        // A.compareTo(B) -> returns A - B in the alphabet
    }  
}