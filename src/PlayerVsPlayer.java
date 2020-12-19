import GUI.Parameter;
import GUI.RenderChessboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerVsPlayer extends JPanel {
    private final String Quyen = "Cute";
    int column = 8, row = 8, step = 1;
    int x, y, p1Score = 2, p2Score = 2;

    public int[][] fee = new int[row + 2][column + 2];
    int[][] possibleMove = new int[row + 2][column + 2];
    int[][] board = new int[row + 2][column + 2];


    public ConsoleGui graphic = ConsoleGui.getInstance();

    GamePlay gamePlay = GamePlay.getInstance();
    JFrame frame = new JFrame("Reversi");
    RenderChessboard boardFrame;

    private void resetArray() {
        for (int i = 0; i <= row; i++)
            for (int j = 0; j <= column; j++)
                fee[i][j] = -1;

        fee[4][4] = 2;
        fee[4][5] = 1;
        fee[5][4] = 1;
        fee[5][5] = 2;
    }

    public int checkCanMove(int x, int y) {
        if (x > 8 || y > 8) return 3;
        if (fee[x][y] != -1)
            return 1;
        if (possibleMove[x][y] != 1)
            return 2;
        return 0;
    }

    public Boolean press(int x, int y) {

        int check = checkCanMove(x, y);
        if (check != 0) {
            if (check == 3) return false;
            boardFrame.warning(frame,check);
            return false;
        } else fee[x][y] = step;

        this.x = x;
        this.y = y;
        step = step == 1 ? 2 : 1;
        return true;

    }

    private void computeBoard() {
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++) {
                board[i][j] = -1;
                board[i][j] = fee[i][j];
                if (fee[i][j] == -1 && possibleMove[i][j] == 1) board[i][j] = 3;
            }

    }



    private void getRowColumn(int x, int y) {
        int si = (int) (Double.valueOf(Parameter.size) / 8.0);
        this.x = x / si + 1;
        this.y = y / si + 1;

        System.out.println(this.x + " " + this.y);
    }
    private void winner() {
        if (p1Score > p2Score)
            boardFrame.winner(frame, "Player 1");
        else boardFrame.winner(frame, "Player 2");
        frame.dispose();

    }
    public void actionGame() {
        resetArray();
//        while (Quyen.equals("Cute")) {
//            possibleMove = gamePlay.checkPosibleMove(fee, step);
//            if (gamePlay.arrPosibleMove.size() != 0) {
//                computeBoard();
//                graphic.display(board);
//                press();
//                gamePlay.flipChess(fee, step, x, y);
//            } else noMoves();
//        }

        ///////////////////////////////////////////
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardFrame = new RenderChessboard(board);
//        boardFrame.setBoard(board);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Parameter.logo));
        possibleMove = gamePlay.checkPosibleMove(fee, step);

        computeBoard();
        frame.add(boardFrame);
        boardFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

//                possibleMove = gamePlay.checkPosibleMove(fee, step);
//                boardFrame.setBoard(board);
                if (gamePlay.arrPosibleMove.size() != 0) {

                    getRowColumn(e.getX(), e.getY());

                    if (press(x, y) == true) {
//                        boardFrame.setXY(x, y);
                        gamePlay.flipChess(fee, step, x, y);
                        possibleMove = gamePlay.checkPosibleMove(fee, step);
                        computeBoard();

                        System.out.println("Score: " + p1Score + " " + p2Score);

                    }
                } else{
                    boardFrame.noMoves(step);
                }
                if (gamePlay.checkEndGame(board) == true ) {
                    winner();
                    step = step == 1 ? 2 : 1;
                }
                p1Score = gamePlay.CountPlayerScore(board, 1);
                p2Score = gamePlay.CountPlayerScore(board, 2);
                boardFrame.setBoard(board, p1Score, p2Score);
            }
        });

        frame.setSize(1000, 700);
        frame.setVisible(true);

    }

    public static PlayerVsPlayer getInstance() {
        return new PlayerVsPlayer();
    }

}
