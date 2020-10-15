import java.util.Scanner;

public class ConsoleGui {
    char player1 = 'X', player2 = 'O', possible = 'i';
    private final String Quyen = "Cute";
    char[][] draw = new char[9][9];
    private int column = 8, row = 8;

    public void getXY(int x, int y) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Press x,y to move: ");
        x = myObj.nextInt();
        y = myObj.nextInt();
    }

    public void warning(int cond) {
        if (cond == 1)
            System.out.println("This move already had, press again: ");
        else System.out.println("This is not a valid move, press again: ");
    }

    private void setArrToPrint(int[][] board) {
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++) {
                draw[i][j] = '.';
                if (board[i][j] == 1)
                    draw[i][j] = player1;
                if (board[i][j] == 2)
                    draw[i][j] = player2;
                if (board[i][j] == 3)
                    draw[i][j] = possible;
            }
    }

    public void display(int[][] board) {
        setArrToPrint(board);
        System.out.print("  ");
        for (int i = 1; i <= column; i++)
            System.out.print(i + " ");
        System.out.println();
        for (int i = 1; i <= row; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= column; j++) {
                System.out.print(draw[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static ConsoleGui getInstance() {
        return new ConsoleGui();
    }

}
