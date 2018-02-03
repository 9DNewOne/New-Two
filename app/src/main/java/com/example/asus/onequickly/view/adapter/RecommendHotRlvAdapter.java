package com.example.asus.onequickly.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.BannerBean;
import com.example.asus.onequickly.model.bean.ProductionBean;
import com.example.asus.onequickly.utils.app.FrescoApplication;
import com.example.asus.onequickly.utils.otherutils.FrescoImageLoader;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by win on 2018/1/30.
 */

public class RecommendHotRlvAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private static int BANNER_TYPE = 0;//轮播
    private static int LIST_TYPE = 1;//列表
    private Context mContext;
    private List<BannerBean.DataBean> lists;
    private List<String> icons;
    private List<ProductionBean.DataBean> data;

    public RecommendHotRlvAdapter() {

        mContext = FrescoApplication.getContext();
        icons = new ArrayList<>();
    }

    //拿到本地音乐数据
    public void getBannerData(List<BannerBean.DataBean> list) {
        if (list != null) {
            this.lists = list;
            for (int i = 0; i < lists.size(); i++) {
                String icon = lists.get(i).getIcon();
                icons.add(icon);
            }
        }
    }

    //拿到用户作品数据
    public void getProductionList(List<ProductionBean.DataBean> dataBeans) {
        if (dataBeans != null) {
            this.data = dataBeans;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == BANNER_TYPE) {
            return new HotViewHolder(LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_banner_rlv_item, parent, false));
        } else {
            View view = LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_rlv_list_item, parent, false);
            view.setOnClickListener(this);
            return new HotListViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HotViewHolder) {

            HotViewHolder hotViewHolder = (HotViewHolder) holder;

            //设置图片集合
            hotViewHolder.bannerImg.setImages(icons);
            //设置图片加载器
            hotViewHolder.bannerImg.setImageLoader(new FrescoImageLoader());
            //banner设置方法全部调用完毕时最后调用
            hotViewHolder.bannerImg.start();

        }
        if (holder instanceof HotListViewHolder) {
            HotListViewHolder listViewHolder = (HotListViewHolder) holder;

            if (data.get(position) != null) {

                listViewHolder.userIcon.setImageURI(data.get(position).getCover());//获取头像
                listViewHolder.posted_time.setText(data.get(position).getCreateTime());//发表时间

                listViewHolder.publishPlayer.setUp("http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4"
                        , JZVideoPlayerStandard.SCREEN_STATE_OFF);

//                /**
//                 * 播放器尺寸
//                 */
//                listViewHolder.publishPlayer.widthRatio = 4;//播放比例
//                listViewHolder.publishPlayer.heightRatio = 3;
                if (data.get(position).getUser().getNickname() != null) {
                    listViewHolder.userName.setText(String.valueOf(data.get(position).getUser().getNickname()));//用户名
                } else {
                    listViewHolder.userName.setText("用户名不存在");
                }
            }
            listViewHolder.itemView.setTag(position);//拿到条目位置
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
        return data == null ? 0 : data.size();
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {

            mOnItemClickListener.onItemClick(view, (Integer) view.getTag());
        }
    }


    static class HotViewHolder extends RecyclerView.ViewHolder {


        private final Banner bannerImg;

        HotViewHolder(View itemView) {

            super(itemView);

            bannerImg = itemView.findViewById(R.id.banner_img);
        }
    }

    static class HotListViewHolder extends RecyclerView.ViewHolder {


        private final SimpleDraweeView userIcon;
        private final TextView posted_time;
        private final TextView userName;
        private final JZVideoPlayerStandard publishPlayer;

        HotListViewHolder(View itemView) {
            super(itemView);

            userIcon = itemView.findViewById(R.id.rlv_list_userIcon);
            posted_time = itemView.findViewById(R.id.rlv_list_posted_time);
            userName = itemView.findViewById(R.id.rlv_list_userName);
            publishPlayer = itemView.findViewById(R.id.publish_Player);

        }
    }

    private onItemClickListener mOnItemClickListener = null;

    public interface onItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
