package Week7;

import java.util.Scanner;

public class CrazyEights {
    private static String CARD_LIST = "A♤2♤3♤4♤5♤6♤7♤8♤9♤10♤J♤Q♤K♤A♧2♧3♧4♧5♧6♧7♧8♧9♧10♧J♧Q♧K♧A♢2♢3♢4♢5♢6♢7♢8♢9♢10♢J♢Q♢K♢A♡2♡3♡4♡5♡6♡7♡8♡9♡10♡J♡Q♡K♡";
    private static String DECK = "";
    private static String player = "";
    private static String comp1 = "";
    private static String comp2 = "";
    private static int PLAYER_CARDS = 0;
    private static int COMP1_CARDS = 0;
    private static int COMP2_CARDS = 0;

    private static final String HEARTS = "♡";
    private static final String CLUBS = "♧";
    private static final String DIAMONDS = "♢";
    private static final String SPADES = "♤";

    private static final String ACE = "A";
    private static final String KING = "K";
    private static final String QUEEN = "Q";
    private static final String JACK = "J";
    private static final int NUM_CARDS = 5;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int playerPoints = 0;
        int comp1Points = 0;
        int comp2Points = 0;
        boolean playAgain = true;
        if (playAgain){
            playHand();
            showDeck();
        }
        in.close();
    }

    private static void showDeck() {
        System.out.print("Computer 1 hand: ");
        for (int i = 0; i < COMP1_CARDS; i++){
            System.out.print("[XX]");
        }
        System.out.println("");
        System.out.print("Computer 2 hand: ");
        for (int i = 0; i < COMP2_CARDS; i++){
            System.out.print("[XX]");
        }
        System.out.println("");
        if (getTop().substring(0, 2) == "10"){
            System.out.println("                           _____");
            System.out.println("                          |     |");
            System.out.println("                          | " + getTop() + " |");
            System.out.println("                          |_____|");
        } else if (getTop().substring(0, 2) != "10"){
            System.out.println("                           ____");
            System.out.println("                          |    |");
            System.out.println("                          | " + getTop() + " |");
            System.out.println("                          |____|");
        }
        System.out.println("Player's hand: " + player);
    }

    private static String getTop() {
        return DECK.substring(0, DECK.indexOf(" "));
    }

    private static void playHand() {
        String player = "";
        String comp1 = "";
        String comp2 = "";

        for (int i = 0; i < NUM_CARDS; i++){
            player += addCard(player) + " ";
            PLAYER_CARDS++;
            comp1 += addCard(comp1) + " ";
            COMP1_CARDS++;
            comp2 += addCard(comp2) + " ";
            COMP2_CARDS++;
        }

        while (CARD_LIST.length() > 0){
            DECK += addCard(DECK) + " ";
        }
        
        System.out.println("Player's hand: " + player);
        System.out.println("Computer 1's hand: " + comp1);
        System.out.println("Computer 2's hand: " + comp2);
        System.out.println("Deck: " + DECK);
        System.out.println(CARD_LIST);
    }

    private static String addCard(String used) {
        String card = getFace() + getSuit();
        while (used.indexOf(card) >= 0 || CARD_LIST.indexOf(card) == -1) {
            card = getFace() + getSuit();
        }
        CARD_LIST = CARD_LIST.replace(card, "");
        return card;
    }


//  Computer 1 - [  ] [  ] [  ] [  ] [  ]
//  Computer 2 - [  ] [  ] [  ] [  ] [  ]
//                           ____
//                          |    |
//                          | 7H |        
//                          |____|
//
//  [7H] [7H] [7H] [7H] [7H]

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
