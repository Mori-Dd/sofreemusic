package com.example.sofreemusic;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 *
 */
public class MusicMenu extends BaseActivity implements View.OnClickListener{
    private ImageView close_image;
    private ImageView add_image;
    private ImageView delete_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_menu);
        close_image = (ImageView)findViewById(R.id.close_view);
        add_image = (ImageView)findViewById(R.id.add_view);
        delete_image = (ImageView)findViewById(R.id.delete_view);

        close_image.setOnClickListener(this);
        add_image.setOnClickListener(this);
        delete_image.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //结束本程序
            case R.id.close_view:
                AlertDialog.Builder dialogFinish = new AlertDialog.Builder(this);
                dialogFinish.setTitle("提示");
                dialogFinish.setMessage("是否退出程序?");
                dialogFinish.setCancelable(true);
                dialogFinish.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCollector.finishAll();
                    }
                });
                dialogFinish.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialogFinish.show();
                break;
            //添加音乐
            case R.id.add_view:
                Intent intent = new Intent(MusicMenu.this,SfMusicList.class);
                startActivityForResult(intent,1);
                break;
            //清空音乐
            case R.id.delete_view:
                AlertDialog.Builder dialogclear = new AlertDialog.Builder(this);
                dialogclear.setTitle("提示");
                dialogclear.setMessage("是否清空所有音乐?");
                dialogclear.setCancelable(true);
                dialogclear.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setResult(11);
                        finish();
                    }
                });
                dialogclear.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialogclear.show();
                break;
            default:
                break;
        }
    }

    //返回结果给MainActivity进行判断用户选择了哪个音乐
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                setResult(resultCode);
                finish();
                break;
            default:
                break;
        }
    }
}
