import java.util.Scanner;

public class ConsoleGui {
    char player1 = 'X', player2 = 'O', possible = 'i';
    private final String Quyen = "Cute";
    char[][] draw = new char[9][9];
    int column = 8, row = 8, step = 0;
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

    public void press() {
        Scanner myObj = new Scanner(System.in);
        int x = 0, y = 0;
        System.out.println("Press x,y to move: ");
        while (fee[x][y] == -1) {
            x = myObj.nextInt();
            y = myObj.nextInt();
            if (fee[x][y] != -1)
                System.out.println("This move already had, press again: ");
            else fee[x][y] = step;
        }
        //myObj.close();
        this.x = x;
        this.y = y;
        if (step == 1)
            step = 2;
        else step = 1;
    }

    private void setArrToPrint() {
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++)
                if (fee[x][y] != -1) {
                    draw[x][y] = fee[x][y] == 1 ? player1 : player2;
                } else if (posibleMove[i][j] == 1) draw[i][j] = possible;
    }

    private void display() {
        setArrToPrint();
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                System.out.print(draw[i][j]);
            }
            System.out.println();
        }
    }


    public void actionGame() {
        resetArray();
        while (Quyen.equals("Cute")) {
            posibleMove = GamePlay.CheckPosibleMove(fee, step);
            display();
            press();
            int[][] eat = new int[row + 2][column + 2];
            eat = GamePlay.flipChess(fee, step, x, y);
        }

    }

    public static ConsoleGui getInstance() {
        return new ConsoleGui();
    }

}
