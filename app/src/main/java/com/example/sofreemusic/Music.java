package com.example.sofreemusic;

import android.widget.ImageView;
/**
 * Created by lgh on 2017/3/17.
 */

public class Music {
    private String musicName;
    private int musicImageId;

    public Music(String musicName, int musicImageId) {
        this.musicName = musicName;
        this.musicImageId = musicImageId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public int getMusicImageId() {
        return musicImageId;
    }

    public void setMusicImageId(int musicImageId) {
        this.musicImageId = musicImageId;
    }
}
