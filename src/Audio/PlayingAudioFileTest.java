package Audio;

import GUI.Parameter;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.File;

public class PlayingAudioFileTest {
    long musicCurrentTime;
    Clip music;


    AudioInputStream musicInput;
    public static String filePath = Parameter.music;

    public PlayingAudioFileTest() {
        try {
            musicInput = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            music = AudioSystem.getClip();
            music.open(musicInput);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in Music");
        }

        music.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void playMusic() {
        music.start();
        music.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void pauseMusic() {
        this.musicCurrentTime = this.music.getMicrosecondPosition();
        music.stop();
    }

    public void resumeMusic()  {

        music.setMicrosecondPosition(musicCurrentTime);
        this.playMusic();
    }

}
