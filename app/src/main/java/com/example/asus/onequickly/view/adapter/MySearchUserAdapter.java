package com.example.asus.onequickly.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.FollowSuccessBean;
import com.example.asus.onequickly.model.bean.SearchUserBean;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.activity.SearchUserActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/2/2.
 */

public class MySearchUserAdapter extends RecyclerView.Adapter<MySearchUserAdapter.MySearchUsearholder> {
    Context context;
    SearchUserBean bean;
    String token;
    int uid;

    public MySearchUserAdapter(Context context) {
        this.context = context;
    }
    public void getUsearBean(SearchUserBean bean, String token, int uid){
        this.bean = bean;
        this.token = token;
        this.uid = uid;
    }

    @Override
    public MySearchUsearholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.search_user_layout, null);

        return new MySearchUsearholder(view);
    }

    @Override
    public void onBindViewHolder(MySearchUsearholder holder, final int position) {
    holder.searchUsearIcon.setImageURI(bean.getData().get(position).getIcon());
    //点击关注时的操作
    holder.searchUserFollow.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            /**
             * https://www.zhaoapi.cn/quarter/follow?
             * appVersion=101&source=android
             * &uid=11850&
             * followId=983&
             * token=F3768ABA31902C1D56B60F25708B9BCD
             */
            Map<String,String> map=new HashMap<>();
            map.put("uid",uid+"");
            map.put("followId",bean.getData().get(position).getUid()+"");
            map.put("token",token);

            APIFactory.getInstance().get("quarter/follow", map, new AbstractObserver<FollowSuccessBean>() {
                @Override
                public void onSuccess(FollowSuccessBean followSuccessBean) {
                    Toast.makeText(context,followSuccessBean.getMsg(),Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onFailure(int code) {

                }
            });

        }
    });
        holder.searchUserName.setText(bean.getData().get(position).getNickname());


        holder.searchUserQm.setText("暂无");

    }

    @Override
    public int getItemCount() {
        return bean.getData() == null ? 0 : bean.getData().size();
    }

    public class MySearchUsearholder extends RecyclerView.ViewHolder {
        @BindView(R.id.search_usear_icon)
        SimpleDraweeView searchUsearIcon;
        @BindView(R.id.search_user_name)
        TextView searchUserName;
        @BindView(R.id.search_user_qm)
        TextView searchUserQm;
        @BindView(R.id.search_user_follow)
        Button searchUserFollow;
        public MySearchUsearholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
