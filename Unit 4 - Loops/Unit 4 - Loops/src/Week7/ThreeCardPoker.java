package Week7;

import java.util.Scanner; // STATIC MEANS ONLY USED IN CLASS!!

public class ThreeCardPoker {

    private static final String hearts = "H";
    private static final String clubs = "C";
    private static final String diamonds = "D";
    private static final String spades = "S";

    private static final String ace = "A";
    private static final String king = "K";
    private static final String queen = "Q";
    private static final String jack = "J";
    private static final int maxCards = 3;

    public static void main(String[] args) { // sample player = "7H AD KC" -> 7 hearts, ace diamonds, king clubs
        Scanner in = new Scanner(System.in);
        int wallet = 500;
        final int min = 50;
        final int max = 100;
        //int bet = getBet(in, wallet, min, max);
        String player = "";
        for (int i = 0; i < maxCards; i++){
            player += addCard(player) + " ";
        }
        System.out.println(player);
        player = discard(in, player);
        in.close();
    }

    private static String discard(Scanner in, String player) {
        boolean valid = false;
        int disCards = getNum(in, "Please enter the number of cards you wish to discard.", 0, 3);
        // prompt them the cards to replace 
        return "";
    }

    private static int getNum(Scanner in, String prompt, int min, int max) {
        // ask the user how many cards they want to replace
        // make sure it is between 0 and 3
        return 0;
    }

    private static String addCard(String used) {
        String card = getFace() + getSuit();
        while (used.indexOf(card) >= 0){
            card = getFace() + getSuit();
        }
        return card;
    }

    private static String getSuit() {
        int suit = (int) (Math.random() * 4);
        if (suit == 0){
            return hearts;
        } else if (suit == 1){
            return clubs;
        } else if (suit == 2){
            return diamonds;
        } else {
            return spades;
        }
    }

    private static String getFace() {
        int face = (int) (Math.random() * 12) + 1;
        if (face == 1){
            return ace;
        } else if (face == 11){
            return jack;
        } else if (face == 12){
            return queen;
        } else if (face == 13){
            return king;
        } else {
            return "" + face;
        }
    }

    private static int getBet(Scanner in, int wallet, int min, int max) {
        boolean valid = false;
        int bet = 0;
        while (!valid) {
            if (max < wallet) {
                System.out.println("Please enter a wager. The wager must be between $" + min + ", and $" + max);
            } else {
                System.out.println("Please enter a wager. The wager must be between $" + min + ", and $" + wallet);
            }

            try {
                bet = Integer.parseInt(in.nextLine());
                if (bet > wallet) {
                    System.out.println("\nError 401: Not enough funds. Your wallet only contains $" + wallet + ".");
                } else if (bet > max || bet < min) {
                    System.out.println("\nError 402: Bet range overflow. Please enter a value between $" + min + " and $" + max + ".");
                } else {
                    valid = true;
                }
            } catch (Exception ex) {
                System.out.println("\nError 403: Invalid bet. Please enter a valid number.");
            }
        }
        return bet;
    }
}