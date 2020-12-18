import java.util.ArrayList;


public class Minimax {
    private final int row = 8;
    private final int column = 8;
    private final int maxDepth = 5;
    private static  int[][] regionScore = RegionScore.getRegionScore();


    private int[][] copyBoard(int[][] board, GamePlay gamePlay, int x, int y, int player) {
        int[][] arr = new int[row + 2][column + 2];

        for (int i = 1; i <= row; i++)
            System.arraycopy(board[i], 1, arr[i], 1, column);
        arr[x][y] = player;
        if (player == 1) player = 2; else player = 1;
        gamePlay.flipChess(arr, player, x, y);
        return arr;
    }

    public int decision(int depth, int[][] board, int curPlayer) {
        GamePlay gamePlay = GamePlay.getInstance();
        int nextPlayer = 1;
        if (curPlayer == 1) nextPlayer = 2;
        if (depth == maxDepth || gamePlay.checkEndGame(board))
            return score(board, curPlayer);

        gamePlay.checkPosibleMove(board, nextPlayer);
        ArrayList<cond> move = gamePlay.arrPosibleMove;

        if (move.size() == 0)
            return decision(depth + 1, board, nextPlayer);
        int bestmove;
        bestmove = curPlayer == 2 ? 1000 : -1000;
        for (cond v : move) {
            int val = decision(depth + 1, copyBoard(board, gamePlay, v.x, v.y, nextPlayer), nextPlayer);
            if (curPlayer == 2)
                bestmove = val < bestmove ? val : bestmove;
            else bestmove = val > bestmove ? val : bestmove;
        }
        return bestmove;
    }

    public cond decision(int x, int y, int[][] board) {

        GamePlay gamePlay = GamePlay.getInstance();
        gamePlay.checkPosibleMove(board, 2);
        ArrayList<cond> moveH = new ArrayList<>();
        moveH = gamePlay.arrPosibleMove;
        System.out.println(moveH.size());
        cond bestMove = new cond();
        int bestVal = -1000;
        bestMove.x = 100;
        bestMove.y = 100;
        for (cond v : moveH) {
            int val = decision(2, copyBoard(board, gamePlay, v.x, v.y, 2), 2);
            if (val > bestVal) {
                bestMove.x = v.x;
                bestMove.y = v.y;
                bestVal = val;
            }
        }
        return bestMove;
    }

    private int score(int[][] arr, int turn) {
        int s = 0;
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++)
                if (arr[i][j] == turn) s += regionScore[i][j];
        return s;
    }

    public cond getOptimalMove(int[][] board, int x, int y) {
        return decision(x, y, board);
    }

    public static Minimax getInstance() {
        return new Minimax();
    }
}