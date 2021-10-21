package Week7;

import java.util.Scanner; // STATIC MEANS ONLY USED IN CLASS!!

public class ThreeCardPoker {

    private static final String HEARTS = "H";
    private static final String CLUBS = "C";
    private static final String DIAMONDS = "D";
    private static final String SPADES = "S";

    private static final String ACE = "A";
    private static final String KING = "K";
    private static final String QUEEN = "Q";
    private static final String JACK = "J";
    private static final int MAX_CARDS = 3;

    private static final int TIE = 0;
    private static final int PLAYER_WINS = 1;
    private static final int DEALER_WINS = 2;

    private static final int STRAIGHT_FLUSH = 6;
    private static final int FLUSH = 5;
    private static final int STRAIGHT = 4;
    private static final int TRIPLET = 3;
    private static final int PAIR = 2;
    private static final int HIGH = 1;

    public static void main(String[] args) { // sample player = "7H AD KC" -> 7 hearts, ace diamonds, king clubs
        Scanner in = new Scanner(System.in);
        int wallet = 500;
        final int min = 50;
        final int max = 100;

        boolean playAgain = true;
        while (playAgain) {
            wallet = playHand(wallet, in, min, max);
            if (wallet >= min * 2) {
                playHand(wallet, in, min, max);
                playAgain = playAgain(in);
            } else {
                System.out.println("Error 410: Insufficient funds. You are too poor.");
                playAgain = false;
            }
        }
    }

    private static int playHand(int wallet, Scanner in, int min, int max) {
        int bet = getBet(in, wallet, min, max);
        String player = "";
        String dealer = "";
        for (int i = 0; i < MAX_CARDS; i++) {
            player += addCard(player) + " ";
        }
        for (int i = 0; i < MAX_CARDS; i++) {
            dealer += addCard(dealer) + " ";
        }
        System.out.println("Player: " + player);
        System.out.println("Dealer: XX XX XX");
        if (!fold(in)) {
            bet += getBet(in, wallet, min, max);
            player = discard(in, player);
            System.out.println(player);
        } else {
            System.out.println("Player folds...");
            wallet -= bet;
            return wallet;
        }
        if (compare(player, dealer) == PLAYER_WINS) {
            System.out.println("Player wins!");
            wallet += bet;
        } else if (compare(player, dealer) == DEALER_WINS) {
            System.out.println("Dealer wins.");
            wallet -= bet;
        } else {
            System.out.println("It's a tie...");
        }
        return wallet;
    }

    private static int compare(String player, String dealer) {
        if (getHand(player) > getHand(dealer)) {
            return PLAYER_WINS;
        } else if (getHand(dealer) > getHand(player)) {
            return DEALER_WINS;
        } else {
            if (getHigh(player) > getHigh(dealer)) {
                return PLAYER_WINS;
            } else if (getHigh(dealer) > getHigh(player)) {
                return DEALER_WINS;
            } else {
                return TIE;
            }
        }
    }

    private static int getHigh(String cards) {

        return 0;
    }

    private static int getHand(String cards) {
        if (isFlush(cards) && isStraight(cards)) {
            return STRAIGHT_FLUSH;
        } else if (isFlush(cards)) {
            return FLUSH;
        } else if (isStraight(cards)) {
            return STRAIGHT;
        } else if (isTriplet(cards)) {
            return TRIPLET;
        } else if (isPair(cards)) {
            return PAIR;
        } else {
            return HIGH;
        }
    }

    private static boolean isPair(String cards) { // 2 cards same number
        String card1 = cards.substring(0, cards.indexOf(" "));
        String card2 = cards.substring(cards.indexOf(" ") + 1, cards.substring(cards.indexOf(" ") + 1).indexOf(" "));
        String card3 = cards.substring(cards.substring(cards.indexOf(" ") + 1).indexOf(" ")); 

        System.out.println(card1 + card2 + card3);
        return false;

    }

    private static boolean isTriplet(String cards) { // 3 cards same number
        return false;
    }

    private static boolean isStraight(String cards) { // 3 cards in row
        return false;
    }

    private static boolean isFlush(String cards) { // 3 cards in same suit
        return false;
    }

    private static boolean fold(Scanner in) {
        boolean valid = false;
        while (!valid) {
            System.out.println("Would you like to fold or discard? [F] / [D]");
            String answer = in.nextLine().toUpperCase();
            if (answer.equals("FOLD") || answer.equals("F")) {
                return true;
            } else if (answer.equals("DISCARD") || answer.equals("D")) {
                System.out.println("Error 412: Player does not want to play. Okay. fine.");
                return false;
            } else {
                System.out.println("Error 411: Invalid character. just type a letter. how did you mess that up");
            }
        }
        return false;
    }

    private static Boolean playAgain(Scanner in) {
        Boolean valid = false;
        while (!valid) {
            System.out.println("Do you want to play again? [Y] / [N]");
            String answer = in.nextLine().toUpperCase();
            if (answer.equals("YES") || answer.equals("Y")) {
                return true;
            } else if (answer.equals("NO") || answer.equals("N")) {
                System.out.println("Okay. fine.");
                return false;
            } else {
                System.out.println("What the heck. just type a letter. how did you mess that up");
            }
        }
        return false;
    }

