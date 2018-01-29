package com.example.asus.onequickly.presenter.httppresenter;

import android.content.Context;
import android.util.Log;

import com.example.asus.onequickly.model.bean.FollowListBean;
import com.example.asus.onequickly.model.http.HttpFllowListModel;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.viewcallback.IFollowListView;

/**
 * Created by asus on 2018/1/28.
 */
//提供用户关注列表presenter
public class MyFollowListPresenter extends BasePresenter<IFollowListView> {
    HttpFllowListModel model;
    Context context;

    public MyFollowListPresenter(Context context) {
        this.context = context;
        model=new HttpFllowListModel();
    }
    public void getfllowlistdatanow(String token,String uid){
    model.getfllowlistdata(token, uid, new AbstractObserver<FollowListBean>() {
        @Override
        public void onSuccess(FollowListBean bean) {
            Log.i("url++++++++", "intercept: "+bean.toString());
            view.showFollowList(bean);
        }

        @Override
        public void onFailure(int code) {

        }
    });
    }
}
