package com.example.sofreemusic;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {
private List<ImageView> imageViewList = new ArrayList<>();

    private static final String TAG = "MainActivity";
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
        Log.d(TAG, "onCreate: ");
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


    @Override
    protected void onStart() {
        super.onStart();
     //   Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
     //   Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
     //   Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
      //  Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
     //   Log.d(TAG, "onRestart: ");
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
                    case 11:
                        for (ImageView imageview:imageViewList) {
                            imageview.setVisibility(View.GONE);
                        }
                        break;
                    case 1:
                        if (musicImage1.getVisibility() == View.GONE) {
                            musicImage1.setVisibility(View.VISIBLE);
                        }else {
                            Toast.makeText(MainActivity.this,"已添加过此音乐",Toast.LENGTH_SHORT).show();
                        }

                        Log.d(TAG, "1: ");
                        break;
                    case 2:
                        if (musicImage2.getVisibility() == View.GONE) {
                            musicImage2.setVisibility(View.VISIBLE);
                        }else {
                            Toast.makeText(MainActivity.this,"已添加过此音乐",Toast.LENGTH_SHORT).show();
                        }
                        Log.d(TAG, "2: ");
                        break;
                    case 3:
                        if (musicImage3.getVisibility() == View.GONE) {
                            musicImage3.setVisibility(View.VISIBLE);
                        }else {
                            Toast.makeText(MainActivity.this,"已添加过此音乐",Toast.LENGTH_SHORT).show();
                        }
                        Log.d(TAG, "3: ");
                        break;
                    case 4:
                        if (musicImage4.getVisibility() == View.GONE) {
                            musicImage4.setVisibility(View.VISIBLE);
                        }else {
                            Toast.makeText(MainActivity.this,"已添加过此音乐",Toast.LENGTH_SHORT).show();
                        }
                        Log.d(TAG, "4: ");
                        break;
                }
                break;
            default:
                break;
        }
    }
}
