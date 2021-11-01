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
    private static final int MAX_PICKUP = 5; // max cards to pick up
    private static final int MAX_POINTS = 100;
    private static final int P_TURN = 0; // whose turn it is
    private static final int C1_TURN = 1; // don't need c2, can use 'else'

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String player = " "; // stores hand
        String com1 = " ";
        String com2 = " ";
        String topCard = ""; // stores top card OR new card

        int playerP = 0; // stores points
        int com1P = 0;
        int com2P = 0;

        int turn = P_TURN; // sets turn

        boolean playAgain = true; // if the user wants to play again
        boolean gamePlaying = true; // if the game if currently playing
        
        while (playAgain) {
            playerP = 0; // resets points for new round
            com1P = 0;
            com2P = 0;
            boolean isGameOver = gameOver(playerP, com1P, com2P);
            while (!isGameOver) { // if a player has >=100 points
                gamePlaying = true;
                player = makeHand(player); // give cards to each player
                com1 = makeHand(com1);
                com2 = makeHand(com2);
                topCard = getTop(); // generates top card
                String deck = topCard;
                turn = P_TURN;
                while (gamePlaying) {
                    if (turn == P_TURN) {
                        if (countCards(player) == 0) {
                            System.out.println("Player has won!");
                            gamePlaying = gameActive(player, com1, com2);
                        }
                        int cardsPickedUp = 0;
                        while (!canPlay(player, deck) && cardsPickedUp < 5) { // if the player needs to pick up
                            cardsPickedUp++;
                            topCard = getCard();
                            player += topCard + " ";
                            System.out.println("You drew a " + topCard + ".");
                        }
                        if (cardsPickedUp != MAX_PICKUP && canPlay(player, deck)){
                            displayCards(player, com1, com2, deck); // prints UI
                            topCard = playTurn(in, player, com1, com2, turn, deck); // returns card to play
                            player = player.replace(topCard + " ", ""); // replaces played card with ""
                            if (topCard.substring(0, 1).equals("8")) topCard = playerEights(in, topCard); // 8 check
                            deck = topCard + " " + deck;
                        } else System.out.println("You picked up 5 cards and still couldn't play. So sad :( \n");
                        if (countCards(player) == 0) { // win check
                            System.out.println("Player has won!");
                            gamePlaying = gameActive(player, com1, com2);
                        }
                    } else if (turn == C1_TURN) {
                        if (countCards(com1) == 0) {
                            System.out.println("Computer 1 has won!");
                            gamePlaying = gameActive(player, com1, com2);
                        }
                        int cardsPickedUp = 0;
                        while (!canPlay(com1, deck) && cardsPickedUp < 5) {
                            cardsPickedUp++;
                            topCard = getCard();
                            com1 += topCard + " ";
                            System.out.println("Computer 1 drew a card.");
                        }
                        if (cardsPickedUp != MAX_PICKUP && canPlay(com1, deck)){
                            displayCards(player, com1, com2, deck);
                            topCard = playTurn(in, com1, com2, player, turn, deck);
                            com1 = com1.replace(topCard + " ", "");
                            if (topCard.substring(0, 1).equals("8")) topCard = comEights(com1, topCard);
                            deck = topCard + " " + deck;
                        } else System.out.println("Computer 1 picked up 5 cards and still couldn't play. So sad :( \n");
                        if (countCards(com1) == 0) {
                            System.out.println("Computer 1 has won!");
                            gamePlaying = gameActive(player, com1, com2);
                        }
                    } else {
                        if (countCards(com2) == 0) {
                            System.out.println("Computer 2 has won!");
                            gamePlaying = gameActive(player, com1, com2);
                        }
                        int cardsPickedUp = 0;
                        while (!canPlay(com2, deck) && cardsPickedUp < 5) {
                            cardsPickedUp++;
                            topCard = getCard();
                            com2 += topCard + " ";
                            System.out.println("Computer 2 drew a card.");
                        }
                        if (cardsPickedUp != MAX_PICKUP && canPlay(com2, deck)){
                            displayCards(player, com1, com2, deck);
                            topCard = playTurn(in, com2, com1, player, turn, deck);
                            com2 = com2.replace(topCard + " ", "");
                            if (topCard.substring(0, 1).equals("8")) topCard = comEights(com2, topCard);
                            deck = topCard + " " + deck;
                        } else System.out.println("Computer 2 picked up 5 cards and still couldn't play. So sad :( \n");
                        if (countCards(com2) == 0) {
                            System.out.println("Computer 2 has won!");
                            gamePlaying = gameActive(player, com1, com2);
                        }
                        System.out.println("--------------------------");
                    }
                    turn = addTurn(turn);
                }
                playerP += calculateP(player);
                com1P += calculateP(com1);
                com2P += calculateP(com2);
                displayPoints(playerP, com1P, com2P);
                isGameOver = continueCheck(in, playerP, com1P, com2P); // checks for >100 points
                if (!isGameOver) gamePlaying = true;
            }
            System.out.println(winner(playerP, com1P, com2P));
            System.out.println("------------------------------");
            System.out.println("What a game!");
            boolean valid = false;
            while (!valid) {
                System.out.println("Would you like to play again? [Y] / [N]");
                String input = in.nextLine().toUpperCase();
                if (input.equals("N") || input.equals("NO")){
                    playAgain = false;
                    valid = true;
                } else if (!input.equals("Y") && !input.equals("YES")){
                    System.out.println("Error: Invalid response. Please enter Y or N.");
                } else {
                    valid = true;
                }
            }
        }
        in.close();
    }

    private static String comEights(String hand, String topCard) { // when a computer plays an 8
        int club = 0; // card counter for each suit
        int spade = 0; // the COM will change the suit to the most
        int heart = 0;
        int diamond = 0;
        for(var i = 0; i < hand.length(); i++){
            if (hand.substring(i, i+1).equals(CLUBS)) club++;
            else if (hand.substring(i, i+1).equals(SPADES)) spade++;
            else if (hand.substring(i, i+1).equals(HEARTS)) heart++;
            else if (hand.substring(i, i+1).equals(DIAMONDS)) diamond++; 
        }
        if (club > spade && club > heart && club > diamond){
            System.out.println("Computer changed the suit to clubs.");
            return topCard.substring(0, 1) + CLUBS;
        } else if (spade > club && spade > heart && spade > diamond){
            System.out.println("Computer changed the suit to spades.");
            return topCard.substring(0, 1) + SPADES;
        } else if (heart > club && heart > spade && heart > diamond){
            System.out.println("Computer changed the suit to hearts.");
            return topCard.substring(0, 1) + HEARTS;
        } else {
            System.out.println("Computer changed the suit to diamonds.");
            return topCard.substring(0, 1) + DIAMONDS;
        }
    }

    private static String playerEights(Scanner in, String topCard) { // when player plays an 8
        System.out.println("Choose a suit: H C D S");
        String suit = "";
        boolean valid = false;
        while (!valid) {
            suit = in.nextLine().toUpperCase();
            if (suit.equals("H") || suit.equals("C") || suit.equals("D") || suit.equals("S")) valid = true;
        }
        return topCard.substring(0, 1) + suit;
    }

    private static String winner(int playerP, int com1P, int com2P) { // returns the winner
        if (playerP < com1P && playerP < com2P) return "PLAYER HAS WON THE GAME!!!!";
        else if (com1P < playerP && com1P < com2P) return "COMPUTER 1 HAS WON THE GAME!!!!";
        else if (com2P < playerP && com2P < com1P) return "COMPUTER 2 HAS WON THE GAME!!!!";
        else return "IT'S A TIE. :( BORING";
    }

    private static boolean continueCheck(Scanner in, int playerP, int com1P, int com2P) {
        System.out.println("Press enter to continue.");
        String input = in.nextLine().toUpperCase();
        if (input.length() == 0 && gameOver(playerP, com1P, com2P)) return true;
        return false;
    }

    private static void displayPoints(int playerP, int com1P, int com2P) { // displays point UI
        int pPointLength = 0; // number of digits of points
        int c1PointLength = 0;
        int c2PointLength = 0;

        if (playerP == 0) pPointLength = 1;
        else pPointLength = (int) (Math.log10(playerP) + 1); // taken from stackOverflow
        if (com1P == 0) c1PointLength = 1;
        else c1PointLength = (int) (Math.log10(com1P) + 1); // calculates number of digits in a number
        if (com2P == 0) c2PointLength = 1;
        else c2PointLength = (int) (Math.log10(com2P) + 1);

        System.out.println("--------------------------");
        System.out.println();
        System.out.println("          POINTS");
        System.out.println();
        System.out.println("Player     Com1      Com2");
        System.out.println(" ____      ____      ____ ");

        if (pPointLength == 1) System.out.print("|  " + playerP + " |    ");
        else if (pPointLength == 2) System.out.print("| " + playerP + " |    ");
        else System.out.print("|" + playerP + " |    ");

        if (c1PointLength == 1) System.out.print("|  " + com1P + " |    ");
        else if (c1PointLength == 2) System.out.print("| " + com1P + " |    ");
        else System.out.print("|" + com1P + " |    ");

        if (c2PointLength == 1) System.out.println("|  " + com2P + " | ");
        else if (c2PointLength == 2) System.out.println("| " + com2P + " | ");
        else System.out.println("|" + com2P + " | ");
        System.out.println("|____|    |____|    |____| ");
    }

    private static String playTurn(Scanner in, String hand, String hand2, String hand3, int turn, String deck) {
        String card = "";
        if (turn != P_TURN) card = comTurn(hand, deck, hand2, hand3);
        else card = playerTurn(in, hand, deck);
        return card;
    }

    private static boolean canPlay(String hand, String deck) { // checks if you can play any card
        String temp = hand;
        hand += " ";
        for (int i = 0; i < hand.length() - 3; i++) if (temp.length() != 0 && (validCard(hand.substring(i, i + 2), deck) || validCard(hand.substring(i, i + 3), deck))) return true;
        return false;
    }

    private static String playerTurn(Scanner in, String hand, String deck) {
        System.out.println("What card would you like to play?");
        String nextCard = "";
        boolean valid = false;
        while (!valid) {
            nextCard = in.nextLine().toUpperCase();
            if (hand.indexOf(nextCard) == -1 && !validCard(nextCard, hand)) System.out.println("Error: Invalid Card.");
            else {
                if (hand.indexOf(nextCard) > -1 && validCard(nextCard, deck)) {
                    System.out.println("You played the " + nextCard + ".");
                    System.out.println();
                    valid = true;
                } else System.out.println("Error: Invalid Card.");
            }
        }
        return nextCard;
    }

    private static String comTurn(String hand, String deck, String hand2, String hand3) { // what the computers do
        String card = ""; // card length 2
        String card2 = ""; // card length 3
        String hasSuit = "";
        String hasRank = "";
        String hasEight = "";
        boolean hasCard2 = false;

        for (int i = 0; i < hand.length() - 1; i++) {
            hasCard2 = false;
            card = hand.substring(i, i + 2);
            if (hand.length() - i - 3 > 0) {
                card2 = hand.substring(i, i + 3);
                hasCard2 = true;
            }
            if (cardsUsed.indexOf(card) != -1 || cardsUsed.indexOf(card2) != -1) {
                if ((countCards(hand2) == 0 || countCards(hand3) == 0) && ((eight(card) || sameRank(card, deck)) || ((eight(card2) || (sameRank(card, deck)) && hasCard2)))){
                    System.out.println("Computer played the " + card + ".");
                    return card;
                } else if (sameSuit(card, deck)) hasSuit = card;
                else if (sameRank(card, deck)) hasRank = card;
                else if (eight(card)) hasEight = card;
                else if (hasCard2){
                    if (sameSuit(card2, deck)) hasSuit = card2;
                    else if (sameRank(card2, deck)) hasRank = card2;
                    else if (eight(card2)) hasEight = card2;
                }
            }
        }

        if (hasSuit.length() != 0){
            System.out.println("Computer played the " + hasSuit + ".");
            return hasSuit;
        } else if (hasRank.length() != 0){
            System.out.println("Computer played the " + hasRank + ".");
            return hasRank;
        } else {
            System.out.println("Computer played the " + hasEight + ".");
            return hasEight;
        }
    }

    private static boolean sameRank(String card, String deck) {
        String temp = card;
        card += " ";
        deck += " ";
        return (!card.substring(0, 1).equals("0") // if the card does not have first character "0"
                && !temp.equals("10") // if the card does not just equal "10"
                && (cardsUsed.indexOf(temp) > -1 // if a viable card
                && (deck.substring(0, 1).equals(card.substring(0, 1)) // if first chars match (7H & 7D)
                || deck.substring(0, 2).equals(card.substring(0, 2))))); // if 1st 2 chars match (10S & 10D)
    }

    private static boolean sameSuit(String card, String deck) {
        String temp = card;
        card += " ";
        deck += " ";
        return (!card.substring(0, 1).equals("0") // if the card does not have first character "0"
                && (cardsUsed.indexOf(temp) > -1 // if a viable card
                    && ((deck.substring(1, 2).equals(card.substring(1, 2)) && !card.substring(1, 2).equals("0")) // if 2nd chars match (KC & AC) AND if 2nd character is NOT zero
                        || (deck.substring(2, 3).equals(card.substring(2, 3)) && !card.substring(2, 3).equals(" ")) // if 3rd chars match (10S & 10D) AND if 3rd character is NOT space
                        || deck.substring(2, 3).equals(card.substring(1, 2)) // if 2nd and 3rd chars match (2D & 10D)
                        || deck.substring(1, 2).equals(card.substring(2, 3))))); // other way around
    }

    private static boolean eight(String card) {
        return (card.substring(0, 1).equals("8") && card.length() == 2);
    }

    private static boolean validCard(String card, String deck) { // checks if card is valid to first card in deck
        String temp = card;
        card += " ";
        deck += " ";
        return (!card.substring(0, 1).equals("0") // if the card does not have first character "0"
                && !temp.equals(" ") // if the card is not a space
                && !(temp.length() == 0) // if the card is not empty
                && !(temp.length() == 1) // if the card is not length one
                && !temp.equals("10") // if the card does not just equal "10"
                && (cardsUsed.indexOf(temp) > -1 // if a viable card
                        && (deck.substring(0, 1).equals(card.substring(0, 1)) // if first chars match (7H & 7D)
                                || deck.substring(1, 2).equals(card.substring(1, 2)) // if 2nd chars match (KC & AC)
                                || deck.substring(0, 2).equals(card.substring(0, 2)) // if 1st 2 chars match (10S & 10D)
                                || deck.substring(2, 3).equals(card.substring(1, 2)) // if 2nd and 3rd chars match (2D & 10D)
                                || deck.substring(1, 2).equals(card.substring(2, 3)) // other way around
                                || card.substring(0, 1).equals("8")))); // if an 8 (can be played on any suit)
    }

    private static int addTurn(int turn) { // changes turn
        turn++;
        if (turn == 3) turn = 0;
        return turn;
    }

    private static boolean gameActive(String player, String com1, String com2) { // checks if any players have 0 cards
        return !(countCards(player) == 0 || countCards(com1) == 0 || countCards(com2) == 0);
    }

    private static void displayCards(String player, String com1, String com2, String deck) { // prints card UI
        System.out.println();
        System.out.print("Computer 1 hand: ");
        for (int i = 0; i < countCards(com1); i++) System.out.print("[XX] ");
        System.out.println("");
        System.out.print("Computer 2 hand: ");
        for (int i = 0; i < countCards(com2); i++) System.out.print("[XX] ");
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
        while (i < displayerHand.length()) { // places brackets around player cards
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
        if (hand.length() == 0) return 0;
        int count = 0;
        for (var i = 0; i < hand.length() - 1; i++) if (hand.substring(i, i + 1).equals(" ")) count++;
        return count + 1;
    }

    private static int calculateP(String hand) {
        int points = 0;
        for (int i = 0; i < hand.length() - 1; i++) {
            if (hand.substring(i, i + 1).equals("A")) points++;
            else if (hand.substring(i, i + 1).equals("2")) points += 2;
            else if (hand.substring(i, i + 1).equals("3")) points += 3;
            else if (hand.substring(i, i + 1).equals("4")) points += 4;
            else if (hand.substring(i, i + 1).equals("5")) points += 5;
            else if (hand.substring(i, i + 1).equals("6")) points += 6;
            else if (hand.substring(i, i + 1).equals("7")) points += 7;
            else if (hand.substring(i, i + 1).equals("8")) points += 50;
            else if (hand.substring(i, i + 1).equals("9")) points += 9;
            else if (hand.substring(i, i + 1).equals("J") || hand.substring(i, i + 1).equals("Q") || hand.substring(i, i + 1).equals("K") || hand.substring(i, i + 2).equals("10")) points += 10;
        }
        return points;
    }

    private static boolean gameOver(int playerP, int com1P, int com2P) { // checks for >100 points
        return (playerP >= MAX_POINTS || com1P >= MAX_POINTS || com2P >= MAX_POINTS);
    }

    private static String getTop() { // gets top card (not 8)
        String card = getCard();
        if (card.indexOf("8") == 0) card = getCard();
        return card;
    }

    private static String makeHand(String hand) { // gives NUM_CARDS cards
        String newHand = "";
        for (int i = 0; i < NUM_CARDS; i++) newHand += getCard() + " ";
        return newHand;
    }

    private static String getCard() {
        return getFace() + getSuit();
    }

    private static String getSuit() {
        int suit = (int) (Math.random() * 4);
        if (suit == 0) return HEARTS;
        else if (suit == 1) return CLUBS;
        else if (suit == 2) return DIAMONDS;
        else return SPADES;
    }

    private static String getFace() {
        int face = (int) (Math.random() * 13) + 1;
        if (face == 1) return ACE;
        else if (face == 11) return JACK;
        else if (face == 12) return QUEEN;
        else if (face == 13) return KING;
        else return "" + face;
    }
}