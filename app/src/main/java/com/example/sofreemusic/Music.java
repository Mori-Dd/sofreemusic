package com.example.sofreemusic;

import android.widget.ImageView;
/**
 * Created by lgh on 2017/3/17.
 */

public class Music {
    private int musicImageId;
    private int musicResultId;

    public int getMusicImageId() {
        return musicImageId;
    }

    public void setMusicImageId(int musicImageId) {
        this.musicImageId = musicImageId;
    }

    public int getMusicResultId() {
        return musicResultId;
    }

    public void setMusicResultId(int musicResultId) {
        this.musicResultId = musicResultId;
    }



    public Music(int musicImageId, int musicResultId) {
        this.musicImageId = musicImageId;
        this.musicResultId = musicResultId;
    }

    private void initMusic(){
        Music circleImage = new Music(R.id.circle_image,11);
        Music musicImage1 = new Music(R.id.music_image1,1);
        Music musicImage2 = new Music(R.id.music_image2,2);
        Music musicImage3 = new Music(R.id.music_image3,3);
        Music musicImage4 = new Music(R.id.music_image4,4);

    }
}
