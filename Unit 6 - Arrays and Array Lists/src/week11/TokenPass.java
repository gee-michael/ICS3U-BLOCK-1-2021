package week11;

public class TokenPass {
    private int[] board;
    private int currentPlayer;
    public TokenPass(int playerCount){
        board = new int[playerCount];
        for (int i = 0; i < playerCount; i++) board[i] = (int) (Math.random() * 10) + 1;  
    }

    public void distributeTokens(){
        int tokensLeft = board[currentPlayer];
        board[currentPlayer] = 0;

        int player = currentPlayer++;
        while (tokensLeft > 0){
            if (player == board.length) player = 0;
            board[player]++;
            tokensLeft--;
        }
    }
}