    private static String discard(Scanner in, String player) {
        int disCards = getNum(in, "Please enter the number of cards you wish to discard.", 0, 3);
        String temp = player;
        if (disCards == 0)
            return player;
        else if (disCards == 3) {
            player = addCard(player + temp) + " ";
            player += addCard(player + temp) + " ";
            player += addCard(player + temp) + " ";
        } else {
            String cardToReplace = addCardsToDiscard(in, disCards, player);
            int space = cardToReplace.indexOf(" ");
            String card1 = "";
            if (space == -1)
                card1 = cardToReplace;
            else
                card1 = cardToReplace.substring(0, space);

            String card = addCard(player + temp);
            player = player.replace(card1, card);
            if (disCards == 2) {
                String card2 = cardToReplace.substring(space + 1);
                card = addCard(player + cardToReplace + temp);
                player = player.replace(card2, card);
            }
        }
        return player;
    }

    private static String addCardsToDiscard(Scanner in, int disCards, String player) {

        final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
        boolean valid = false;
        String cards = "";
        while (!valid) {
            System.out.println("Please enter the cards to replace: ");
            cards = in.nextLine().toUpperCase();
            if (countNum(cards, " ") != disCards - 1) {
                System.out.println("Please choose " + disCards + " cards to replace.");
            } else if ((disCards == 1) && (player.indexOf(cards) < 0))
                System.out.println("Error 412: Card not found. You don't have " + cards + " in your hand.");
            else if ((disCards == 1) && (player.indexOf(cards) >= 0))
                valid = true;
            else if (disCards == 2) {
                int space = cards.indexOf(" ");
                if (space < 0) {
                    System.out.println("Error 405: Data Input mismatch. You must choose two cards.");
                } else {
                    String card1 = cards.substring(0, space);
                    String card2 = cards.substring(space + 1);
                    if (VALID_CARDS.indexOf(card1) < 0)
                        System.out.println("Error 406: Invalid card. " + card1 + " is not a valid card.");
                    else if (VALID_CARDS.indexOf(card2) < 0)
                        System.out.println("Error 406: Invalid card. " + card2 + " is not a valid card.");
                    else if (cards.indexOf(card1) < 0)
                        System.out.println("Error 406: Invalid card. " + card1 + " is not a valid card.");
                    else if (cards.indexOf(card2) < 0)
                        System.out.println("Error 406: Invalid card. " + card2 + " is not a valid card.");
                    else if (card1.equals(card2))
                        System.out.println("Error 407: Discard mismatch. You cannot discard the same card.");
                    else
                        valid = true;
                }
            }
        }
        return cards;
    }

    private static int countNum(String str, String str2) {
        int count = 0;
        if (str2.length() > str.length()) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            String sub = str.substring(i, i + str2.length());
            if (str2.equals(sub)) {
                count++;
            }
        }
        return count;
    }

    private static int getNum(Scanner in, String prompt, int min, int max) {
        boolean valid = false;
        int val = 0;
        while (!valid) {
            System.out.println(prompt);
            try {
                val = Integer.parseInt(in.nextLine());
                if (val < min || val > max) {
                    System.out.println("Error 408: Invalid input. You may only discard up to three cards.");
                } else {
                    valid = true;
                }
            } catch (Exception ex) {
                System.out.println("Error 409: Invalid input. Please enter a number.");
            }
        }
        return val;
    }

    private static String addCard(String used) {
        String card = getFace() + getSuit();
        while (used.indexOf(card) >= 0) {
            card = getFace() + getSuit();
        }
        return card;
    }

    private static String getSuit() {
        int suit = (int) (Math.random() * 4);
        if (suit == 0) {
            return HEARTS;
        } else if (suit == 1) {
            return CLUBS;
        } else if (suit == 2) {
            return DIAMONDS;
        } else {
            return SPADES;
        }
    }

    private static String getFace() {
        int face = (int) (Math.random() * 12) + 1;
        if (face == 1) {
            return ACE;
        } else if (face == 11) {
            return JACK;
        } else if (face == 12) {
            return QUEEN;
        } else if (face == 13) {
            return KING;
        } else {
            return "" + face;
        }
    }

    private static int getBet(Scanner in, int wallet, int min, int max) {
        boolean valid = false;
        int bet = 0;
        while (!valid) {
            if (max < wallet) {
                System.out.println("Please enter a wager. The wager must be between $" + min + " and $" + max + ".");
            } else {
                System.out.println("Please enter a wager. The wager must be between $" + min + " and $" + wallet + ".");
            }
            try {
                bet = Integer.parseInt(in.nextLine());
                if (bet > wallet) {
                    System.out.println("\nError 401: Not enough funds. Your wallet only contains $" + wallet + ".");
                } else if (bet > max || bet < min) {
                    System.out.println("\nError 402: Bet range overflow. Please enter a value between $" + min
                            + " and $" + max + ".");
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