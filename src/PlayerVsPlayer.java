import Core.GamePlay;
import GUI.Coordinate;
import GUI.Parameter;
import GUI.RenderChessboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PlayerVsPlayer extends JPanel {
    ArrayList<Coordinate> stage = new ArrayList<Coordinate>();
    int column = 8, row = 8, step = 1;
    int x, y, p1Score = 2, p2Score = 2;

    public int[][] fee = new int[row + 2][column + 2];
    int[][] possibleMove = new int[row + 2][column + 2];
    int[][] board = new int[row + 2][column + 2];

    Coordinate score = new Coordinate();

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

    protected int checkCanMove(int x, int y) {
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
            boardFrame.warning(frame, check);
            return false;
        } else fee[x][y] = step;

        this.x = x;
        this.y = y;
        step = step == 1 ? 2 : 1;
        return true;

    }

    protected void computeBoard() {
        stage.clear();
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++) {
                board[i][j] = -1;
                board[i][j] = fee[i][j];
                if (fee[i][j] == -1 && possibleMove[i][j] == 1) board[i][j] = 3;
                if (board[i][j] != -1) stage.add(new Coordinate(i, j, board[i][j]));
            }

    }

    protected void getRowColumn(int x, int y) {
        int si = (int) (Double.valueOf(Parameter.size) / 8.0);
        this.x = (x - Parameter.xStart) / si + 1;
        this.y = (y - Parameter.yStart) / si + 1;

//        System.out.println(this.x + " " + this.y);
    }

    protected void winner() {
        if (p1Score > p2Score)
            boardFrame.winner(frame, "Player 1");
        else boardFrame.winner(frame, "Player 2");
        frame.dispose();
    }

    protected void running() {

    }

    public void actionGame() {

        boardFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (gamePlay.arrPosibleMove.size() != 0) {
                    getRowColumn(e.getX(), e.getY());

                    if (press(x, y) == true) {
                        System.out.println(step);
                        gamePlay.flipChess(fee, step, x, y);
                        possibleMove = gamePlay.checkPosibleMove(fee, step);
                        computeBoard();
//                        System.out.println("Score: " + p1Score + " " + p2Score);
                    }
                } else {
                    boardFrame.noMoves(step);
                    if (step == 1) step = 2; else step = 1;
                }

                if (gamePlay.checkEndGame(board) == true) {
                    winner();
                }
                score = gamePlay.CountPlayerScore(board);
                p1Score = score.x;
                p2Score = score.y;
                boardFrame.setBoard(stage, p1Score, p2Score, step);
            }
        });
    }

    public PlayerVsPlayer() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardFrame = new RenderChessboard(stage);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Parameter.logo));
//
        resetArray();
        possibleMove = gamePlay.checkPosibleMove(fee, step);
        computeBoard();
        frame.add(boardFrame);
//        boardFrame.warning(frame, 2);
        actionGame();
        frame.setSize(1000, 700);
        frame.setVisible(true);
    }

    public static PlayerVsPlayer getInstance() {
        return new PlayerVsPlayer();
    }

    public static void main(String[] args) {
        PlayerVsPlayer test = new PlayerVsPlayer();
    }

}