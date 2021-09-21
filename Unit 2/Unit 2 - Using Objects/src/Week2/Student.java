package Week2;
/**
 * A class is a blueprint for something that we can model and create variables to use in our code.
 * This code (class) defines what a student is.
 */

public class Student {

    /**
     * Attributes that define a student
     * The state of a specific student is what's in the attributes at a specific point
     */

    private String name;
    private String studentNumber;
    private int grade;
    private int totalMarks;
    private int numMarks;
    private double average;

    /**
     * The method with the same name as the class is used to instantiate (create) a student object.
     * 
     * Constructor - same name as the class and its purpose is to instantiate (create) an instance of a class.
     */

    public Student(String name, String studentNumber, int grade) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.grade = grade;
        this.totalMarks = 0;
        this.numMarks = 0;
        this.average = 0;
    }

    public Student(String name, String studentNumber){
        this.name = name;
        this.studentNumber = studentNumber;
        this.grade = 9;
        this.totalMarks = 0;
        this.numMarks = 0;
        this.average = 0;
    }
    

    /**
     * displayName, displayStudentNumber, increaseGrade, displayGrade
     * The methods (actions) in a class define its behaviour
     */

    public void displayName() { 
        System.out.println(name);
    }

    public void displayName(String greeting) {
        System.out.println(greeting);
    }

    public String getName() {
        return name;
    }

    /** ^ Method overloading ^
     *  - methods with the same name but different arguments/parameters 
     */

    /**
     *  A void method performs a task and does NOT return a value.
     *  void -> action (e.g. write to console);
     */

    public void displayStudentNumber() {
        System.out.println(studentNumber);
    }

    public void increaseGrade() {
        grade++;
    }

    public void displayGrade() {
        System.out.println(grade);
    }
    
    public void displayAverage() {
        System.out.println(average);
    }

    public double getAverage() {
        return average;
    }

    public void addTest(int mark){
        totalMarks += mark;
        numMarks++;
        calcAverage();
    }

    public void calcAverage(){
        average = (double) totalMarks / numMarks;
    }
}
