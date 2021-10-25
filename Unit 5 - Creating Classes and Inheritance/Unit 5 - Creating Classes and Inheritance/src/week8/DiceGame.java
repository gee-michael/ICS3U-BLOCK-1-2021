package week8;

public class DiceGame {
    public static void main(String[] args) {
        Die die1 = new Die();
        Die die2 = new Die();
        for (int i = 0; i < 1000; i++) {
            int numPairs = 0;
            for (int j = 0; j < 100; j++) {
                die1.roll();
                die2.roll();
                // System.out.println(die1.getTopSides() + " " + die2.getTopSides());
                if (die1.equals(die2)) {
                    numPairs++;
                }
            }
            if (numPairs <= 3 || numPairs >= 33){
                System.out.println(numPairs);
            }
        }
    }
}
