package Audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.File;

public class PlayingAudioFileTest {
    long musicCurrentTime;
    Clip music;


    AudioInputStream musicInput;
    public static String filePath = "Audio/perry.wav";

    public PlayingAudioFileTest() {
        try {
            musicInput = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        try {
            music = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            music.open(musicInput);
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
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
