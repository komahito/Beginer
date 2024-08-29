package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;
import java.net.URI;

public class Sound {
    Clip clip;
    URL[] soundURL = new URL[30];

    public Sound () {
        try{
            soundURL[0] = new File(Property.res + "/sound/BlueBoyAdventure.wav").toURI().toURL();
            soundURL[1] = new File(Property.res + "/sound/coin.wav").toURI().toURL();
            soundURL[2] = new File(Property.res + "/sound/fanfare.wav").toURI().toURL();
            soundURL[3] = new File(Property.res + "/sound/powerup.wav").toURI().toURL();
            soundURL[4] = new File(Property.res + "/sound/unlock.wav").toURI().toURL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            if (ais == null) {System.err.println("ais(soundFile[" + i + "]) is null");}
            clip = AudioSystem.getClip();
            clip.open(ais);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play () {
        clip.start();
    }

    public void loop () {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop () {
        clip.stop();
    }
}
