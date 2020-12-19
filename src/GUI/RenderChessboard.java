package GUI;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class RenderChessboard extends JPanel {
    private  int x, y;

    public int check = 0;
    int column = 8, row = 8, step = 1;
    public int[][] board = new int[row + 2][column + 2];

    public RenderChessboard(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x - 1;
        this.y = y - 1;
    }
    public void setBoard(int[][] board) {
        this.board = board;
    }
    public void paintComponent(Graphics g) {
        g.clearRect(0,0,Parameter.size, Parameter.size);
        BufferedImage imageBackground = null, imageChess = null;
        // get imageBackground
        try {
            imageBackground = ImageIO.read(new File(Parameter.defaultBoard));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(imageBackground, 0, 0,Parameter.size, Parameter.size, null);


        //Test
        BufferedImage player1Image = null;
        try {
            player1Image = ImageIO.read(new File(Parameter.blackChess));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(player1Image, Parameter.xStart + Parameter.stepSize * x,Parameter.yStart + Parameter.stepSize * y, Parameter.width, Parameter.height, null );

        //
        RenderChess chess = new RenderChess(x, y);
        chess.paintScore(g);
        this.add(chess);
        repaint();
        if (x == 5)
            check = 1;

    }

    private void warning(JFrame frame, int check) {
        String command;
        if (check == 1)
            command = "This move already had, press again: ";
       else command = "This is not a valid move, press again: ";
        JOptionPane.showMessageDialog(frame, command);
    }
    public static void winner(JFrame frame, String playerWin) {

        ImageIcon icon = new ImageIcon(Parameter.winner);
        JOptionPane.showMessageDialog(null, "The winner is " + playerWin,
                "Quyên ngốc ", JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
