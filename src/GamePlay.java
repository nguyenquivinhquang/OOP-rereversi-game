class cond {
    // leftDiagnoal : (1,1) -> (8,8), rightDiagonal (1,8) -> (8,1)
    public int leftDiagonal = -1, rigthDiagonal = -1, horizontal = -1, vertical = -1;

}

public class GamePlay {
    private static final int row = 8;
    private static final int column = 8;

    public static int[][] checkPosibleMove(int[][] check, int player) { // 1: player 1 just moved, 2 player 2 just moved.
        int[][] posible = new int[row + 2][column + 2];
        cond[][] arr = new cond[row + 2][column + 2];
        int prev;
        if (player == 1)
            prev = 2;
        else prev = 1;

        for (int i = 0; i <= row + 1; i++)
            for (int j = 0; j <= column + 1; j++)
                arr[i][j] = new cond();
        // go from UpLeft to Down Right
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++) {
                if (check[i][j] == player) {
                    arr[i][j].vertical = arr[i][j].horizontal = player;
                    arr[i][j].leftDiagonal = arr[i][j].rigthDiagonal = player;
                } else if (check[i][j] != -1) {
                    arr[i][j].horizontal = arr[i][j - 1].horizontal;
                    arr[i][j].vertical = arr[i - 1][j].vertical;
                    arr[i][j].leftDiagonal = arr[i - 1][j - 1].leftDiagonal;
                    arr[i][j].rigthDiagonal = arr[i - 1][j + 1].rigthDiagonal;
                }

            }
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++) {
                if (check[i][j] == -1 && arr[i][j - 1].horizontal == player && check[i][j - 1] == prev)
                    posible[i][j] = 1;
                if (check[i][j] == -1 && arr[i - 1][j].vertical == player && check[i - 1][j] == prev)
                    posible[i][j] = 1;
                if (check[i][j] == -1 && arr[i - 1][j - 1].leftDiagonal == player && check[i - 1][j - 1] == prev)
                    posible[i][j] = 1;
                if (check[i][j] == -1 && arr[i - 1][j + 1].rigthDiagonal == player && check[i - 1][j + 1] == prev)
                    posible[i][j] = 1;
            }

        // go from DownRight to LeftUp
        for (int i = row; i >= 1; i--)
            for (int j = column; j >= 1; j--) {
                if (check[i][j] == player) {
                    arr[i][j].vertical = arr[i][j].horizontal = player;
                    arr[i][j].leftDiagonal = arr[i][j].rigthDiagonal = player;
                } else if (check[i][j] != -1) {
                    arr[i][j].horizontal = arr[i][j + 1].horizontal;
                    arr[i][j].vertical = arr[i + 1][j].vertical;
                    arr[i][j].leftDiagonal = arr[i + 1][j + 1].leftDiagonal;
                    arr[i][j].rigthDiagonal = arr[i + 1][j - 1].rigthDiagonal;
                }

            }
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++) {
                if (check[i][j] == -1 && arr[i][j + 1].horizontal == player && check[i][j + 1] == prev)
                    posible[i][j] = 1;
                if (check[i][j] == -1 && arr[i + 1][j].vertical == player && check[i + 1][j] == prev)
                    posible[i][j] = 1;
                if (check[i][j] == -1 && arr[i + 1][j + 1].leftDiagonal == player && check[i + 1][j + 1] == prev)
                    posible[i][j] = 1;
                if (check[i][j] == -1 && arr[i + 1][j - 1].rigthDiagonal == player && check[i + 1][j - 1] == prev)
                    posible[i][j] = 1;
            }
        // debug
//        for (int i = 1; i <= row; i++) {
//            for (int j = 1; j <= column; j++)
//                System.out.print(posible[i][j] + " ");
//            System.out.println();
//        }
        System.out.println("-------------------------------------");
        return posible;
    }

    public static int CountPlayerScore(int[][] board, int player) {
        int pScore = 0;
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++)
                if (board[i][j] == player)
                    pScore++;
        return pScore;
    }

    private static boolean goFind(int[][] check, int player, int i, int j, int u, int v) {
        if (i == 0 || i == row || j == 0 || j == column || check[i][j] == -1)
            return false;
        if (check[i][j] != player)
            return true;
//        i += u;
//        j += v;
        boolean flag = goFind(check, player, i + u, j + v, u, v);
        if (flag) {
            check[i][j] = player == 1 ? 2 : 1;
        }
        return flag;
    }

    public static void flipChess(int[][] check, int player, int x, int y) { //{x,y} current position, player: current player
        //player = player == 1 ? 2 : 1;
        int[][] eat = new int[row + 2][column + 2];
        goFind(check, player, x + -1, y, -1, 0);
        goFind(check, player, x - 1, y + -1, -1, -1);
        goFind(check, player, x - 1, y + 1, -1, 1);
        goFind(check, player, x, y - 1, 0, -1);
        goFind(check, player, x, y + 1, 0, 1);
        goFind(check, player, x + 1, y - 1, 1, -1);
        goFind(check, player, x + 1, y, 1, 0);
        goFind(check, player, x + 1, y + 1, 1, 1);

    }

}


