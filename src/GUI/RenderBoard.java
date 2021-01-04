package GUI;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RenderBoard {

    private static RenderBoard instance = null;


    private RenderBoard() {}

    public void paintBoard(Graphics g) {


        g.clearRect(0, 0, Parameter.size, Parameter.size);
        BufferedImage imageBoard = null, imageBackground = null;
        try {
            imageBoard = ImageIO.read(new File(Parameter.board));
            imageBackground = ImageIO.read(new File(Parameter.background));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(imageBackground, 0, 0, 1000, 700, null);
        g.drawImage(imageBoard, Parameter.xStart, Parameter.yStart, Parameter.size, Parameter.size, null);

    }


    public static RenderBoard instance() {
        if (instance == null) {
            instance = new RenderBoard();
        }
        return instance;
    }
}
