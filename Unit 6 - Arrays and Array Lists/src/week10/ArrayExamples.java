package week10;

public class ArrayExamples {
    public static void main (String[] args){
        /* int[] arr = new int[5]; == A new array of ints called 'arr' is created of size 5.
        arr [] <- square brackets mean arrays
            |_\  0   1   2   3   4  < index
              / [0] [0] [0] [0] [0] < primitives created as '0' (ints) or "" (strings) or '0.0' (doubles) or ...

        Animal[] animals = new Animal[3];
        animals [] ->  [null] [null] [null] < non-primitives created as NULL
                         0      1      2    < index */

        int[] arr = new int[5];
        Animal[] animals = new Animal[3];
        System.out.println(arr.length); // 5 - [0] [0] [0] [0] [0]
        System.out.println(animals.length); // 3 - [null] [null] [null]

        arr[0] = 3;
        arr[1] = 7;
        arr[2] = 10;
        arr[3] = 12;
        arr[4] = -2;

        animals[0] = new Animal();
        animals[1] = new Animal();
        animals[2] = new Animal();

        System.out.println(arr.length); // 5 - [3] [7] [10] [12] [-2]
        System.out.println(animals.length); // 3 - [Animal] [Animal] [Animal] <- references, not objects
    }
}