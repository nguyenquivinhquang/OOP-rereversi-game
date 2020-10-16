import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Minimax {
    private final int row = 8;
    private final int column = 8;
    private final int maxDepth = 5;
    private int[][] regionScore = new int[row + 2][column + 2];
    int[][] board = new int[row + 2][column + 2];

    private void input() throws FileNotFoundException {
        File x = new File("D:\\java\\OOP-rereversi-game\\src\\RegionScore.txt");
        Scanner sc = new Scanner(x);
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++)
                regionScore[i][j] = sc.nextInt();
    }

    public void setBoard(int[][] board) {
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; i++)
                this.board[i][j] = board[i][j];
    }


    private int[][] copyBoard(int[][] board, GamePlay gamePlay, int x, int y, int player) {
        int[][] arr = new int[row + 2][column + 2];
        for (int i = 1; i <= row; i++)
            if (column >= 0) System.arraycopy(board[i], 1, arr[i], 1, column);
        gamePlay.flipChess(arr, player, x, y);
        return arr;
    }

    public int decision(int depth, int[][] board, int curPlayer) {
        GamePlay gamePlay = GamePlay.getInstance();
        int nextPlayer = 1;
        if (curPlayer == 1) nextPlayer = 1;
        if (depth == maxDepth || gamePlay.checkEndGame(board))
            return score(board, curPlayer);

        gamePlay.checkPosibleMove(board, curPlayer);
        ArrayList<cond> move = gamePlay.arrPosibleMove;

        if (move.size() == 0)
            return decision(depth + 1, board, nextPlayer);
        int bestmove;
        bestmove = curPlayer == 1 ? 1000 : -1000;
        for (cond v : move) {
            int val = decision(depth + 1, copyBoard(board, gamePlay, v.x, v.y, curPlayer), nextPlayer);
            if (curPlayer == 1)
                bestmove = val < curPlayer ? val : bestmove;
            else bestmove = val > curPlayer ? val : bestmove;
        }
        return bestmove;
    }

    public cond decision(int x, int y, int[][] board) {
        cond res = new cond();

        return res;
    }

    private int score(int[][] arr, int turn) {
        int s = 0;
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; i++)
                if (arr[i][j] == turn) s += regionScore[i][j];
        return s;
    }
}


