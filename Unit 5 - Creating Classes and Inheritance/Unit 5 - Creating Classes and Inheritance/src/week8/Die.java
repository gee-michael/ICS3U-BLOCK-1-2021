package week8; // [private] means only accessible inside the class. 
// Other classes cannot access private attributes, methods, constructors directly
public class Die { 
    private int topSide;
    private int numSides;

    public Die() { // this is a NO ARGUMENT CONSTRUCTOR
        this.numSides = 6;
    }
    // [this] refers to THIS instance of object you are working on
    public Die(int numSides) { // if we have // Die die1 = new Die(); // die1.roll();
        this.numSides = numSides; // [this] would be die1
        roll();
    }
    
    public void roll() {
        topSide = (int) (Math.random() * numSides + 1);
    }

    public int getTopSides() {
        return topSide;
    }

    public String toString(){
        return "" + topSide;
    }

    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (obj instanceof Die){
            return this.topSide == ((Die)obj).topSide;
        } else {
            return false;
        }
    }
}