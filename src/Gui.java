import javax.swing.*;
import java.awt.*;
import Audio.PlayingAudioFileTest;
import Core.*;
import GUI.*;

public class Gui extends JFrame {


    PlayerVsPlayer playerVsPlayer = PlayerVsPlayer.getInstance();
    PlayervsBot playervsBot = PlayervsBot.getInstance();

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
        setTitle("Reversi");

        music = new PlayingAudioFileTest();

        setMenu();
        this.setSize(1000, 700);
        this.setVisible(true);
}

    public void startPlayervsPlayer() {
        this.add(playerVsPlayer.render);
        playerVsPlayer.actionGame();
//        playerVsPlayer.render.repaint();
    }

    public void startPlayervsBot() {
        this.add(playervsBot);
        playervsBot.actionGame();
    }
    public void newGameAction() {
        newGameJMenu.addActionListener(e -> {
            playerVsPlayer.resetArray();
            playerVsPlayer.render.repaint();
            music.resumeMusic();
            System.out.println("new Game");
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
        gui.startPlayervsPlayer();

    }
}
