package com.example.asus.onequickly.presenter.httppresenter;

import android.content.Context;
import android.util.Log;

import com.example.asus.onequickly.model.bean.SearchUserBean;
import com.example.asus.onequickly.model.http.HttpSearchUserModel;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.viewcallback.ISearchUserView;

/**
 * Created by asus on 2018/2/2.
 */

public class MySearchUsearPresenter extends BasePresenter<ISearchUserView> {
    Context context;
    HttpSearchUserModel model;

    public MySearchUsearPresenter(Context context) {
        this.context = context;
        model=new HttpSearchUserModel();
    }
    public void GetUserInfoNow(String keyword,String page){
        model.getsearchinfo(keyword, page, new AbstractObserver<SearchUserBean>() {
            @Override
            public void onSuccess(SearchUserBean bean) {
                Log.i("++++++", "搜索用户成功: "+bean.getMsg());
             view.getuserinfodata(bean);
            }
            @Override
            public void onFailure(int code) {

            }
        });
    }

}
