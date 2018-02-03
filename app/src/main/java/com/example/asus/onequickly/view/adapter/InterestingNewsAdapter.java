package com.example.asus.onequickly.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.utils.app.FrescoApplication;

/**
 * Created by win on 2018/2/2.
 */

public class InterestingNewsAdapter extends RecyclerView.Adapter {

    private final Context mContext;

    public InterestingNewsAdapter() {
        mContext = FrescoApplication.getContext();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new InterestingNewsAdapter.InterestingNewsViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.layout_interestingnews_item, parent, false));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        InterestingNewsViewHolder iNewViewHolder= (InterestingNewsViewHolder) holder;

    }

    @Override
    public int getItemCount() {
        return 10;
    }
    static class InterestingNewsViewHolder extends RecyclerView.ViewHolder{

        public InterestingNewsViewHolder(View itemView) {
            super(itemView);
        }
    }
}
