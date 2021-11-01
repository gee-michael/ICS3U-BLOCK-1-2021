package week9;

public class Rectangle {
    private double length; // length
    private double width; // width

    public Rectangle(double l, double w){
        length = l;
        width = w;
    }

    public Rectangle(double s){
        length = s;
        width = s;
    }

    public double getLength() {
        return length;
    }
    
    public double getWidth(){
        return width;
    }

    public double getArea(){
        return length * width;
    }

    public double getPerimeter(){
        return 2 * (length + width);
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj instanceof Rectangle) {
            Rectangle r = (Rectangle) obj;
            return this.getArea() == r.getArea() && this.getPerimeter() == r.getPerimeter();
        } 
        return false;
    }

    public String toString(){
        return "A " + length + " x " + width + " Rectangle";
    }
}
