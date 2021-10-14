package Week4;

import java.util.Scanner;

public class Hangman {

    static final int MAX_WRONG = 7;

    public static void main(String[] args) {
		playHangMan();
	}

    private static void playHangMan() {
		String answer = "BVG VOLLEYBALL WINS SILVER";
		int numWrong = 0;
		String userAnswer = convertToUser(answer);
		
		System.out.println(userAnswer);
		
		Scanner in = new Scanner(System.in);
		boolean isGameOver = false;
		
		while(!isGameOver) {
			String userChoice = getUserChoice(in);
			if (isCorrect(userChoice, answer)) {
				userAnswer = convertToUser(answer, userChoice, userAnswer);
				System.out.println(userAnswer);
				if (userAnswer.equals(answer)) {
					System.out.println("WINNER WINNER CHICKEN DINNER!!!");
					isGameOver = true;
				}
			}else {
				numWrong++;
				displayHangman(numWrong);
				if (numWrong == MAX_WRONG) {
					isGameOver = true;
					System.out.println("LOSER!!!!!");
				}
			}
			
			
		}	
	}

    private static String convertToUser(String answer, String userChoice, String userAnswer) {
		String result = "";
		for (int i=0; i<answer.length(); i++) {
			if (answer.substring(i,i+1).equals(userChoice)) {
				result += userChoice;
			}else {
				result += userAnswer.substring(i, i+1);
			}
		}
		
		return result;
	}

    private static boolean isCorrect(String userChoice, String answer) {
		return answer.indexOf(userChoice) >= 0;
	}

    private static String getUserChoice(Scanner in) {
		System.out.print("Please enter your choice: " );
		return in.nextLine();
	}

    private static void displayHangman(int numWrong) {
		String person = "";
		
		if (numWrong >= 1) {
			person += "  O\n";
		}
		
		if (numWrong >= 2) {
			person += "  |\n";
		}
		
		if (numWrong >= 3) {
			person += "--|";
		}
		
		if (numWrong >= 4) {
			person += "--\n";
		}
		
		if (numWrong >= 5) {
			person += "  |\n";
		}
		
		if (numWrong >= 6) {
			person += " /";
		}
		
		if (numWrong >= 7) {
			person += " \\";
		}
		
		System.out.println(person);
		
	}

    private static String convertToUser(String answer) {
		String result = "";
		
		for (int i=0; i<answer.length(); i++) {
			if (answer.substring(i, i+1).equals(" ")) {
				result += " ";
			}else {
				result +="*";
			}
		}
		
		return result;
		
	}
}
