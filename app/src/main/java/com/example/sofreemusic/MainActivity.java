package com.example.sofreemusic;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageButton navbn;
    private ImageView musicImage1;
    private ImageView musicImage2;
    private ImageView musicImage3;
    private ImageView musicImage4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        musicImage1 = (ImageView)findViewById(R.id.music_image1);
        musicImage2 = (ImageView)findViewById(R.id.music_image2);
        musicImage3 = (ImageView)findViewById(R.id.music_image3);
        musicImage4 = (ImageView)findViewById(R.id.music_image4);
        navbn = (ImageButton)findViewById(R.id.nav_bn);
        navbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SfMusicList.class);
                startActivityForResult(intent,1);
            }
        });
        //画圆环
        final DrawView drawView = new DrawView(MainActivity.this);
        drawView.setMinimumWidth(300);
        drawView.setMinimumHeight(500);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == 1) {
                    musicImage1.setImageResource(R.drawable.bird_im);
                    musicImage1.setVisibility(View.VISIBLE);
                    Log.d("MainActivity", "onActivityResult: ");
                } else if (resultCode == 2) {
                    musicImage2.setImageResource(R.drawable.rain_im);
                    musicImage2.setVisibility(View.VISIBLE);
                }else if (resultCode == 3) {
                    musicImage3.setImageResource(R.drawable.wind_im);
                    musicImage3.setVisibility(View.VISIBLE);
                }else if (resultCode == 4) {
                    musicImage4.setImageResource(R.drawable.fire_im);
                    musicImage4.setVisibility(View.VISIBLE);
                }
        }
    }

}
