import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Minimax {
    private int row = 8, column = 8;
    int[][] regionScore = new int[row + 2][column + 2];
    int[][] Board = new int[row + 2][column + 2];

    private void input() throws FileNotFoundException {
        File x = new File("D:\\java\\OOP-rereversi-game\\src\\RegionScore.txt");
        Scanner sc = new Scanner(x);
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++)
                regionScore[i][j] = sc.nextInt();
        //DebugArr.debug(regionScore, "score: ");
    }

    public void setBoard(int[][] board) {
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; i++)
                Board[i][j] = board[i][j];
    }

    private int score(int[][] arr, int turn) {
        int s = 0;
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; i++)
                if (arr[i][j] == turn) s += regionScore[i][j];
        return s;
    }
}
