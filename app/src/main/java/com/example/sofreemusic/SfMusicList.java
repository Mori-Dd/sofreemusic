package com.example.sofreemusic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class SfMusicList extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sf_music_list);

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);//获取菜单实例
       // navigationView.setCheckedItem(R.id.nav_bird);//设置Call菜单项为默认选中项
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {//设置任意菜单点击事件
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_bird:
                        Intent birdintent = new Intent();
                        setResult(1,birdintent);
                    finish();
                        break;
                    case R.id.nav_rain:
                        Intent rainintent = new Intent();
                        setResult(2,rainintent);
                        finish();
                        break;
                    case R.id.nav_wind:
                        Intent windintent = new Intent();
                        setResult(3,windintent);
                        finish();
                        break;
                    case R.id.nav_fire:
                        Intent fireintent = new Intent();
                        setResult(4,fireintent);
                        finish();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }
}
