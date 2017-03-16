package com.example.sofreemusic;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by lgh on 2017/3/16.
 */

public class MusicList {
    private final static int  sounds[] = {R.raw.bird,R.raw.rain,R.raw.wind,R.raw.fire};
    private  static MediaPlayer mediaPlayer = new MediaPlayer();
    public static void setMediaPlayer(Context context,int id){

        if (mediaPlayer.isPlaying()) {
            mediaPlayer.reset();
            mediaPlayer = MediaPlayer.create(context,sounds[id]);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }else{
            mediaPlayer = MediaPlayer.create(context,sounds[id]);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
    }
    public static void stopPlayer(){

            mediaPlayer.stop();
    }
}
