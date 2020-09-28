import javax.swing.*;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;


public class ChessBoard {
    private JFrame mainFrame;

    public int row = 8, column = 8;
    public int[][] move = new int[row][column];
    public int[][] posibleMove = new int[row][column];

    private int player = 0, p1Score = 0, p2Score = 0; // 0: player 1, 1: player 2.

    public ChessBoard() {
        prepareGUI();
    }

    public static void main(String[] args) {
        ChessBoard swingJlabelExam1 = new ChessBoard();
    }

    public JButton b[][] = new JButton[column + 2][row + 2];

    Icon icon1 = new ImageIcon("D:\\java\\MyCode\\src\\Image\\cross.gif");
    Icon icon2 = new ImageIcon("D:\\java\\MyCode\\src\\Image\\nought.gif");
    Icon iconPosibleMove = new ImageIcon("D:\\java\\Reversi\\src\\Image\\a.jpg");

    private JPanel scoreMenu = new JPanel();
    private JPanel panecenter = new JPanel();

    JLabel player1Score = new JLabel("Player 1 score: 0");
    JLabel player2Score = new JLabel("Player 2 score: 0");

    public void prepareGUI() {
        for (int i = 0; i < 8; i++)
            Arrays.fill(move[i], -1);
        mainFrame = new JFrame("ChessBoard");
        mainFrame.setSize(800, 800);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        panecenter.setLayout(new GridLayout(8, 8));
        mainFrame.add(panecenter, BorderLayout.WEST);
        for (int i = 0; i < column; i++)
            for (int j = 0; j < row; j++) {
                b[i][j] = new JButton();
                b[i][j].setActionCommand(i + " " + j);
                b[i][j].setBackground(Color.gray);
                b[i][j].addActionListener(this::actionPerformed);
                panecenter.add(b[i][j]);
            }
        scoreMenu.setLayout(null);


        scoreMenu.add(player1Score);
        scoreMenu.add(player2Score);

        player1Score.setBounds(90, 50, 130, 20);
        player2Score.setBounds(90, 80, 130, 20);

        mainFrame.add(scoreMenu);
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

        p1Score  = GamePlay.CountPlayer1Score(move);
        p2Score  = GamePlay.CountPlayer2Score(move);
        player1Score.setText("Player 1 score: "+ p1Score);
        player2Score.setText("Player 2 score: "+ p2Score);

        posibleMove = GamePlay.CheckPosibleMove(move, player);
        player = (player + 1) % 2;
//        /DrawPosibleMove();
    }

    public void DrawPosibleMove() {
        System.out.println("Running ....");
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (posibleMove[i][j] != -1) {
                    //b[i][j].setIcon(iconPosibleMove);
                    panecenter.add(b[i][j]);
                    System.out.println("running");
                }
            }
    }


}