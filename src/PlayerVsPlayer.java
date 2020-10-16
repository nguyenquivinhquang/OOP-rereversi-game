
public class PlayerVsPlayer {
    private String Quyen = "Cute";
    int column = 8, row = 8, step = 1;
    private int[][] fee = new int[row + 2][column + 2];
    int[][] posibleMove = new int[row + 2][column + 2];
    int[][] board = new int[row + 2][column + 2];
    int x, y;
    public ConsoleGui graphic = ConsoleGui.getInstance();
    GamePlay gamePlay = GamePlay.getInstance();

    public PlayerVsPlayer() {

    }

    private void resetArray() {
        for (int i = 0; i <= row; i++)
            for (int j = 0; j <= column; j++)
                fee[i][j] = -1;

        fee[4][4] = 1;
        fee[4][5] = 2;
        fee[5][4] = 2;
        fee[5][5] = 1;
    }

    private int checkCanMove(int x, int y) {
        if (fee[x][y] != -1)
            return 1;
        if (posibleMove[x][y] != 1)
            return 2;
        return 0;
    }

    public void press() {
        int x = 0, y = 0;
        while (fee[x][y] == -1) {
            cond temp = graphic.getXY();
            x = temp.x;
            y = temp.y;
            int check = checkCanMove(x, y);
            if (check != 0)
                graphic.warning(check);
            else fee[x][y] = step;
        }
        this.x = x;
        this.y = y;
        step = step == 1 ? 2 : 1;
    }

    private void computeBoard() {
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++) {
                board[i][j] = -1;
                board[i][j] = fee[i][j];
                if (fee[i][j] == -1 && posibleMove[i][j] == 1) board[i][j] = 3;
            }

    }

    private void noMoves() {
        String name1 = "Player 1", name2 = "Player 2";
        if (step == 2) {
            name1 = "Player 2";
            name2 = "Player 1";
        }
        System.out.println(name1 + "has no move, " + name2 + "'s turn ");
    }

    public void actionGame() {
        resetArray();
        while (Quyen.equals("Cute")) {
            posibleMove = gamePlay.checkPosibleMove(fee, step);
            if (gamePlay.arrPosibleMove.size() != 0) {
                computeBoard();
                graphic.display(board);
                press();
                gamePlay.flipChess(fee, step, x, y);
            } else noMoves();
        }
    }

    public static PlayerVsPlayer getInstance() {
        return new PlayerVsPlayer();
    }

}
