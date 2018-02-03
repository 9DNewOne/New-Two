package com.example.asus.onequickly.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.onequickly.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/2/3.
 */

public class MyProductionAdapter extends RecyclerView.Adapter<MyProductionAdapter.myproductionadholder> {
    Context context;
    List<String> list;


    public MyProductionAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public myproductionadholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.production_item_layout, null);
        myproductionadholder holder = new myproductionadholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(myproductionadholder holder, int position) {
    holder.myLocalSimpview.setImageURI(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class myproductionadholder extends RecyclerView.ViewHolder {
        @BindView(R.id.my_local_simpview)
        SimpleDraweeView myLocalSimpview;
        public myproductionadholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
