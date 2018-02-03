package com.example.asus.onequickly.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.MoviesBean;
import com.example.asus.onequickly.model.bean.MoviesNearbyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gq on 2018/1/29.
 */


//
public class MyMoviesNearbyAdapter  extends RecyclerView.Adapter<MyMoviesNearbyAdapter.ViewHolder> {

    Context context;
    MoviesNearbyBean moviesNearbyBean;

    public MyMoviesNearbyAdapter(Context context, MoviesNearbyBean moviesNearbyBean) {
        this.moviesNearbyBean = moviesNearbyBean;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout. moviesnearbyitem02, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String cover = moviesNearbyBean.getData().get(position).getCover();

        Log.i("+++++++",cover.toString());

             holder.mNearbySimpleDraweeView02.setImageURI(moviesNearbyBean.getData().get(position).getCover());
             holder.text001.setText(moviesNearbyBean.getData().get(position).getCreateTime());

      }

    @Override
    public int getItemCount() {

        return moviesNearbyBean.getData()==null ? 0 :moviesNearbyBean.getData().size();


    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.NearbySimpleDraweeView02)
        SimpleDraweeView mNearbySimpleDraweeView02;
        private final TextView text001;
        ViewHolder(View view){
            super(view);

            text001 = view.findViewById(R.id.text001);

            ButterKnife.bind(this, view);
        }
    }
}
