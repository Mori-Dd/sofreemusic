package com.example.sofreemusic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lgh on 2017/3/15.
 */

public class DrawView extends View{
    public float currentX = 300;
    public float currentY = 300;
    //定义并创建画笔
    Paint p = new Paint();
    Paint pp = new Paint();
    public DrawView (Context context){
        super(context);
    }
    public DrawView(Context context, AttributeSet set){
        super(context,set);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔颜色
        p.setColor(Color.WHITE);
        pp.setColor(Color.BLACK);
        //绘制一个小圆
        canvas.drawCircle(currentX,currentY,100,p);
        canvas.drawCircle(currentX,currentY,70,pp);
    }
    //为该组件的触碰事件重写事件处理方法

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getX()>=currentX-100& event.getX()<=currentX+100 && event.getY()>=currentY-100& event.getY()<=currentY+100) {
            currentX = event.getX();
            currentY = event.getY();
        invalidate();
        }
        return true;
    }
}
