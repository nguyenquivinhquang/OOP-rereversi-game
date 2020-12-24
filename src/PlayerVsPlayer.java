import Core.GamePlay;
import GUI.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PlayerVsPlayer extends JPanel {
    ArrayList<Coordinate> stage = new ArrayList<Coordinate>();
    int column = 8, row = 8, step = 1;
    int x, y, p1Score = 2, p2Score = 2;

    public int[][] boardStage = new int[row + 2][column + 2];
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
                boardStage[i][j] = -1;

        boardStage[4][4] = 2;
        boardStage[4][5] = 1;
        boardStage[5][4] = 1;
        boardStage[5][5] = 2;
    }

    protected Boolean checkCanMove(int x, int y) { // this function check if (x,y) is in the board or can move
        if (x > 8 || y > 8 || x < 1 || y < 1) return false;

        return boardStage[x][y] == -1 && possibleMove[x][y] == 1;
    }

    public Boolean press(int x, int y) {

        if (!checkCanMove(x, y)) {
            return false;
        } else boardStage[x][y] = step;

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
                board[i][j] = boardStage[i][j];
                if (boardStage[i][j] == -1 && possibleMove[i][j] == 1) board[i][j] = 3;
                if (board[i][j] != -1) stage.add(new Coordinate(i, j, board[i][j]));
            }

    }

    protected void getRowColumn(int x, int y) {
        int si = (int) (Double.valueOf(Parameter.size) / 8.0);
        this.x = (x - Parameter.xStart) / si + 1;
        this.y = (y - Parameter.yStart) / si + 1;

    }

    protected void winner() {
        if (p1Score > p2Score)
            boardFrame.winner(frame, "Player 1");
        else boardFrame.winner(frame, "Player 2");
        frame.dispose();
    }

    protected void debug() {
        System.out.println("Step " + step );
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                int temp = boardStage[i][j];
                if (temp == -1) temp = 0;
                System.out.print(temp + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void stepDoing() {

    }
    public void actionGame() {
        boardFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (gamePlay.arrPosibleMove.size() != 0) {
                    getRowColumn(e.getX(), e.getY());
                    if (press(x, y) == true) {
                        gamePlay.flipChess(boardStage, step, x, y);
                        possibleMove = gamePlay.checkPosibleMove(boardStage, step);
                        computeBoard();
                    }
                } else {
                    boardFrame.noMoves(step);
                    if (step == 1) step = 2;
                    else step = 1;
                }

                debug();
                if (gamePlay.checkEndGame(board) == true) winner();

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

        resetArray();
        possibleMove = gamePlay.checkPosibleMove(boardStage, step);
        computeBoard();
        frame.add(boardFrame);

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