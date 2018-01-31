package com.example.asus.onequickly.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.BannerBean;
import com.example.asus.onequickly.utils.app.FrescoApplication;
import com.example.asus.onequickly.utils.otherutils.FrescoImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win on 2018/1/30.
 */

public class RecommendHotRlvAdapter extends RecyclerView.Adapter {

    private static int BANNER_TYPE = 0;//轮播
    private static int LIST_TYPE = 1;//列表

    private Context mContext;
    private List<BannerBean.DataBean> lists;
    private ArrayList<String> icons;

    public RecommendHotRlvAdapter() {

        mContext = FrescoApplication.getContext();
        icons = new ArrayList<>();

    }

    //拿到本地音乐数据
    public void getBannerData(List<BannerBean.DataBean> list) {
        if (list != null) {
            this.lists = list;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == BANNER_TYPE) {
            return new HotViewHolder(LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_banner_rlv_item, parent, false));
        } else {
            return new HotListViewHolder(LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_rlv_list_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HotViewHolder) {

            HotViewHolder hotViewHolder = (HotViewHolder) holder;

            for (int i = 0; i < lists.size(); i++) {
                String icon = lists.get(position).getIcon();
                icons.add(icon);
            }
            //设置图片集合
            hotViewHolder.bannerImg.setImages(icons);
            //设置图片加载器
            hotViewHolder.bannerImg.setImageLoader(new FrescoImageLoader());
            //banner设置方法全部调用完毕时最后调用
            hotViewHolder.bannerImg.start();

        }
        if (holder instanceof HotListViewHolder) {

        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position == BANNER_TYPE) {
            return BANNER_TYPE;
        } else {
            return LIST_TYPE;
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    static class HotViewHolder extends RecyclerView.ViewHolder {


        private final Banner bannerImg;

        HotViewHolder(View itemView) {

            super(itemView);

            bannerImg = itemView.findViewById(R.id.banner_img);
        }
    }

    static class HotListViewHolder extends RecyclerView.ViewHolder {


        HotListViewHolder(View itemView) {

            super(itemView);

        }
    }

}
