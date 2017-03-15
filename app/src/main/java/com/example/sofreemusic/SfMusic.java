package com.example.sofreemusic;

/**
 * Created by lgh on 2017/3/15.
 */

public class SfMusic {
    private String name;
    private int imageId;

    public SfMusic(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
