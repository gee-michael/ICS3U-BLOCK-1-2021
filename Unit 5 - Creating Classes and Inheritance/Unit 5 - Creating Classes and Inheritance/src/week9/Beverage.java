package week9;

public class Beverage {
    private static int status = 0; // BELONGS TO CLASS, not INSTANCES. 
    public Beverage(){ // all instances can change and alter, but its not unique
        status = 10;
    }
    public static void setStatus(int s){
        status = s;
    }
}
