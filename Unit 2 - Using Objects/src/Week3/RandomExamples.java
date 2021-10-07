package Week3;

public class RandomExamples {
    public static void main(String[] args) {
        double r = Math.random(); // random # between 0.0, 1.0 (not including 1.0 though)
        System.out.println(r); // example : 0.314159265358979323846264338... (< pi) (v tau)
                               // or also : 0.6283185307179586476925286766559005768394338750211...
    
        int lower = -5; // upper - lower + 1 -> how many numbers in total
        int upper = 5;
        
        int num = (int) ((upper - lower + 1) * r) + lower;
        System.out.println(num);

        String str = "Random Numbers"; // change random character in string to 1
        int index = (int) (Math.random() * str.length());
        str = str.substring(0, index) + "x" + str.substring(index + 1);
        System.out.println(str); // eg. 'xandom Numbers'
    }        
}
