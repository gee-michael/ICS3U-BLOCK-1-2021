package week1;

/**
 * Compound Assignment Operators 
 */

public class ExampleSeven {
    public static void main(String[] args) {
        int x = 1;

        x += 7; // 8
        x -= 3; // 5
        x *= 2; // 10
        x /= 3; // 3
        x %= 4; // 3
        x++; // 4
        ++x; // 5
        x--; // 4
        --x; // 3

        System.out.println(x); // 3

        int y = 2 * x++; // also changes    - x is 3, y is 6, then x is now 4 (after)
        int z = 2 * ++x; // the value of x. - x is now 5, z is 10.
        
        System.out.println(x); // 5
        System.out.println(y); // 6
        System.out.println(z); // 10
    }
} 
