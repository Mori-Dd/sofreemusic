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
    int[] id = {R.id.nav_bird,R.id.nav_rain,R.id.nav_wind,R.id.nav_fire};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sf_music_list);

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);//获取菜单实例
       // navigationView.setCheckedItem(R.id.nav_bird);//设置Call菜单项为默认选中项
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {//设置任意菜单点击事件
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                for (int i = 0;i<id.length;i++) {
                    if (item.getItemId() == id[i]) {
                        Intent intent = new Intent();
                        setResult(i+1,intent);
                        finish();
                    }
                }
                return true;
            }
        });
    }
}
