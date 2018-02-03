package com.example.asus.onequickly.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asus.onequickly.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gq on 2018/2/3.
 */

public class MyPhotosAdapter  extends RecyclerView.Adapter<MyPhotosAdapter.ViewHolder>{

    Context context;
    List<Integer> list;


    public MyPhotosAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.photoitem03, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
           holder.mPhotoImage.setImageResource(list.get(position));

    }
    @Override
    public int getItemCount() {
          //return list.size();
        return list == null ? 0 : list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.photoImage)
        ImageView mPhotoImage;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
