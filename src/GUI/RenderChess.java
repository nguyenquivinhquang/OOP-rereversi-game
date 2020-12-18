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

    public void paintScore(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        g.setColor(Color.WHITE);
        g.fillRect(600, 60, 100, 100);

        g.setColor(Color.BLUE);
        g.setFont(g.getFont().deriveFont(20f));
        g.drawString("score is " + position.x, 600, 100);
    }

    public void paintChess(Graphics g) {
        BufferedImage player1Image = null, player2Image = null, suggestImage = null;
        try {
            player1Image = ImageIO.read(new File("E:\\java\\OOP-rereversi-game\\src\\Image\\Black circle chess.png\\"));
            player2Image = ImageIO.read(new File("E:\\java\\OOP-rereversi-game\\src\\Image\\White circle chess.png\\"));
            suggestImage = ImageIO.read(new File("E:\\java\\OOP-rereversi-game\\src\\Image\\Suggestions.png\\"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++) {
                BufferedImage image = null;
                if (board[i][j] == 1)
                    image = player1Image;
                else if (board[i][j] == 2)
                    image = player2Image;
                else if (board[i][j] == 3)
                    image = suggestImage;
                g.drawImage(image, Parameter.xStart + Parameter.stepSize * i,
                        Parameter.yStart + Parameter.stepSize * j, Parameter.width, Parameter.height, null);

            }
    }
}
