import java.util.Arrays;


// Singleton design pattern

public class GamePlay {
    public static int row = 8, column = 8;

    public static int[][] CheckPosibleMove(int[][] check, int player) { //0: player 1, 1 player 2
        int[][] posibleMove = new int[row + 1][column + 1]; // 1 posible move, 2 posible move, 0 not
        int[][] leftDiagonal = new int[row + 1][column + 1], rightDiagonal = new int[row + 1][column + 1];
        int[][] horizontal = new int[row + 1][column + 1], vertical = new int[row + 1][column + 1];
        for (int i = 0; i < row; i++) {
            Arrays.fill(posibleMove[i], -1);
            Arrays.fill(vertical[i], -1);
            Arrays.fill(horizontal[i], -1);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j - 1 >= 0) {
                    if (check[i][j] == player) horizontal[i][j] = player;
                    else horizontal[i][j] = horizontal[i][j - 1];
                }
//                if (i - 1 >= 0) {
//                    if (check[i][j] == player) horizontal[i][j] = player;
//                    else horizontal[i][j] = horizontal[i - 1][j];
//                }
            }
        }

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (i - 1 >= 0 && check[i][j] == -1 && horizontal[i - 1][j] == player)
                    posibleMove[i][j] = 1;
//                if (j - 1 >= 0 && check[i][j] == -1 && horizontal[i][j - 1] == player)
//                    posibleMove[i][j] = 1;
            }
        // debug
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < column; j++)
                System.out.print(posibleMove[i][j] + " ");
            System.out.println();
        }

        return posibleMove;
    }



    public static int CountPlayer1Score(int[][] board) {
        int p1Score = 0;
        for (int i = 0; i < row; i++)
            for (int j = 1; j < column; j++)
                if (board[i][j] == 0) p1Score++;
        return p1Score;
    }
    public static int CountPlayer2Score(int[][] board) {
        int p2Score = 0;
        for (int i = 0; i < row; i++)
            for (int j = 1; j < column; j++)
                if (board[i][j] == 1) p2Score++;
        return p2Score;
    }

//    public static void main(String[] args) {
//        int[][] arr = new int[8][8];
//        //InputFile();
//        for (int i = 0; i < 8; i++)
//            for (int j = 0; j < 8; j++)
//                arr[i][j] = 13 + i + j;
//        //CheckPosibleMove(arr);
//    }
}
// debug
// for (int i = 0; i < row; i++) {
//        for (int j = 1; j < column; j++)
//        System.out.print(posibleMove[i][j] + " ");
//        System.out.println();
//        }