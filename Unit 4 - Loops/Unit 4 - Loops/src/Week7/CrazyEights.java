package Week7;

import java.util.Scanner;

public class CrazyEights {

    private static final String HEARTS = "♡";
    private static final String CLUBS = "♧";
    private static final String DIAMONDS = "♢";
    private static final String SPADES = "♤";

    private static final String ACE = "A";
    private static final String KING = "K";
    private static final String QUEEN = "Q";
    private static final String JACK = "J";

    private static final int NUM_CARDS = 5;
    private static final int P_TURN = 0;
    private static final int C1_TURN = 1;
    private static final int C2_TURN = 2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cardList = "A♤2♤3♤4♤5♤6♤7♤8♤9♤10♤J♤Q♤K♤A♧2♧3♧4♧5♧6♧7♧8♧9♧10♧J♧Q♧K♧A♢2♢3♢4♢5♢6♢7♢8♢9♢10♢J♢Q♢K♢A♡2♡3♡4♡5♡6♡7♡8♡9♡10♡J♡Q♡K♡";
        String deck = "";
        String discard = "";
        String player = "";
        String com1 = "";
        String com2 = "";

        int pCards = 0;
        int c1Cards = 0;
        int c2Cards = 0;

        int playerP = 0;
        int com1P = 0;
        int com2P = 0;

        boolean playAgain = true;
        if (playAgain) {
            playHand(in, deck, discard, cardList, player, com1, com2, playerP, com1P, com2P, pCards, c1Cards, c2Cards);
        }
        in.close();
    }

    private static void playHand(Scanner in, String deck, String discard, String cardList, String player, String com1, String com2, int playerP, int com1P, int com2P, int pCards, int c1Cards, int c2Cards) {
        String cardsUsed = cardList;
        for (int i = 0; i < NUM_CARDS; i++) {
            String playerCard = addCard(player, deck, cardsUsed);
            player += playerCard + " ";
            cardsUsed = cardsUsed.replace(playerCard, "");
            pCards++;
            String com1Card = addCard(com1, deck, cardsUsed);
            com1 += com1Card + " ";
            cardsUsed = cardsUsed.replace(com1Card, "");
            c1Cards++;
            String com2Card = addCard(com2, deck, cardsUsed);
            com2 += com2Card + " ";
            cardsUsed = cardsUsed.replace(com2Card, "");
            c2Cards++;
        }

        while (cardsUsed.length() > 0) {
            String deckCard = addCard(deck, deck, cardsUsed);
            deck += deckCard + " ";
            cardsUsed = cardsUsed.replace(deckCard, "");
        }

        System.out.println("Player's hand: " + player);
        System.out.println("Computer 1's hand: " + com1);
        System.out.println("Computer 2's hand: " + com2);
        System.out.println("Deck: " + deck);
        System.out.println(cardList);

        showDeck(in, deck, discard, player, com1, com2, playerP, com1P, com2P, pCards, c1Cards, c2Cards);
    }

    private static void showDeck(Scanner in, String deck, String discard, String player, String com1, String com2, int playerP, int com1P, int com2P, int pCards, int c1Cards, int c2Cards) {
        System.out.print("Computer 1 hand: ");
        for (int i = 0; i < c1Cards; i++) {
            System.out.print("[XX] ");
        }
        System.out.println("");
        System.out.print("Computer 2 hand: ");
        for (int i = 0; i < c2Cards; i++) {
            System.out.print("[XX] ");
        }
        System.out.println("");
        System.out.println("");
        if (getTop(deck, discard).substring(0, 2).equals("10")) {
            System.out.println("             ____   ____");
            System.out.println("            |\\%%/| |    |");
            System.out.println("            |%><%| |" + getTop(deck, discard) + " |");
            System.out.println("            |/%%\\| |____|");
        } else {
            System.out.println("             ____   ____");
            System.out.println("            |\\%%/| |    |");
            System.out.println("            |%><%| | " + getTop(deck, discard) + " |");
            System.out.println("            |/%%\\| |____|");
        }
        System.out.println("");
        String displayerHand = player.substring(0, player.length() - 1);

        int i = 0;
        while (i < displayerHand.length()){
            String temp = displayerHand.substring(i, i + 1);
            if (temp.equals(" ")){
                displayerHand = displayerHand.substring(0, i) + "] [" + displayerHand.substring(i + 1);
                i++;
            }
            i++;
        }
        System.out.println("Player's hand: [" + displayerHand + "]");
        playRound(in, deck, discard, player, com1, com2, playerP, com1P, com2P);
    }

    private static boolean gameOver(int playerP, int comp1P, int comp2P) {
        if (playerP < 100 || comp1P < 100 || comp2P < 100){
            return false;
        }
        return true;
    }

    private static String playRound(Scanner in, String deck, String discard, String player, String com1, String com2, int playerP, int comp1P, int comp2P) {
        while (!gameOver(playerP, comp1P, comp2P)){
            //String result = playRound(in, deck, discard); // "0-31-32"
            /*
            playerP += Integer.parseInt(result.substring(0, result.indexOf("-")));
            comp1P += Integer.parseInt(result.substring(result.indexOf("-") + 1, result.indexOf("-", result.indexOf("-") + 1)));
            comp2P += Integer.parseInt(result.substring(result.indexOf("-", result.indexOf("-") + 1)));
            */
           int turn = 0;
           if (playerP <= comp1P && playerP <= comp2P){
                turn = 0;
           } else if (comp1P <= playerP && comp1P <= comp2P){
                turn = 1;
           } else if (comp2P <= playerP && comp2P <= comp1P){
                turn = 2;
           }

           if (turn == 0){
               playerTurn(in, player, discard);
           } else if (turn == 1){
               comp1Turn(com1, discard);
           } else if (turn == 2){
               comp2Turn(com2, discard);
           }
           System.out.println(turn);

           turn = nextTurn(turn);
        }
        return "0-31-32";        
    }

    private static void comp2Turn(String com1, String discard) {
    }

    private static void comp1Turn(String com1, String discard) {
    }

    private static void playerTurn(Scanner in, String player, String discard) {
        System.out.println("What card would you like to play?");
        String nextCard = in.nextLine().toUpperCase();
        System.out.println(discard);
        if (discard.substring(0, discard.indexOf(" ")).equals(nextCard)){
            // good!
        } else {
            System.out.println("Error 401: Invalid card.");
            System.out.println("Please input a valid card to play.");
        }

    }

    private static int nextTurn(int turn) {
        if (turn == P_TURN) {
            return C1_TURN;
        } else if (turn == C1_TURN){
            return C2_TURN;
        } else if (turn == C2_TURN){
            return P_TURN;
        }
        return 0;
    }

    private static String getTop(String deck, String discard) {
        String top = deck.substring(0, deck.indexOf(" "));
        discard += top;
        return discard;
    }

    private static String addCard(String used, String deck, String cardList) {
        String card = getFace() + getSuit();
        while (used.indexOf(card) >= 0 || cardList.indexOf(card) == -1) {
            if (deck.indexOf("8") == 0) {
                deck = "";
            }
            card = getFace() + getSuit();
        }
        cardList = cardList.replace(card, "");
        return card;
    }

    // Computer 1 - [XX] [XX] [XX] [XX] [XX]
    // Computer 2 - [XX] [XX] [XX] [XX] [XX]
    //
    //             ____   ____
    //            |\%%/| |    |
    //            |%><%| | 7♢ |
    //            |/%%\| |____| 
    //
    // Player's hand - [7♢] [7♢] [7♢] [7♢] [7♢]

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
