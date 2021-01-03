package GUI;

import Core.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Render extends JPanel {
    private int x, y, p1Score, p2Score;
    public int step = 1;
    private ArrayList<Coordinate> board;
    public RenderBoard renderBoard;
    public RenderChess renderChess;

    public Render() {
        renderBoard = RenderBoard.instance();
        renderChess = RenderChess.instance();
    }

    public Render(ArrayList<Coordinate> board) {
        this();
        this.board = board;
        p1Score = p2Score = 2;
    }

    public void setBoard(ArrayList<Coordinate> board, int p1Score, int p2Score, int step) {
        this.board = board;
        this.p1Score = p1Score;
        this.p2Score = p2Score;
        this.step = step;
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        renderBoard.paintBoard(g);
        renderChess.paintScore(g, p1Score, p2Score);
        try {
            renderChess.paintChess(g, board);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        renderChess.paintCurrentMove(g, step);
    }

    public void winner(int id) {
        String playerWin = Parameter.player1;
        if (id == 2) playerWin = Parameter.player2;
        ImageIcon icon = new ImageIcon(Parameter.winner);
        JOptionPane.showMessageDialog(null, "The winner is " + playerWin,
                "Winner yah yah ", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    public void noMoves(int step) {
        String name1 = Parameter.player1, name2 = Parameter.player2;
        if (step == 2) {
            name1 = Parameter.player2;
            name2 = Parameter.player1;
        }
        ImageIcon icon = new ImageIcon(Parameter.cannotMove);
        JOptionPane.showMessageDialog(null, name1 + " has no move, " + name2 + " 's turn ", " You cannot move this turn", JOptionPane.INFORMATION_MESSAGE, icon);
    }

}
