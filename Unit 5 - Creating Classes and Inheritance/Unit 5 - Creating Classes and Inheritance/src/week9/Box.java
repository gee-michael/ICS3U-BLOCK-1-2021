package week9;

public class Box extends Rectangle { // inheriting everything fromn Rectangle into Box
    /*
    public Box(){ // if you do not write an explicit constructor, then java supplies this for you.
        super(); // it does nothing but call you parents' explicit constructor
    }   // super is the parent's class (Rectangle)
    */

    private double height;
    public Box(double l, double w, double h){
        // length = l; child classes don't have access to PRIVATE parent attributes
        // width = w;
        super(l, w); // if you are going to call your parent's constructors, it MUST be first
        height = h;
        // super(l, w); this causes an error since it is not first.
    }



    public Box(double side){
        super(side);
        height = side;
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj instanceof Box) {
            Box r = (Box) obj;
            return this.getLength() == r.getLength() && this.getWidth() == r.getWidth() && this.height == r.height;
        } 
        return false;
    }

    public double getArea() { // since getLength is only in parent's it will default to that
        return 2 * super.getArea() + 2 * getLength() * height + 2 * getWidth() * height;
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    public double getPerimeter() {
        return 3 * (getLength() + getWidth() + height);
    }

    public String toString() {
        return "A " + getLength() + " x " + getWidth() + " x " + height + " Box";
    }
}
