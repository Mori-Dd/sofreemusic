package com.example.sofreemusic;

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
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private List<SfMusic> sfMusicList = new ArrayList<>();
    private ImageButton navbn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSfMusic();

      //  RecyclerView recyclerView = (RecyclerView)findViewById(R.id.fab);
     //   LinearLayoutManager manager = new LinearLayoutManager(this);
      //  recyclerView.setLayoutManager(manager);
      //  SfMusicAdapter adapter = new SfMusicAdapter(sfMusicList);
     //   recyclerView.setAdapter(adapter);

        navbn = (ImageButton)findViewById(R.id.nav_bn);
        navbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        FrameLayout root = (FrameLayout) findViewById(R.id.root);
        final DrawView drawView = new DrawView(MainActivity.this);
        drawView.setMinimumWidth(300);
        drawView.setMinimumHeight(500);
        root.addView(drawView);

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);//获取实例
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);//获取实例
        navigationView.setCheckedItem(R.id.nav_birds);//设置Call菜单项为默认选中项
       navigationView.setBackgroundColor(Color.WHITE);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {//设置任意菜单点击事件
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();//关闭滑动菜单
                return true;
            }
        });


    }
    private void initSfMusic(){
        SfMusic bird = new SfMusic("bird",R.drawable.nav_bird);
    }
}
