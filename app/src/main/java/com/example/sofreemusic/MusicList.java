package com.example.sofreemusic;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

/**音频播放器
 * Created by lgh on 2017/3/16.
 */

public class MusicList {
    private final static int  sounds[] = {R.raw.bird,R.raw.rain,R.raw.wind,R.raw.fire};
    private static List<MediaPlayer> mediaPlayerList = new ArrayList<>();
    private  static MediaPlayer mediaPlayer = new MediaPlayer();
    public static void setMediaPlayer(Context context,int id){
        mediaPlayer = MediaPlayer.create(context,sounds[id]);
        mediaPlayerList.add(mediaPlayer);
        for (MediaPlayer mediaPlayer:mediaPlayerList) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
    }
    public static void stopPlayer(){
        for (MediaPlayer mediaPlayer: mediaPlayerList) {
            mediaPlayer.stop();
        }
    }
}
