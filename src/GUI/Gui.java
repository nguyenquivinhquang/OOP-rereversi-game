package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MenuComponent.*;
import Audio.PlayingAudioFileTest;
import Core.*;

public class Gui extends JFrame {

    public PlayerVsPlayer playerVsPlayer = PlayerVsPlayer.getInstance();
    public PlayervsBot playervsBot = PlayervsBot.getInstance();
    PlayingAudioFileTest music;
    int curplay = 0; // 1 is bot, 2 is player
    JMenuBar menuBar = new JMenuBar();
    JMenu gameOptionsMenu = new JMenu(" Game options");
    JMenu musicMenu = new JMenu("Music options");
    JMenu mainMenu = new JMenu("Menu");
    JMenuItem exitJMenu = new JMenuItem("Exits");
    JMenuItem newGameJMenu = new JMenuItem("New Games");
    JMenuItem playMusic = new JMenuItem("Play");
    JMenuItem stopMusic = new JMenuItem("Stop");
    JMenuItem backToMenu = new JMenuItem("Back to Menu");
    public Gui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Parameter.logo));
        setTitle("Reversi");

        music = PlayingAudioFileTest.getInstance();

        setMenu();
        setSize(1000, 700);
        setVisible(true);
    }

    public void startPlayervsPlayer() {
        curplay = 2;
        add(playerVsPlayer.render);
        playerVsPlayer.running();
        music.resumeMusic();

    }

    public void startPlayervsBot() {
        curplay = 1;
        add(playervsBot.render);
        playervsBot.running();
        music.resumeMusic();
    }

    private void setNewGameJMenu() {
        newGameJMenu.addActionListener(e -> {
            if (curplay == 2)
                playerVsPlayer.newGame();
            else playervsBot.newGame();

            music.resumeMusic();
            System.out.println("new Game");
        });
    }

    private void setBackToMenu() {
        backToMenu.addActionListener(e -> {
            MenuView.instance.setVisible(true);
            this.dispose();
            music.extMusic();
        });
    }

    private void setStopMusic() {
        stopMusic.addActionListener(e -> music.pauseMusic());
    }

    private void setPlayMusic() {
        playMusic.addActionListener(e -> music.playMusic());
    }
    private void setExitJMenu() {
        exitJMenu.addActionListener(e -> System.exit(0));
    }
    private void setMenu() {
        menuBar.add(gameOptionsMenu);
        menuBar.add(musicMenu);
        menuBar.add(mainMenu);
        menuBar.setBackground(Color.yellow);

        setJMenuBar(menuBar);

        mainMenu.add(backToMenu);

        gameOptionsMenu.add(newGameJMenu);
        gameOptionsMenu.add(exitJMenu);

        setBackToMenu();
        setExitJMenu();
        setNewGameJMenu();
        setPlayMusic();
        setStopMusic();


        musicMenu.add(playMusic);
        musicMenu.add(stopMusic);
    }

    public static void newGamePlayervsPlayer() {
        Gui gui = new Gui();
        gui.startPlayervsPlayer();
    }

    public static void newGamePlayervsBot() {
        Gui gui = new Gui();
        gui.startPlayervsBot();
    }

}
