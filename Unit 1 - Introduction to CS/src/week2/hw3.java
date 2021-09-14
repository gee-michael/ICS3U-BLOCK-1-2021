package week2;

public class hw3 {
    public static void main(String[] args) {
        int num = 25349;
        int thouDigit = (num / 10) % 1000 % 100 % 10;
        int tensDigit = (num / 1000) % 10;
        
        System.out.println("The second digit is " + tensDigit + ".");
        System.out.println("The fourth digit is " + thouDigit + ".");
        System.out.println("The product is " + thouDigit * tensDigit + ".");
    }
}
