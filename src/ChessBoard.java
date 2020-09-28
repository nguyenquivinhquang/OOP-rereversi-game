import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChessBoard {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    public int row = 8, column = 8;
    private int player = 0; // 0: player 1, 1: player 2.
    public int[][] move = new int[row][column];
    private Boolean[][] fee = new Boolean[100][100];
    private GamePlay game = new GamePlay();
    public int[][] posibleMove = new int[row][column];

    public ChessBoard() {
        prepareGUI();

    }

    public static void main(String[] args) {
        ChessBoard swingJlabelExam1 = new ChessBoard();
    }

    public JButton b[][] = new JButton[column + 2][row + 2];
    Icon icon1 = new ImageIcon("D:\\java\\MyCode\\src\\Image\\cross.gif");
    Icon icon2 = new ImageIcon("D:\\java\\MyCode\\src\\Image\\nought.gif");
    Icon iconPosibleMove = new ImageIcon("D:\\java\\MyCode\\src\\Image\\a.png");
    private JPanel scoreMenu = new JPanel();
    private JPanel panecenter = new JPanel();
    JPanel panelEast = new JPanel();

    public void prepareGUI() {
//        Arrays.fill(fee[0], Boolean.TRUE);
        for (int i = 0; i < 8; i++)
            Arrays.fill(move[i], -1);
        mainFrame = new JFrame("ChessBoard");
        mainFrame.setSize(800, 800);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        scoreMenu.setLayout(null);

        JLabel player1Score = new JLabel("Player 1 score: ");
        JLabel player2Score = new JLabel("Player 2 score: ");

        scoreMenu.add(player1Score);
        scoreMenu.add(player2Score);

        player1Score.setBounds(100, 50, 130, 20);
        player2Score.setBounds(100, 80, 130, 20);

        panecenter.setLayout(new GridLayout(8, 8));

        mainFrame.add(panecenter, BorderLayout.WEST);
        mainFrame.add(scoreMenu);

        for (int i = 0; i < column; i++)
            for (int j = 0; j < row; j++) {
                b[i][j] = new JButton();
                b[i][j].setActionCommand(i + " " + j);
                b[i][j].setBackground(Color.gray);
                b[i][j].addActionListener(this::actionPerformed);
                panecenter.add(b[i][j]);
            }

        panecenter.setSize(900, 900);
        System.out.println("hihi");
        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        System.out.println(s);
        int k = s.indexOf(32);
        int i = Integer.parseInt(s.substring(0, k));
        int j = Integer.parseInt(s.substring(k + 1, s.length()));
        if (move[i][j] != -1)
            return;

        if (player == 1) b[i][j].setIcon(icon1);
        else b[i][j].setIcon(icon2);
        move[i][j] = player;
        player = (player + 1) % 2;
        System.out.println("Runing into this function");

        posibleMove = GamePlay.CheckPosibleMove(move, player);
        //DrawPosibleMove();
    }

    public void DrawPosibleMove() {
        System.out.println("Running ....");
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (posibleMove[i][j] != -1) {
                    b[i][j].setIcon(iconPosibleMove);
                    panecenter.add(b[i][j]);
                    System.out.println("running");
                }
            }
    }


}