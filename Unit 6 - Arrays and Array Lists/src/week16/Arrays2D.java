package week16;

public class Arrays2D {
    public static void main(String[] args){
        int[][] arr2d = new int[4][3];
        int counter = 1;

        for (int r = 0; r < arr2d.length; r++){
            for (int c = 0; c < arr2d[r].length; c++){
                arr2d[r][c] = counter++;
            }
        }

        for (int r = 0; r < arr2d.length; r++){
            for (int c = 0; c < arr2d[r].length; c++){
                System.out.print(arr2d[r][c] + " ");
            }
            System.out.println();
        }
    }
}