import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Minimax {
    private int row = 8, column = 8, maxDepth = 5;
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


    public ArrayList<cond> getPosibleMove(int[][] board, int player) {
        GamePlay gamePlay = GamePlay.getInstance();
        gamePlay.checkPosibleMove(board, player);
        ArrayList<cond> posibleMove;
        posibleMove = gamePlay.arrPosibleMove;
        return posibleMove;
    }

    public int decision(int depth, int[][] board, int curPlayer) {
        GamePlay gamePlay = GamePlay.getInstance();
        if (depth == maxDepth || gamePlay.checkEndGame(board) == true)
            return score(board, curPlayer);
        gamePlay.checkPosibleMove(board, curPlayer);
        ArrayList<cond> move = gamePlay.arrPosibleMove;
        for (cond v : move) {

        }
        return 0;
    }

    public void decision(int[][] board, int curPlayer) {

    }

    private int score(int[][] arr, int turn) {
        int s = 0;
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; i++)
                if (arr[i][j] == turn) s += regionScore[i][j];
        return s;
    }
}
