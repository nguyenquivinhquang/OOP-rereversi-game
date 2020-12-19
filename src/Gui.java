

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GUI.*;

import javax.swing.*;

public class Gui extends JPanel {
    int x, y;
    JFrame frame = new JFrame("Reversi");

    public Gui() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RenderChessboard board = new RenderChessboard(x, y);

        frame.add(board);

        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Parameter.logo));
        board.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getRowColumn(e.getX(), e.getY());
                System.out.println(x + " " + y);
                board.setXY(x, y);

            }
        });
        frame.setSize(1000, 700);
        frame.setVisible(true);
    }

    public void getRowColumn(int x, int y) {
        int si = (int) (Double.valueOf(Parameter.size) / 8.0);
        this.x = x / si + 1;
        this.y = y / si + 1;
        System.out.println(this.x + " " + this.y);
    }
    private void closeProgram() {
        frame.dispose();
    }
    public static void main(String[] args) {
        Gui gui = new Gui();
    }
}