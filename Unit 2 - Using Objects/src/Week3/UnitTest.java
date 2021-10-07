package Week3;

public class UnitTest {
    public static void main(String[] args) {
        System.out.println(twoChar("java", 1));
        System.out.println(twoChar("happy", 2));
        System.out.println(twoChar("computer science", 4));
        System.out.println(removeChars("computerscience", 7, 3));
        System.out.println(sqrtSum(9999));
    }

    public static String twoChar(String str, int index) {
        String a = str.substring(index, index + 2); 
        return a + a + a;
    }

    public static String removeChars(String str, int index, int n) {
        String a = str.substring(0, index);
        String b = str.substring(index + n + 1);
        return a + b;
    }

    public static double sqrtSum(int number) {
        int n1 = number / 1000;
        int n2 = number / 100 % 10;
        int n3 = number / 10 % 10;
        int n4 = number % 10;
        return Math.sqrt(n1 + n2 + n3 + n4);
    }
}