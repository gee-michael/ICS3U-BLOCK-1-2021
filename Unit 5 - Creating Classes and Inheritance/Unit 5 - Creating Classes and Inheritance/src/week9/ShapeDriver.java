package week9;

public class ShapeDriver {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5.0, 3.0);
        Rectangle r2 = new Rectangle(4.0);
        
        System.out.println("Perimeter of r1: " + r1.getPerimeter());
        System.out.println("Area or r2: " + r2.getPerimeter());

        if (r1.equals(r2)){
            System.out.println("r1 and r2 are equal.");
        } else {
            System.out.println("r1 and r2 are not equal.");
        }

        System.out.println(r1.toString());
        System.out.println(r2.toString());

        Box b1 = new Box(5.0, 6.0, 2.0);
        Box b2 = new Box(7.0);


        System.out.println("Surface Area of b1: " + b1.getArea());
        System.out.println("Volume or r2: " + b2.getVolume());

        if (b1.equals(b2)){
            System.out.println("b1 and b2 are equal.");
        } else {
            System.out.println("b1 and b2 are not equal.");
        }

        System.out.println(b1.toString());
        System.out.println(b2.toString());      
    } 
}
