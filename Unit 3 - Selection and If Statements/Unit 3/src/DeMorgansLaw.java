public class DeMorgansLaw {
    public static void main(String[] args){
        int x = 7;
        Boolean result = x < 3 && x > 10;
        Boolean result2 = !(x < 3 && x > 10);
        Boolean result3 = !(x < 3) || !(x > 10);
        Boolean result4 = (x >= 3) && (x <= 10);

        // !(A && B) == !A || !B

        System.out.println(result); // false
        System.out.println(result2); // true
        System.out.println(result3); // true
        System.out.println(result4); // true
    }
}
