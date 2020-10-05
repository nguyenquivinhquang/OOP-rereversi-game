import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class demo {
    public static int row = 8, column = 8;
    public static int[][] arr = new int[row + 1][column + 1], temp = new int[row + 1][column + 1];

    public static int[][] checkPosible(int[][] check, int player) { // 1 the next move is player 1, 2 the next move is
        // player 2
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
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++)
                System.out.print(posible[i][j] + " ");
            System.out.println();
        }

        return posible;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/mnt/CODE/java/OOP-rereversi-game/src/hihi.txt");
        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNext()) {
            for (int i = 1; i <= 8; i++)
                for (int j = 1; j <= 8; j++) {
                    arr[i][j] = inputFile.nextInt();
                }
            // System.out.println(i);
        }
        inputFile.close();
        temp = checkPosible(arr, 0);
    }
}
