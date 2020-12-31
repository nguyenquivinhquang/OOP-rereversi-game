package Core;

import GUI.*;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PlayerVsPlayer extends JPanel {
    ArrayList<Coordinate> stage = new ArrayList<>();
    private static PlayerVsPlayer instance = null;
    int column = 8, row = 8, step = 1;
    int x, y, p1Score = 2, p2Score = 2;

    public int[][] boardStage = new int[row + 2][column + 2];
    int[][] possibleMove;
    int[][] board = new int[row + 2][column + 2];

    Coordinate score = new Coordinate();

    GamePlay gamePlay = GamePlay.getInstance();
    JFrame frame = new JFrame("Reversi");
    public Render render;

    public void resetArray() {
        for (int i = 0; i <= row; i++)
            for (int j = 0; j <= column; j++)
                boardStage[i][j] = -1;

        boardStage[4][4] = 2;
        boardStage[4][5] = 1;
        boardStage[5][4] = 1;
        boardStage[5][5] = 2;
        p1Score = p2Score = 2;
        step = 1;
    }

    protected Boolean checkCanMove(int x, int y) { // this function check if (x,y) is in the board or can move
        if (x > 8 || y > 8 || x < 1 || y < 1) return false;
        return boardStage[x][y] == -1 && possibleMove[x][y] == 1;
    }

    public void press() {

        while (!checkCanMove(x, y)) {
        }
        boardStage[x][y] = step;
        step = step == 1 ? 2 : 1;

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
        int si = (int) ((double) Parameter.size / 8.0);
        this.x = (x - Parameter.xStart) / si + 1;
        this.y = (y - Parameter.yStart) / si + 1;
    }

    protected void winner() {
        if (p1Score > p2Score)
            render.winner(1);
        else render.winner(2);
        frame.dispose();
    }

    protected void debug() {
        System.out.println("Step " + step);
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                int temp = boardStage[j][i];
                if (temp == -1) temp = 0;
                System.out.print(temp + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void actionGame() {
        while (1 != 0) {
            if (gamePlay.arrPosibleMove.size() != 0) {
                press(); // get is function to get player move
                gamePlay.flipChess(boardStage, step, x, y);

            } else {
                render.noMoves(step);
                if (step == 1) step = 2;
                else step = 1;
            }
            possibleMove = gamePlay.checkPosibleMove(boardStage, step);
            computeBoard();
            debug();
            if (gamePlay.checkEndGame(board)) {
                winner();
                break;
            }

            score = gamePlay.CountPlayerScore(board);
            p1Score = score.x;
            p2Score = score.y;
            render.setBoard(stage, p1Score, p2Score, step);

        }
    }

    public void getXY() {
        render.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getRowColumn(e.getX(), e.getY());
            }
        });

    }

    public PlayerVsPlayer() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        render = new Render(stage);

        resetArray();
        possibleMove = gamePlay.checkPosibleMove(boardStage, step);
        computeBoard();
        getXY();
        frame.add(render);

    }


    public static PlayerVsPlayer getInstance() {
        if (instance == null)
            instance = new PlayerVsPlayer();
        return instance;
    }

    public static void main(String[] args) {
        PlayerVsPlayer playerVsPlayer = PlayerVsPlayer.getInstance();
        playerVsPlayer.actionGame();
    }

}