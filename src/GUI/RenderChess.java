package GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RenderChess extends JPanel {
    int column = 8, row = 8, step = 1;
    public int[][] board = new int[row + 2][column + 2];
    private Coordinate position = new Coordinate();

    public RenderChess(int x, int y) {
        position.setXY(x, y);
    }

    public void paintScore(Graphics g, int p1Score, int p2Score) {
        g.setColor(Color.WHITE);
        g.fillRect(600, 60, 500, 500);

        g.setColor(Color.BLUE);
        g.setFont(g.getFont().deriveFont(20f));
        g.drawString(Parameter.player1 + " score is " + p1Score, 600, 100);
        g.drawString(Parameter.player2 + " score is " + p2Score, 600, 150);



    }

    public void paintChess(Graphics g, int[][] board) {
        BufferedImage player1Image = null, player2Image = null, suggestImage = null;
        try {
            player1Image = ImageIO.read(new File(Parameter.blackChess));
            player2Image = ImageIO.read(new File(Parameter.whiteChess));
            suggestImage = ImageIO.read(new File(Parameter.suggest));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++) {
                int x = i - 1, y = j - 1;
                BufferedImage image = null;
                if (board[i][j] == 1)
                    image = player1Image;
                else if (board[i][j] == 2)
                    image = player2Image;
                else if (board[i][j] == 3)
                    image = suggestImage;
                g.drawImage(image, Parameter.xStart + Parameter.stepSize * x,
                        Parameter.yStart + Parameter.stepSize * y, Parameter.width, Parameter.height, null);

            }
    }
}
