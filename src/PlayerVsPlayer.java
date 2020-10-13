import java.util.Scanner;

public class PlayerVsPlayer {
    char player1 = 'X', player2 = 'O', possible = 'i';
    private final String Quyen = "Cute";
    char[][] draw = new char[9][9];
    int column = 8, row = 8, step = 1;
    int[][] fee = new int[row + 2][column + 2];
    int[][] posibleMove = new int[row + 2][column + 2];
    int x, y;

    private void resetArray() {
        for (int i = 0; i <= row; i++)
            for (int j = 0; j <= column; j++) {
                fee[i][j] = -1;
                draw[i][j] = '.';
            }
        fee[4][4] = 1;
        fee[4][5] = 2;
        fee[5][4] = 2;
        fee[5][5] = 1;
    }


    public static PlayerVsPlayer getInstance() {
        return new PlayerVsPlayer();
    }

}
