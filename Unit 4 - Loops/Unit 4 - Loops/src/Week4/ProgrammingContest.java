package Week4;

public class ProgrammingContest {
    public static void main(String[] args){
        framingSquares(2, 3, 1, 2);
        diamonds("CANADA");
        wordFrame("CANADA");
    } 

    private static void wordFrame(String str) {
        String next = "";
        for (int i = 0; i < str.length() + 2; i++){
            next = "*" + str + "*";
            System.out.print(next.substring(i, i + 1));
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < str.length(); i++){
            for (int j = str.length(); j > 0; j--){
                System.out.print(str.substring(j - 1, j));
                System.out.print(" ");
                for (int k = 0; k < str.length(); k++){
                    System.out.print("*");
                    System.out.print(" ");
                }
            }
            System.out.println();
        } // idk okay?
    }

    private static void diamonds(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            System.out.print(" ");
        }
        System.out.println(str.substring(0, 1));
        for (int i = 1; i < str.length(); i++) {
            String letter = str.substring(i, i + 1);
            for (int j = 0; j < str.length() - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.print(letter);
            for (int j = 0; j < 2 * i - 1; j++){
                System.out.print(" ");
            }
            System.out.print(letter);
            System.out.println();
        }

        for (int i = str.length() - 2; i >= 1; i--) {
            String letter = str.substring(i, i + 1);
            for (int j = 0; j < str.length() - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.print(letter);
            for (int j = 0; j < 2 * i - 1; j++){
                System.out.print(" ");
            }
            System.out.print(letter);
            System.out.println();
        }

        for (int i = 0; i < str.length() - 1; i++) {
            System.out.print(" ");
        }
        System.out.println(str.substring(0, 1));
    }

    private static void framingSquares(int M, int N, int P, int Q) {
    // M: pic height - N: pic width - P: pic padding - Q: pic frame

        frame(N, P, Q);  
        padding(N, P, Q);  

        for (int i = 0; i < M; i++){
            for (int j = 0; j < Q; j++){
                System.out.print("#");
            }
            for (int j = 0; j < P; j++){
                System.out.print("+");
            }
            for (int j = 0 ; j < N; j++){
                System.out.print(".");
            }
            for (int j = 0; j < P; j++){
                System.out.print("+");
            }
            for (int j = 0; j < Q; j++){
                System.out.print("#");
            }
            System.out.println();
        }
        padding(N, P, Q);  
        frame(N, P, Q);   
        System.out.println();
    }

    private static void padding(int N, int P, int Q) {
        for (int i = 0; i < P; i++){
            for (int j = 0; j < Q; j++){
                System.out.print("#");
            }
            for (int j = 0; j < N + 2 * P; j++){
                System.out.print("+");
            }
            for (int j = 0; j < Q; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    private static void frame(int N, int P, int Q) {
        for (int i = 0; i < Q; i++){
            for (int j = 0; j < N + 2 * P + 2 * Q; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }
}