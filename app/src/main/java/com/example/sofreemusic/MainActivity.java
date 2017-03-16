package com.example.sofreemusic;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {
private List<ImageView> imageViewList = new ArrayList<>();

    private ImageButton navbn;
    private ImageView circleImage;
    private ImageView musicImage1;
    private ImageView musicImage2;
    private ImageView musicImage3;
    private ImageView musicImage4;

    private int screenWidth;
    private int screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleImage = (ImageView) findViewById(R.id.circle_image);
        musicImage1 = (ImageView) findViewById(R.id.music_image1);
        musicImage2 = (ImageView) findViewById(R.id.music_image2);
        musicImage3 = (ImageView) findViewById(R.id.music_image3);
        musicImage4 = (ImageView) findViewById(R.id.music_image4);


        imageViewList.add(musicImage1);
        imageViewList.add(musicImage2);
        imageViewList.add(musicImage3);
        imageViewList.add(musicImage4);

        //托动图片效果
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels - 50;
        circleImage.setOnTouchListener(movingEventListener);
        for (ImageView imageView:imageViewList) {
            imageView.setOnTouchListener(movingEventListener);
        }


        navbn = (ImageButton) findViewById(R.id.nav_bn);
        navbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this,MusicMenu.class);
                startActivityForResult(intent,1);
            }
        });
    }
    //托动图片
    private View.OnTouchListener movingEventListener = new View.OnTouchListener() {
        int lastX, lastY;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    lastX = (int) event.getRawX();
                    lastY = (int) event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    int dx = (int) event.getRawX() - lastX;
                    int dy = (int) event.getRawY() - lastY;

                    int left = v.getLeft() + dx;
                    int top = v.getTop() + dy;
                    int right = v.getRight() + dx;
                    int bottom = v.getBottom() + dy;// 设置不能出界
                    if (left < 0) {
                        left = 0;
                        right = left + v.getWidth();
                    }
                    if (right > screenWidth) {
                        right = screenWidth;
                        left = right - v.getWidth();
                    }
                    if (top < 0) {
                        top = 0;
                        bottom = top + v.getHeight();
                    }
                    if (bottom > screenHeight) {
                        bottom = screenHeight;
                        top = bottom - v.getHeight();
                    }
                    v.layout(left, top, right, bottom);
                    lastX = (int) event.getRawX();
                    lastY = (int) event.getRawY();
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                switch (resultCode) {
                    case 0:
                        for (ImageView imageview:imageViewList) {
                            imageview.setVisibility(View.GONE);
                        }
                        break;
                    case 1:
                        musicImage1.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        musicImage2.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        musicImage3.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        musicImage4.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            default:
                break;
        }
    }
}
