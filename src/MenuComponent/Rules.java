package MenuComponent;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Rules extends JPanel {

    private BufferedImage image;

    public Rules() {
        try {
            image = ImageIO.read(new File("gamerules-1.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Rules.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        g.drawImage(image, 2000, 2000, 100, 100, null); // see javadoc for more info on the parameters
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Rules rules = new Rules();

        frame.add(rules);
        frame.setVisible(true);
    }


}