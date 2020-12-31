//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import  javax.swing.JLabel;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//
//public class rules extends JFrame {
//    public rules() {
//
//        this.setSize(300, 600);
//        setLocation(200, 600);
//        JLabel label = new JLabel();
//        add(label);
//        label.setSize(200,500);
//
//    setPicture(label, "gamerules-1.jpg");
//
//
//    }
//    public void setPicture(JLabel label, String filename){
//        try {
//            BufferedImage image = ImageIO.read(new File(filename));
//            int x = label.getSize().width;
//            int y = label.getSize().height;
//            int ix = image.getWidth();
//            int iy = image.getHeight();
//            int dx ;
//            int dy ;
//            if(x/y > ix/iy){
//                dy = y;
//                dx = dy*ix/iy;
//            } else {
//                dx = x;
//                dy = dx * iy / ix;
//            }
//            ImageIcon icon = new ImageIcon(image.getScaledInstance(dx,dy, Image.SCALE_SMOOTH));
//            label.setIcon(icon);
//        } catch ( IOException ex ) {
//            Logger.getLogger(rules.class.getName()).log(Level.SEVERE, null, ex);
//
//
//        }
//        }
//        public static void main(String[] args){
//        rules rules = new rules();
//        rules.setVisible(true);
//        }
//
//
//    }

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