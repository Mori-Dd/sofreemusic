package com.example.sofreemusic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lgh on 2017/3/15.
 */

public class SfMusicAdapter extends RecyclerView.Adapter<SfMusicAdapter.ViewHolder>{
    private List<SfMusic> mSfMusicList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView sfMusicImage;
        TextView sfMusicName;
        public ViewHolder(View view){
            super(view);
            sfMusicImage = (ImageView)view.findViewById(R.id.sfMusicImage);
            sfMusicName =(TextView)view.findViewById(R.id.sfMusicName);
        }

    }

    public SfMusicAdapter(List<SfMusic> sfMusicList) {
        mSfMusicList = sfMusicList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sfmusic_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SfMusic sfMusic = mSfMusicList.get(position);
        holder.sfMusicImage.setImageResource(sfMusic.getImageId());
        holder.sfMusicName.setText(sfMusic.getName());

    }

    @Override
    public int getItemCount() {
        return mSfMusicList.size();
    }
}
