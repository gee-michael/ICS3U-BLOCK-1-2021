package Week5;

public class FactorialExample {
    public static void main(String[] args){
        int result = factorial(7);
        int result2 = fibonacci(5);
        System.out.println(result);
        System.out.println(result2);
    }

    private static int factorial(int n) {
        if (n == 1){
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    private static int fibonacci(int n) {
        if (n == 1 || n == 2){
            return 1;
        } else {
            return (fibonacci(n - 1) + fibonacci(n - 2));
        }
    }
}