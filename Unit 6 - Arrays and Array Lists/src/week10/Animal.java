package week10;

public class Animal {
    public static void main(String[] args){
        accessArray();
        iterateAnArray();
    }

    private static void accessArray() {
        int[] arr = { 5, 3, 2, 5, 2 };
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }

    private static void iterateAnArray() {
        int[] arr = new int[5];
        Animal[] animals = new Animal[3];
    }
}
