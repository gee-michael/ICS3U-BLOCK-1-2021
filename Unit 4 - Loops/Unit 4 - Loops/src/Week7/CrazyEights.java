package Week7;

import java.util.Scanner;

public class CrazyEights {

    private static final String HEARTS = "H";
    private static final String CLUBS = "C";
    private static final String DIAMONDS = "D";
    private static final String SPADES = "S";

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

        String deck = "";
        String discard = "";
        String player = "";
        String com1 = "";
        String com2 = "";

        int pCards = 0;
        int c1Cards = 0;
        int c2Cards = 0;

        boolean playAgain = true;
        if (playAgain) {
            playHand(in, deck, discard, player, com1, com2, pCards, c1Cards, c2Cards);
        }
        in.close();
    }

    private static void playHand(Scanner in, String deck, String discard, String player, String com1, String com2, int pCards, int c1Cards, int c2Cards) {
        String cardsUsed = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";

        for (int i = 0; i < NUM_CARDS; i++) {
            String playerCard = addCard(player, deck, cardsUsed);
            player += playerCard + " ";
            pCards++;
            String com1Card = addCard(com1, deck, cardsUsed);
            com1 += com1Card + " ";
            c1Cards++;
            String com2Card = addCard(com2, deck, cardsUsed);
            com2 += com2Card + " ";
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
        System.out.println("Discard: " + discard);

        discard = getTop(deck, discard) + " ";
        showDeck(in, discard, player, com1, com2, pCards, c1Cards, c2Cards);
        playRound(in, deck, cardsUsed, discard, player, com1, com2, pCards, c1Cards, c2Cards);
    }

    private static void showDeck(Scanner in, String discard, String player, String com1, String com2, int pCards, int c1Cards, int c2Cards) {

        if (gameEnd(pCards, c1Cards, c2Cards)){
            int playerP = getPoints(player, pCards);
            int com1P = getPoints(com1, c1Cards);
            int com2P = getPoints(com2, c2Cards);

            printPoints(playerP, com1P, com2P);
        }
        
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
        if (discard.substring(0, 2).equals("10")) {
            System.out.println("             ____   ____");
            System.out.println("            |\\%%/| |    |");
            System.out.println("            |%><%| |" + discard.substring(0, 3) + " |");
            System.out.println("            |/%%\\| |    |");
            System.out.println("             ‾‾‾‾   ‾‾‾‾");
        } else {
            System.out.println("             ____   ____");
            System.out.println("            |\\%%/| |    |");
            System.out.println("            |%><%| | " + discard.substring(0, 2) + " |");
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
        System.out.println("Player's hand: [" + displayerHand + "] [DRAW]");
    }

    private static void printPoints(int playerP, int com1P, int com2P){
        System.out.println("Player Points: " + playerP);
        System.out.println("Computer 1 Points: " + com1P);
        System.out.println("Computer 2 Points: " + com2P);
    }

    private static int getPoints(String cards, int num) {

        return 0;
    }

    private static boolean gameEnd(int pCards, int c1Cards, int c2Cards) {
        return pCards == 0 || c1Cards == 0 || c2Cards == 0;
    }

    private static boolean gameOver(int playerP, int comp1P, int comp2P) {
        if (playerP < 100 || comp1P < 100 || comp2P < 100) {
            return false;
        }
        return true;
    }
    // if (canPlay(hand), getSuit(topCard, getRank, topCard && cards drawn < 5))

    private static String playRound(Scanner in, String deck, String cardsUsed, String discard, String player, String com1, String com2, int pCards, int c1Cards, int c2Cards) {
            // String result = playRound(in, deck, discard); // "0-31-32"
            /*
             * playerP += Integer.parseInt(result.substring(0, result.indexOf("-"))); comp1P
             * += Integer.parseInt(result.substring(result.indexOf("-") + 1,
             * result.indexOf("-", result.indexOf("-") + 1))); comp2P +=
             * Integer.parseInt(result.substring(result.indexOf("-", result.indexOf("-") +
             * 1)));
             */
            int turn = P_TURN;
        while (!gameEnd(pCards, c1Cards, c2Cards)){
            if (turn == P_TURN) {
                boolean play = false;
                for (int i = 0; i < player.length() - 3; i++) {
                    if (!play && (canPlay(player.substring(i, i + 2), discard, cardsUsed)
                            || canPlay(player.substring(i, i + 3), discard, cardsUsed))) {
                        play = true;
                    }
                }
                if (!play) {
                    String card = drawCard(player, deck, discard, cardsUsed);
                    player = player + card + " ";
                    pCards++;
                    if (!canPlay(card, discard, cardsUsed)){
                        card = drawCard(player, deck, discard, cardsUsed);
                        player = player + card + " ";
                        pCards++;
                    } else {
                        play = true;
                    }
                } else {
                    String playersCard = playerTurn(in, player, discard, deck, cardsUsed, pCards);
                    discard = "" + playersCard + " " + discard;
                    System.out.println(playersCard);
                    player = player.replace(playersCard + " ", "");
                }
                showDeck(in, discard, player, com1, com2, pCards, c1Cards, c2Cards);
                //turn = nextTurn(turn);
            } else if (turn == C1_TURN) {
                comp1Turn(com1, discard);
                //turn = nextTurn(turn);
            } else if (turn == C2_TURN) {
                comp2Turn(com2, discard);
                //turn = nextTurn(turn);
            }
        }
        return "0-31-32";
    }

    private static String comp2Turn(String com1, String discard) {
        return "";
    }

    private static String comp1Turn(String com1, String discard) {
        return "";
    }

    private static String playerTurn(Scanner in, String player, String discard, String deck, String cardsUsed, int pCards) {
        System.out.println("What card would you like to play?");
        String nextCard = "";
        boolean valid = false;
        boolean drewCard = false;
        while (valid == false) {
            nextCard = in.nextLine().toUpperCase();
            /**
             * if (nextCard.equals("DRAW")){ String playerCard = drawCard(player, deck,
             * discard, cardsUsed); while (!canPlay(playerCard, discard)){ playerCard =
             * drawCard(player, deck, discard, cardsUsed); player += playerCard; pCards++; }
             * nextCard = playerCard; valid = true; } else
             */

            if (player.indexOf(nextCard) == -1) {
                System.out.println("Error 402: Card not found.");
            } else {
                try {
                    if (player.indexOf(nextCard) >= 0 && canPlay(nextCard, discard, cardsUsed) || drewCard) {
                        System.out.println("You played the " + nextCard + ".");
                        valid = true;
                    } else {
                        System.out.println("Error 401: Invalid card.");
                    }
                } catch (Exception ex) {
                    System.out.println("Error 401: Invalid card.");
                    System.out.println("Please input a valid card to play.");
                }
            }
        }
        return nextCard;
    }

    private static String drawCard(String player, String deck, String discard, String cardsUsed) {
        String card = addCard(player, deck, cardsUsed);
        card = addCard(player, deck, cardsUsed);
        System.out.println("You drew a " + card);
        return card;
    }

    private static boolean canPlay(String card, String discard, String cardsUsed) {
        card = card + " ";
        for (int i = 0; i < card.length() - 2; i++){
            if (card.substring(i, i + 1).equals(" ") || cardsUsed.indexOf(card) == -1){
                return false;
            }
        }
        return (discard.substring(0, 1).equals(card.substring(0, 1))     // if first chars match (e.g. 7H & 7D)
                || discard.substring(1, 2).equals(card.substring(1, 2))  // if second chars match (e.g. KC & AC)
                || discard.substring(0, 2).equals(card.substring(0, 2))  // if first 2 chars match (e.g. 10S & 10H)
                || discard.substring(1, 2).equals(card.substring(2, 3))  // if second and third char match (2D & 10D)
                || discard.substring(2, 3).equals(card.substring(1, 2))); // if third and second char match (10D & 2D)
    }

    private static int nextTurn(int turn) {
        if (turn == P_TURN) {
            return C1_TURN;
        } else if (turn == C1_TURN) {
            return C2_TURN;
        } else if (turn == C2_TURN) {
            return P_TURN;
        }
        return 0;
    }

    private static String getTop(String deck, String discard) {
        String top = deck.substring(0, deck.indexOf(" "));
        return discard += top;
    }

    private static String addCard(String used, String deck, String cardList) {
        String card = getFace() + getSuit();
        if (deck.indexOf("8") == 0) {
            deck = "";
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