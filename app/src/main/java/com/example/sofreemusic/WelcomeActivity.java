package com.example.sofreemusic;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;


public class WelcomeActivity extends BaseActivity {

    // 声明控件对象
    private LinearLayout linearLayout;
    private TextView textView;
    private int count = 3;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //控件初始化
        linearLayout = (LinearLayout)findViewById(R.id.pass_layout);
        textView = (TextView)findViewById(R.id.textView);
        animation = AnimationUtils.loadAnimation(this,R.anim.animation_text);
        handler_pass.sendEmptyMessageDelayed(0,1000);

    }
    //设置倒计时0时跳转主界面
    private int getCount() {
        count--;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                count = 0;
            }
        });
        if (count == 0 ) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return count;
    }

    private Handler handler_pass = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                textView.setText(" "+getCount()+"");
                handler_pass.sendEmptyMessageDelayed(0,1000);
                animation.reset();
                textView.startAnimation(animation);
            }
        }
    };
    private boolean isclicked(){
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return true;
    }
}
