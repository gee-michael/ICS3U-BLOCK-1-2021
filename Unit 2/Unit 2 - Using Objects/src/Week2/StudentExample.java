package Week2;
public class StudentExample {
    public static void main (String[] args) {       
        Student shohei;
        shohei = new Student("Shohei", "123456", 11); 
        // shohei is a student (object variable, not primitive)

        Student samantha = new Student("Samantha", "654321", 11);
        // primitive variables store the value
        // 'new Student' assigns a value, 'student []' creates a reference to the values given
        // strings are NOT primitive, they are objects

        Student alan = shohei; // alan is now at shohei's reference. (address)
        alan.increaseGrade(); // called the increaseGrade() funtion
        // since alan and shohei reference the same object, BOTH move up

        // we activate methods (functions) through the variable name ( [name].[function](); )

        samantha.displayName();
        // samantha.displayStudentNumber();
        // samantha.increaseGrade();

        samantha = null; // everything stored in samantha is now gone !

        // samantha.displayGrade(); NULL POINTER EXCEPTION since 'samantha' points to null
        // NON-Static means it belongs to the object (each object gets a copy)

        alan = new Student("Alan", "55555", 11);

        alan.addTest(87);
        alan.displayAverage();
        alan.addTest(92);
        alan.displayAverage();
        alan.addTest(96);
        alan.displayAverage();
        alan.addTest(67);
        alan.displayAverage();
        double avg = alan.getAverage();
        System.out.println(alan.getName() + "'s average is " + avg + ".");

        // alan.numMarks = 7; don't have access to PRIVATE members

        alan.displayName();
        alan.displayName("Hello");

        Student stefano = new Student("Stefano", "876273");
        stefano.displayName();
        stefano.displayGrade();

    }    
}