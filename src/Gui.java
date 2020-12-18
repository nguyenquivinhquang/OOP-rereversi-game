

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
        JLabel text = new JLabel();
        text.setText("hihi");
        frame.add(board);

        board.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                System.out.println(e.getX() + "," + e.getY());
                getRowColumn(e.getX(), e.getY());
                System.out.println(x + " " + y);
                board.setXY(x, y);
                if (x == 3){
                    RenderChessboard.winner(frame, "1");
                    frame.dispose();
                }

            }
        });
        frame.setSize(1000, 700);
        frame.setVisible(true);
    }

    public void getRowColumn(int x, int y) {
        int si = (int) (Double.valueOf(RenderChessboard.si) / 8.0);
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