package com.example.asus.onequickly.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.FollowListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/1/29.
 */
//我的关注适配器
public class MyFollowListAdatper extends RecyclerView.Adapter<MyFollowListAdatper.MyFollowHolder> {
    Context context;
    FollowListBean bean;


    public MyFollowListAdatper(Context context, FollowListBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public MyFollowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.my_followlist_layout, null);

        return new MyFollowHolder(view);
    }

    @Override
    public void onBindViewHolder(MyFollowHolder holder, int position) {
    holder.followCreatetime.setText(bean.getData().get(position).getCreatetime());
    holder.followDescription.setText("暂无");
    holder.followListIcon.setImageURI(bean.getData().get(position).getIcon()+"");
    holder.followName.setText(bean.getData().get(position).getUsername());

    }

    @Override
    public int getItemCount() {
        return bean.getData() == null ? 0 : bean.getData().size();
    }

    public class MyFollowHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.follow_list_icon)
        SimpleDraweeView followListIcon;
        @BindView(R.id.follow_name)
        TextView followName;
        @BindView(R.id.follow_description)
        TextView followDescription;
        @BindView(R.id.follow_createtime)
        TextView followCreatetime;
        public MyFollowHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
