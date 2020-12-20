package GUI;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class RenderChessboard extends JPanel {
    private  int x, y, p1Score, p2Score;


    int column = 8, row = 8, step = 1;
    public int[][] board = new int[row + 2][column + 2];

    public RenderChessboard(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public RenderChessboard(int[][] board) {

        this.board = board;
        p1Score = p2Score = 2;
    }
    public void setXY(int x, int y) {
        this.x = x - 1;
        this.y = y - 1;
        board[x][y] = 1;
        repaint();
    }
    public void setBoard(int[][] board, int p1Score, int p2Score) {
        this.board = board;
        this.p1Score = p1Score;
        this.p2Score = p2Score;
    }
    public void paintComponent(Graphics g) {
        g.clearRect(0,0,Parameter.size, Parameter.size);
        BufferedImage imageBoard = null, imageBackground = null;
        // get imageBackground
        try {
            imageBoard = ImageIO.read(new File(Parameter.defaultBoard));
            imageBackground = ImageIO.read(new File(Parameter.background));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(imageBackground, 0, 0,1000, 700, null);
        g.drawImage(imageBoard, Parameter.xStart, Parameter.yStart,Parameter.size, Parameter.size, null);

        RenderChess chess = new RenderChess(x, y);

        chess.paintScore(g, p1Score, p2Score);
        chess.paintChess(g, board);
        this.add(chess);
        repaint();


    }

    public void warning(JFrame frame, int check) {
        String command = "This is not a valid move, press again: ";
        if (check == 1)
            command = "This move already had, press again: ";

        JOptionPane.showMessageDialog(frame, command);
    }


    public void winner(JFrame frame, String playerWin) {

        ImageIcon icon = new ImageIcon(Parameter.winner);
        JOptionPane.showMessageDialog(null, "The winner is " + playerWin,
                "Quyên ngốc ", JOptionPane.INFORMATION_MESSAGE, icon);
    }
    public void noMoves(int step) {
        String name1 = "Player 1", name2 = "Player 2";
        if (step == 2) {
            name1 = "Player 2";
            name2 = "Player 1";
        }
        ImageIcon icon = new ImageIcon(Parameter.cannotMove);
        JOptionPane.showMessageDialog(null,name1 + " has no move, " + name2 + "'s turn ","You cannot move this turn", JOptionPane.INFORMATION_MESSAGE, icon);

    }
}
