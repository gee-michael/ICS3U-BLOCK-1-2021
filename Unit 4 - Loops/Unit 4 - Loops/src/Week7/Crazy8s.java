package Week7;

import java.util.Scanner;

public class Crazy8s {
    
    private static final String cardsUsed = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
    private static final String HEARTS = "H"; // four suits
    private static final String CLUBS = "C";
    private static final String DIAMONDS = "D";
    private static final String SPADES = "S";

    private static final String ACE = "A"; // four non-number faces
    private static final String KING = "K";
    private static final String QUEEN = "Q";
    private static final String JACK = "J";

    private static final int NUM_CARDS = 5; // number of cards per hand
    private static final int P_TURN = 0; // whose turn it is
    private static final int C1_TURN = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String player = " ";
        String com1 = " ";
        String com2 = " ";
        String topCard = "";
        String deck = "";

        int playerP = 0;
        int com1P = 0;
        int com2P = 0;
        int turn = P_TURN;

        boolean playAgain = true; // if the user wants to play again
        boolean gamePlaying = true; // if the game if currently playing
        if (playAgain) {
            if (!gameOver(playerP, com1P, com2P)) { // if a player has >=100 points
                player = makeHand(player); // give cards to each player
                com1 = makeHand(com1);
                com2 = makeHand(com2);
                topCard = getTop(); // generates top card
                deck = topCard;
                while (gamePlaying) {
                    if (turn == P_TURN) {
                        while(!canPlay(player, deck)){
                            topCard = getCard();
                            player += topCard + " ";
                            System.out.println("You drew a " + topCard + ".");
                        }
                        displayCards(player, com1, com2, deck);
                        topCard = playTurn(in, player, turn, deck); // returns card to play
                        deck = topCard + " " + deck;
                        player = player.replace(topCard + " ", "");
                        if (countCards(player) == 0){
                            gamePlaying = gameActive(player, com1, com2);
                        }
                    } else if (turn == C1_TURN) {
                        while(!canPlay(com1, deck)){
                            topCard = getCard();
                            com1 += topCard + " ";
                            System.out.println("Computer drew a " + topCard + ".");
                        }
                        displayCards(player, com1, com2, deck);
                        topCard = playTurn(in, com1, turn, deck);
                        deck = topCard + " " + deck;
                        com1 = com1.replace(topCard + " ", "");
                        if (countCards(com1) == 0){
                            gamePlaying = gameActive(player, com1, com2);
                        }
                    } else {
                        while(!canPlay(com2, deck)){
                            topCard = getCard();
                            com2 += topCard + " ";
                            System.out.println("Computer drew a " + topCard + ".");
                        }
                        displayCards(player, com1, com2, deck);
                        topCard = playTurn(in, com2, turn, deck);
                        deck = topCard + " " + deck;
                        com2 = com2.replace(topCard + " ", "");
                        if (countCards(com2) == 0){
                            gamePlaying = gameActive(player, com1, com2);
                        }
                    }
                    turn = addTurn(turn);
                }
                playerP = calculateP(player);
                com1P = calculateP(com1);
                com2P = calculateP(com2);
            }
        }
        in.close();
    }

    private static String playTurn(Scanner in, String hand, int turn, String deck) {
        String card = "";
        if (turn != P_TURN) {
            card = comTurn(hand, deck);
        } else {
            card = playerTurn(in, hand, deck);
        }
        return card;
    }

    private static boolean canPlay(String hand, String deck) { // checks if you can play any card
        for (int i = 0; i < hand.length() - 3; i++) {
            if (validCard(hand.substring(i, i + 2), deck) || validCard(hand.substring(i, i + 3), deck)) {
                return true;
            }
        }
        return false;
    }

    private static String playerTurn(Scanner in, String hand, String deck) {
        System.out.println("What card would you like to play?");
        String nextCard = "";
        boolean valid = false;
        while (!valid) {
            nextCard = in.nextLine().toUpperCase();
            if (hand.indexOf(nextCard) == -1 && !validCard(nextCard, hand)) {
                System.out.println("Error: Invalid Card.");
            } else {
                if (hand.indexOf(nextCard) > -1 && validCard(nextCard, deck)) {
                    System.out.println("You played the " + nextCard + ".");
                    System.out.println();
                    valid = true;
                } else {
                    System.out.println("Error: Invalid Card.");
                }
            }
        }
        return nextCard;
    }

    private static String comTurn(String hand, String deck) {
        String nextCard = "";
        String nextCard2 = "";
        String result = "";
        for (int i = 0; i < hand.length() - 3; i++){
            nextCard = hand.substring(i, i + 2);
            nextCard2 = hand.substring(i, i + 3);
            if (cardsUsed.indexOf(nextCard) != -1){
                if (validCard(nextCard, hand)){
                    result = nextCard;
                } else if (validCard(nextCard2, hand)){
                    result = nextCard2;
                }
            }
        }
        System.out.println("Computer played the " + result + ".");
        System.out.println();
        return result;
    }

    private static boolean validCard(String card, String deck) { // checks if card is valid to first card in deck. ERROR WITH A-K-Q-J
        String temp = card;
        card += " ";
        deck += " ";
        return (!card.substring(0, 1).equals("0") // if the card does not have first character "0"
            && !temp.equals("10") // if the card does not just equal "10"
            && (cardsUsed.indexOf(card.substring(0, 2)) > -1 // if a viable card (length 2)
            || cardsUsed.indexOf(card.substring(0, 3)) > -1) // if a viable card (length 3)
            && (deck.substring(0, 1).equals(card.substring(0, 1)) // if first chars match (e.g. 7H & 7D)
            || deck.substring(1, 2).equals(card.substring(1, 2))  // if second chars match (e.g. KC & AC)
            || deck.substring(0, 2).equals(card.substring(0, 2))  // if first two chars match (e.g. 10S & 10D)
            || deck.substring(2, 3).equals(card.substring(1, 2))  // if second and third chars match (2D & 10)
            || deck.substring(1, 2).equals(card.substring(2, 3)))); // other way around
    }

    private static int addTurn(int turn) { // changes turn
        turn++;
        if (turn == 3) {
            turn = 0;
        }
        return turn;
    }

    private static boolean gameActive(String player, String com1, String com2) { // checks if any players have 0 cards
        return !(countCards(player) == 0 || countCards(com1) == 0 || countCards(com2) == 0);
    }

    private static void displayCards(String player, String com1, String com2, String deck) {
        System.out.println();
        System.out.print("Computer 1 hand: ");
        for (int i = 0; i < countCards(com1); i++) {
            System.out.print("[XX] ");
        }
        System.out.println("");
        System.out.print("Computer 2 hand: ");
        for (int i = 0; i < countCards(com2); i++) {
            System.out.print("[XX] ");
        }
        System.out.println("");
        System.out.println("");
        if (deck.substring(0, 2).equals("10")) {
            System.out.println("             ____   ____");
            System.out.println("            |\\%%/| |    |");
            System.out.println("            |%><%| |" + deck.substring(0, 3) + " |");
            System.out.println("            |/%%\\| |    |");
            System.out.println("             ‾‾‾‾   ‾‾‾‾");
        } else {
            System.out.println("             ____   ____");
            System.out.println("            |\\%%/| |    |");
            System.out.println("            |%><%| | " + deck.substring(0, 2) + " |");
            System.out.println("            |/%%\\| |    |");
            System.out.println("             ‾‾‾‾   ‾‾‾‾");
        }
        System.out.println("");
        String displayerHand = player.substring(0, player.length() - 1);

        int i = 0;
        while (i < displayerHand.length()) {
            String temp = displayerHand.substring(i, i + 1);
            if (temp.equals(" ")) {
                displayerHand = displayerHand.substring(0, i) + "] [" + displayerHand.substring(i + 1);
                i++;
            }
            i++;
        }
        System.out.println("Player's hand: [" + displayerHand + "]");
        System.out.println();
    }

    private static int countCards(String hand) { // counts # of spaces
        int count = 0;
        for (var i = 0; i < hand.length() - 1; i++) {
            if (hand.substring(i, i + 1).equals(" ")) {
                count++;
            }
        }
        return count + 1;
    }

    private static int calculateP(String hand) { // to be made
        return 0;
    }

    private static boolean gameOver(int playerP, int com1P, int com2P) { // checks points
        return (playerP >= 100 || com1P >= 100 || com2P >= 100);
    }

    private static String getTop() { // gets top card (not 8)
        String card = getCard();
        if (card.indexOf("8") == 0) {
            card = getCard();
        }
        return card;
    }

    private static String makeHand(String hand) { // gives NUM_CARDS cards
        String newHand = "";
        for (int i = 0; i < NUM_CARDS; i++) {
            newHand += getCard() + " ";
        }
        return newHand;
    }

    private static String getCard() { // makes card
        return getFace() + getSuit();
    }

    private static String getSuit() { // generates suit
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

    private static String getFace() { // generates face
        int face = (int) (Math.random() * 13) + 1;
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
}
