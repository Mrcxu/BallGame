package com.wzbc.ballgame;

import java.io.File;
import java.net.URI;
import java.net.URL;

public class Music {
    File f;
    URI uri;
    URL url;
    public Music() {
        try {
//            f = new File("music\\1.wav");
//            uri = f.toURI();
//            url = uri.toURL();
//            AudioClip Sound = Applet.newAudioClip(url);
//            Sound.loop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
