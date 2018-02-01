package com.example.asus.onequickly.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.RandomFriendsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/1/31.
 */

public class MyHotFollowFineFoodListAdapter extends RecyclerView.Adapter<MyHotFollowFineFoodListAdapter.MyHotFollowFineFoodViewHolder> {
    Context context;
    RandomFriendsBean bean;

    public MyHotFollowFineFoodListAdapter(Context context, RandomFriendsBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public MyHotFollowFineFoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.hotfinefoodlist_layout, null);
        MyHotFollowFineFoodViewHolder holder=new MyHotFollowFineFoodViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHotFollowFineFoodViewHolder holder, int position) {
        //设置头像
       holder.hotFineFoodFollowListIcon.setImageURI(bean.getData().get(position).getIcon()+"");
       //设置用户名
        if(bean.getData().get(position).getNickname()==null||"".equals(bean.getData().get(position).getNickname())){
            holder.hotFoodFollowName.setText(bean.getData().get(position).getUsername());
        }else{
            holder.hotFoodFollowName.setText(bean.getData().get(position).getNickname()+"");
        }
        //设置签名
        holder.hotFoodFollowDescription.setText("暂无签名");
        //设置创建时间
        holder.hotFoodFollowCreatetime.setText(bean.getData().get(position).getCreatetime());


    }

    @Override
    public int getItemCount() {
        return bean.getData() == null ? 0 : bean.getData().size();
    }

    public class MyHotFollowFineFoodViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.hot_fine_food_follow_list_icon)
        SimpleDraweeView hotFineFoodFollowListIcon;
        @BindView(R.id.hot_food_follow_name)
        TextView hotFoodFollowName;
        @BindView(R.id.hot_food_follow_description)
        TextView hotFoodFollowDescription;
        @BindView(R.id.hot_food_follow_createtime)
        TextView hotFoodFollowCreatetime;

        public MyHotFollowFineFoodViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
