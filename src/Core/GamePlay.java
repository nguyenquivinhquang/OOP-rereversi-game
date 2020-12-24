package Core;

import GUI.*;


import java.util.ArrayList;


public class GamePlay {
    private final int row = Parameter.row;
    private final int column = Parameter.column;
    public ArrayList<cond> arrPosibleMove = new ArrayList<>();

    public int[][] checkPosibleMove(int[][] check, int player) { // 1: player 1 just moved, 2 player 2 just moved.
        arrPosibleMove.clear();
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

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++)
                if (posible[i][j] == 1) {
                    cond temp = new cond();
                    temp.x = i;
                    temp.y = j;
                    arrPosibleMove.add(temp);
                }
        }
        //System.out.println("-------------------------------------");
        return posible;
    }

    public Coordinate CountPlayerScore(int[][] board) {
        Coordinate score = new Coordinate();

        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++) {
                if (board[i][j] == 1) score.x++;
                if (board[i][j] == 2) score.y++;
            }
        return score;
    }

    private boolean goFind(int[][] check, int player, int i, int j, int u, int v) {
        if (i == 0 || i > row || j == 0 || j > column || check[i][j] == -1)
            return false;
        if (check[i][j] != player)
            return true;

        boolean flag = goFind(check, player, i + u, j + v, u, v);
        if (flag) {
            check[i][j] = player == 1 ? 2 : 1;
        }
        return flag;
    }

    public void flipChess(int[][] check, int player, int x, int y) { //{x,y} current position, player: previous player

        goFind(check, player, x - 1, y, -1, 0);
        goFind(check, player, x - 1, y - 1, -1, -1);
        goFind(check, player, x - 1, y + 1, -1, 1);


        goFind(check, player, x, y - 1, 0, -1);
        goFind(check, player, x, y + 1, 0, 1);

        goFind(check, player, x + 1, y - 1, 1, -1);
        goFind(check, player, x + 1, y, 1, 0);
        goFind(check, player, x + 1, y + 1, 1, 1);
    }

    public boolean checkEndGame(int[][] board) {
        int count = 0;
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++)
                if (board[i][j] == 1 || board[i][j] == 2)
                    count++;
        return count == 64;
    }

    public static GamePlay getInstance() {
        return new GamePlay();
    }
}


