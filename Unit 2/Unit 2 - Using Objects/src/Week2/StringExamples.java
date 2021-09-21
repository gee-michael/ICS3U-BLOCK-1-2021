package Week2;

public class StringExamples {
    public static void main(String[] args){

        // defined 3 references to string objects
        // when we use a string literal we are NOT constructing an instance of an object
        String stringLiteral = "This is a string literal.";
        String anotherLiteral = "This is a string literal.";

        // the following strings are separate instances of string OBJECTS
        String somethingDifferent = new String("This is a string literal."); // no it isn't
        // String somethingDifferent2 = new String("This is a string literal.");
        // String somethingDifferent3 = new String("This is a string literal.");

        System.out.println(stringLiteral.length()); // length of string -- 25
        System.out.println(anotherLiteral.equals(somethingDifferent)); // 'stringliteral' is the THIS -- false

        System.out.println(stringLiteral.indexOf("in")); // index # 13
        System.out.println(stringLiteral.indexOf("happy")); // index # -1

        System.out.println(stringLiteral.substring(3)); // starts at index 3
        System.out.println(stringLiteral.substring(3, 6)); // starts at index 3 goes to UP TO NOT INCLUDING 6
    }
}
