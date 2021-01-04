package Core;

import GUI.*;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class PlayerVsPlayer {
    ArrayList<Coordinate> stage = new ArrayList<>();
    private static PlayerVsPlayer instance = null;
    int column = 8, row = 8, step = 1;
    int x, y, p1Score = 2, p2Score = 2;
    boolean endGame = false;
    public int[][] boardStage = new int[row + 2][column + 2];
    int[][] possibleMove;
    int[][] board = new int[row + 2][column + 2];

    Coordinate score = new Coordinate();

    GamePlay gamePlay = GamePlay.getInstance();

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
        endGame = false;
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
    }

    public void actionGame() {
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

        score = gamePlay.CountPlayerScore(board);
        p1Score = score.x;
        p2Score = score.y;
        render.setBoard(stage, p1Score, p2Score, step);
        if (gamePlay.checkEndGame(board)) {
            winner();
            endGame = true;
            return;
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

    public void newGame() {
        resetArray();
        render.step = 1;
        render.repaint();
        possibleMove = gamePlay.checkPosibleMove(boardStage, step);
        computeBoard();
        getXY();
    }

    protected PlayerVsPlayer() {
        render = new Render(stage);
        newGame();
    }


    public static PlayerVsPlayer getInstance() {
        if (instance == null)
            instance = new PlayerVsPlayer();
        return instance;
    }

    public void running() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (endGame == true) return;
                actionGame();
            }
        };
        Timer timer = new Timer("Timer");
        timer.schedule(timerTask, 100, 1);

    }

}