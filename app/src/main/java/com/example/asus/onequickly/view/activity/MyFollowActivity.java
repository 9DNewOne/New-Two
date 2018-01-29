package com.example.asus.onequickly.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.FollowListBean;
import com.example.asus.onequickly.presenter.httppresenter.MyFollowListPresenter;
import com.example.asus.onequickly.view.adapter.MyFollowListAdatper;
import com.example.asus.onequickly.view.viewcallback.IFollowListView;
//提供了用户关注列表的activity
public class MyFollowActivity extends BaseActivity<IFollowListView,MyFollowListPresenter>implements IFollowListView {
    LinearLayout follow_yes;
    LinearLayout follow_empty;
    RecyclerView follow_recycler;
    @Override
    public MyFollowListPresenter addpresenter() {
        return new MyFollowListPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_follow);

        //当没有数据该显示的布局

        follow_empty = findViewById(R.id.follow_empty);
        //当有数据时显示的布局

        follow_recycler = findViewById(R.id.follow_recycler);
        follow_yes = findViewById(R.id.follow_yes);
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        //从sp取出的数据
        String token = sp.getString("token", "");
        int uid = sp.getInt("uid", 0);
        boolean islogin=sp.getBoolean("Islogin",false);
        Log.i("++++++++", "onCreate: "+token+uid+islogin);
        if(token.equals("")&&uid==0&&islogin==false){
            Toast.makeText(MyFollowActivity.this,"您尚未登录，请先登录",Toast.LENGTH_SHORT).show();
            finish();
        }else{
            //调用presenter方法 得到列表数据
            presenter.getfllowlistdatanow(token,uid+"");
            //设置布局管理器
            follow_recycler.setLayoutManager(new LinearLayoutManager(MyFollowActivity.this));
            //添加分割线
            follow_recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        }


    }

    @Override
    public void showFollowList(FollowListBean bean) {
        //当没数据时
        if(bean.getData().size()==0){
            follow_empty.setVisibility(View.VISIBLE);
            follow_yes.setVisibility(View.GONE);
        }else{
            //当有数据时
            follow_yes.setVisibility(View.VISIBLE);
            follow_empty.setVisibility(View.GONE);
            //设置适配器
            follow_recycler.setAdapter(new MyFollowListAdatper(MyFollowActivity.this,bean));

        }
    }
}
