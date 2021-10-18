package Week7;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Boolean playAgain = true;
        while (playAgain){
            play("READY TO USE SURFACE CLEANER", in);
            playAgain = playAgain(in);
        }
        in.close();
    }

    private static Boolean playAgain(Scanner in) {
        Boolean valid = false;
        while (!valid){
            System.out.println("Do you want to play again? [Y] / [N]");
            String answer = in.nextLine().toUpperCase();
            if (answer.equals("YES") || answer.equals("Y")){
                return true;
            } else if(answer.equals("NO") || answer.equals("N")){
                System.out.println("Okay. fine.");
                return false;
            } else {
                System.out.println("What the heck. just type a letter. how did you mess that up");
            }
        }
        return false;
    }

    private static void play(String hint, Scanner in) {
        String used = "";
        int numPieces = 0;
        Boolean gameOver = false;
        String letters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
        while (!gameOver){
            String encrypt = encryptHint(hint, used);
            System.out.println(encrypt);
            String letter = getLetter(in, letters);
            used += letter;
            letters = letters.replace(letter, "_");
            if (hint.indexOf(letter) < 0){
                numPieces++;
            }
            if (numPieces > 0){
                drawHangman(numPieces);
            }
            if (numPieces == 7){
                System.out.println("You LOSE!!!!");
                gameOver = true;
            } else if (encryptHint(hint, used).indexOf("_") < 0){
                System.out.println("You WIN!!!!");
                gameOver = true;
            }
        }
    }

    private static String getLetter(Scanner in, String letters) {
        System.out.println("Available Letters: \n" + letters);
        Boolean valid = false;
        String letter = "";
        while (!valid){
            System.out.println("Please choose a letter.");
            letter = in.nextLine().toUpperCase(); // converts lower case to UPPER CASE    
            if (letters.indexOf(letter) >= 0 && letter.length() == 1){
                valid = true;
            } else {
                System.out.println("Error 403 // Invalid input \n Please enter a valid input from the available letters");
                System.out.println("Available Letters: \n" + letters);
            }   
        }
        return letter;
    }

    private static String encryptHint(String hint, String used) {
        String result = "";
        for (int i = 0; i < hint.length(); i++){
            String s = hint.substring(i, i + 1);
            if (s.equals(" ")){
                result += "/ ";
            } else if (used.indexOf(s) >= 0){
                result += s + " ";
            } else {
                result += "_ ";
            }
        }
        return result;
    }

    private static void drawHangman(int numPieces){
        System.out.println("Hangman: ");
        if (numPieces == 7){
            System.out.println("  ___");
            System.out.println(" |   |");
            System.out.println(" |   O");
            System.out.println(" |  /|\\");
            System.out.println(" |   |");
            System.out.println(" |  / \\");
            System.out.println("_|___");
        } else if (numPieces == 6){
            System.out.println("  ___");
            System.out.println(" |   |");
            System.out.println(" |   O");
            System.out.println(" |  /|\\");
            System.out.println(" |   |");
            System.out.println(" |  /");
            System.out.println("_|___");
        } else if (numPieces == 5){
            System.out.println("  ___");
            System.out.println(" |   |");
            System.out.println(" |   O");
            System.out.println(" |  /|\\");
            System.out.println(" |   |");
            System.out.println(" |");
            System.out.println("_|___");
        } else if (numPieces == 4){
            System.out.println("  ___");
            System.out.println(" |   |");
            System.out.println(" |   O");
            System.out.println(" |  /|\\");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println("_|___");
        } else if (numPieces == 3){
            System.out.println("  ___");
            System.out.println(" |   |");
            System.out.println(" |   O");
            System.out.println(" |  /|");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println("_|___");
        } else if (numPieces == 2){
            System.out.println("  ___");
            System.out.println(" |   |");
            System.out.println(" |   O");
            System.out.println(" |   |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println("_|___");
        } else if (numPieces == 1){
            System.out.println("  ___");
            System.out.println(" |   |");
            System.out.println(" |   O");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println("_|___");
        }
    }

/**   O
 *   /|\
 *    | 
 *   / \
 */ 
}
