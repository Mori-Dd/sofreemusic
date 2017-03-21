package com.example.sofreemusic;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.media.AudioManager;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.sofreemusic.MainActivity;

/**
 * Created by lgh on 2017/3/17.
 */

public class OnTouchUntil {
    private RelativeLayout relativeLayout;
    private Snackbar snackbar;
    private  int screenWidth;
    private int screenHeight;
    private ImageView imageView;
    private int circleX;//圆环X轴距离
    private int circleY;//圆环Y轴距离
    private int imageX;//图片X轴距离
    private int imageY;//图片Y轴距离
    private Context context;


    public OnTouchUntil(Context context,ImageView imageView) {
        this.context = context;
        this.imageView = imageView;
    }

    public void setMoveImage1(Context context, ImageView imageView) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels - 50;
        imageView.setOnTouchListener(movingEventListener1);
    }
    public void setMoveImage2(Context context, ImageView imageView) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels - 50;
        imageView.setOnTouchListener(movingEventListener2);
    }

    //图片的拖动效果
    View.OnTouchListener movingEventListener1 = new View.OnTouchListener() {
        int lastX, lastY;
        float xDown, yDown;
        boolean isLongClickModule = false;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    xDown = event.getRawX();
                    yDown = event.getRawY();

                    lastX = (int) event.getRawX();
                    lastY = (int) event.getRawY();
                    imageX = (int) event.getRawX();
                    imageY = (int) event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    //判断图片与圆环距离
                    if (imageX-circleX> 0 & imageY-circleY>0) {

                    }else{

                    }



                    //判断是否为长按
                    isLongClickModule = isLongPressed(xDown, yDown, event.getRawX(),
                            event.getRawY(), event.getDownTime(), event.getEventTime(), 1000);

                    if (isLongClickModule) {
                        //处理长按事件

                       snackbar =  Snackbar.make(imageView, "要删除这个音乐吗？", Snackbar.LENGTH_INDEFINITE).setAction("是的", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                MusicList.stopPlayer();
                                imageView.setVisibility(View.GONE);
                            }
                        });
                        snackbar.show();

                    } else {
                        //其他模式
                      
                    }

                    //设置图片拖动效果
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

    //判断是否长按
    private boolean isLongPressed(float lastX, float lastY, float thisX, float thisY,
                                  long lastDownTime, long thisEventTime, long longPressTime) {
        float offsetX = Math.abs(thisX - lastX);
        float offsetY = Math.abs(thisY - lastY);
        long intervalTime = thisEventTime - lastDownTime;
        if (offsetX <= 30 && offsetY <= 30 && intervalTime >= longPressTime) {
            return true;
        }
        return false;
    }
    //圆环的拖动效果
    View.OnTouchListener movingEventListener2 = new View.OnTouchListener() {
        int lastX, lastY;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:

                    lastX = (int) event.getRawX();
                    lastY = (int) event.getRawY();
                    circleX = (int) event.getRawX();
                    circleY= (int) event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:

                    //设置图片拖动效果


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
}

