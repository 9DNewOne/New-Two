package com.example.asus.onequickly.view.adapter;


import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.MoviesBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;


/**
 * Created by gq on 2018/1/29.
 */
public class MyMoviesHotAdapter extends RecyclerView.Adapter<MyMoviesHotAdapter.ViewHolder> {

    Context context;
   // MoviesBean moviesBean;
    List<String> list;
   /* public MyMoviesHotAdapter(Context context, MoviesBean moviesBean) {
        this.context = context;
        this.moviesBean = moviesBean;

    }*/

    public MyMoviesHotAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.movieshotitem01, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

       /*   Log.i("--------",moviesBean.getData().get(position).getCreateTime());
          Log.i("--------",moviesBean.getData().get(position).getVideoUrl());
          Log.i("--------",moviesBean.getData().get(position).getCover());
       */

     /*   holder.videoplayer.setUp(moviesBean.getData().get(position).getVideoUrl()
                , JZVideoPlayer.SCREEN_WINDOW_NORMAL, "今日热点");

        Glide.with(context)
                .load(moviesBean.getData().get(position).getCover())
                .into(holder.videoplayer.thumbImageView);
*/

                 holder.videoplayer.setUp(list.get(position),JZVideoPlayer.SCREEN_WINDOW_NORMAL, "今日热点");



    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
       // return moviesBean.getData() == null ? 0 : moviesBean.getData().size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simple_player_view_player)
        JZVideoPlayerStandard videoplayer;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
