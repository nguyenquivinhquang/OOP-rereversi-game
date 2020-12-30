import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Audio.PlayingAudioFileTest;
import GUI.*;
public class Gui extends JFrame {
    public Timer t_game;

    ArrayList<Coordinate> coor = new ArrayList<Coordinate>();
    Render render;
//    PlayerVsPlayer playerVsPlayer = PlayerVsPlayer.getInstance();

    PlayingAudioFileTest music;

    JMenuBar menuBar = new JMenuBar();
    JMenu gameOptionsMenu = new JMenu(" Game options");
    JMenu musicMenu = new JMenu("Music options");

    JMenuItem exitJMenu = new JMenuItem("Exits");
    JMenuItem newGameJMenu = new JMenuItem("New Games");
    JMenuItem playMusic = new JMenuItem("Play");
    JMenuItem stopMusic = new JMenuItem("Stop");

    public Gui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Parameter.logo));

        render = new Render();
//        music = new PlayingAudioFileTest();
//        playerVsPlayer = PlayerVsPlayer.getInstance();
//        render.addMouseListener(playerVsPlayer);
//        frame.add(render);
//        frame.removeMouseListener(playerVsPlayer);
        setMenu();
        this.setSize(1000, 700);
        this.setVisible(true);
    }

    public void newGameAction() {
        newGameJMenu.addActionListener(e -> {
//            playerVsPlayer.resetArray();
            music.resumeMusic();
        });
    }

    private void setMenu() {
        menuBar.add(gameOptionsMenu);
        menuBar.add(musicMenu);
        menuBar.setBackground(Color.yellow);
        this.setJMenuBar(menuBar);

        gameOptionsMenu.add(newGameJMenu);
        gameOptionsMenu.add(exitJMenu);
        exitJMenu.addActionListener(e -> this.dispose());
        newGameAction();


        playMusic.addActionListener(e -> music.playMusic());

        stopMusic.addActionListener(e -> music.pauseMusic());
        musicMenu.add(playMusic);
        musicMenu.add(stopMusic);
    }







    public static void main(String[] args) {
        Gui gui = new Gui();

    }
}
