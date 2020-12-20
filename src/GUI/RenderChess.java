package GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RenderChess extends JPanel {
    int column = 8, row = 8, step = 1;
    private ArrayList<Coordinate> board;
    private Coordinate position = new Coordinate();

    public RenderChess(int x, int y) {
        position.setXY(x, y);
    }

    public void paintScore(Graphics g, int p1Score, int p2Score) {

        g.setColor(Color.WHITE);
        g.setFont(new Font("Garamond", Font.PLAIN, 20));
        g.drawString(Parameter.player1 + " score is " + p1Score, Parameter.xStart + 600, Parameter.yStart +100);
        g.drawString(Parameter.player2 + " score is " + p2Score, Parameter.xStart + 600, Parameter.yStart +150);

    }

    public void paintChess(Graphics g, ArrayList<Coordinate> board) {
        BufferedImage player1Image = null, player2Image = null, suggestImage = null;
        try {
            player1Image = ImageIO.read(new File(Parameter.blackChess));
            player2Image = ImageIO.read(new File(Parameter.whiteChess));
            suggestImage = ImageIO.read(new File(Parameter.suggest));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Coordinate v : board) {
            BufferedImage image = null;
            int x = v.x - 1, y = v.y - 1;
            if (v.type == 1)
                image = player1Image;
            else if (v.type  == 2)
                image = player2Image;
            else if (v.type  == 3)
                image = suggestImage;
            g.drawImage(image, Parameter.xStart + Parameter.stepSize * x,
                    Parameter.yStart + Parameter.stepSize * y, Parameter.width, Parameter.height, null);
        }
    }
}
