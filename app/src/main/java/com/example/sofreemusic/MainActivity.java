package com.example.sofreemusic;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * sofreemusic
 * version 1.0
 * Author Lgh
 * date:2017/3/14
 */

public class MainActivity extends BaseActivity {
    private List<ImageView> imageViewList = new ArrayList<>();
    private  OnTouchUntil onTouchUntil;
    private static final String TAG = "MainActivity";
    private ImageButton navbn;
    private ImageView circleImage;
    private ImageView musicImage1;
    private ImageView musicImage2;
    private ImageView musicImage3;
    private ImageView musicImage4;


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

        onTouchUntil =  new OnTouchUntil(MainActivity.this,circleImage);
        onTouchUntil.setMoveImage2(MainActivity.this,circleImage);//圆环拖动效果

        for (final ImageView imageView : imageViewList) {
            onTouchUntil =  new OnTouchUntil(MainActivity.this,imageView);
            onTouchUntil.setMoveImage1(MainActivity.this,imageView);//音乐图片拖动效果
        }

        //菜单按钮
        navbn = (ImageButton) findViewById(R.id.nav_bn);
        navbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MusicMenu.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    //判断用户添加了哪一个音乐
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int index = resultCode-1;//定义数组下标
        switch (requestCode) {
            case 1:
                List resList = new ArrayList<>();
                resList.add(resultCode);
                for (int i = 0; i < resList.size(); i++) {
                    if (resultCode == 11) {
                        for (ImageView imageview : imageViewList) {
                            imageview.setVisibility(View.GONE);
                            MusicList.stopPlayer();
                        }
                    } else {
                        for (final ImageView imageView : imageViewList) {
                            if (index == imageViewList.indexOf(imageView)) {
                                if (imageView.getVisibility() == View.GONE) {
                                    imageView.setVisibility(View.VISIBLE);
                                    MusicList.setMediaPlayer(this, index);
                                } else {
                                    Toast.makeText(MainActivity.this, "已添加过此音乐", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    //退出提示
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            AlertDialog.Builder dialogBack = new AlertDialog.Builder(this);
            dialogBack.setTitle("真的不听了吗？");
            dialogBack.setMessage("如果您想要后台听音乐，请按Home键，否则将无法继续为您播放美妙的音乐！");
            dialogBack.setCancelable(true);
            dialogBack.setPositiveButton("确定退出", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityCollector.finishAll();
                }
            });
            dialogBack.setNegativeButton("继续享受", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dialogBack.show();
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        MusicList.stopPlayer();
    }
}
