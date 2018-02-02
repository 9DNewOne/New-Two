package com.example.asus.onequickly.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.FollowSuccessBean;
import com.example.asus.onequickly.model.bean.SearchUserBean;
import com.example.asus.onequickly.presenter.httppresenter.MySearchUsearPresenter;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.adapter.MySearchUserAdapter;
import com.example.asus.onequickly.view.viewcallback.ISearchUserView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

//搜索好友activity
public class SearchUserActivity extends BaseActivity<ISearchUserView, MySearchUsearPresenter> implements ISearchUserView {

    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.search_change)
    TextView searchChange;
    @BindView(R.id.search_user_rv)
    RecyclerView searchUserRv;
    String token;
    int uid;
    @Override
    public MySearchUsearPresenter addpresenter() {
        return new MySearchUsearPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        ButterKnife.bind(this);

        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                Log.i("++++++++++++++", "SearchAciton: "+string);
                presenter.GetUserInfoNow(string,"0");
            }
        });

        // 5. 设置点击返回按键后的操作（通过回调接口）
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });
        LinearLayoutManager manager=new LinearLayoutManager(this);
        searchUserRv.setLayoutManager(manager);
        searchUserRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //从sharedpreferences中取出数据
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);

        token = sp.getString("token", "");


        uid = sp.getInt("uid", 0);


    }
//



    @Override
    public void getuserinfodata(final SearchUserBean bean) {
        MySearchUserAdapter adapter=new MySearchUserAdapter(this);
        adapter.getUsearBean(bean,token,uid);

        searchUserRv.setAdapter(adapter);

    }
}
