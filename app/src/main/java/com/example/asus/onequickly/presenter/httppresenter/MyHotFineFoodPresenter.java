package com.example.asus.onequickly.presenter.httppresenter;

import android.content.Context;

import com.example.asus.onequickly.model.bean.RandomFriendsBean;
import com.example.asus.onequickly.model.http.HttpHotFineFoodModel;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.viewcallback.IHotFollowFineFoodView;

/**
 * Created by asus on 2018/1/31.
 */

public class MyHotFineFoodPresenter extends BasePresenter<IHotFollowFineFoodView> {
    Context context;
    HttpHotFineFoodModel model;

    public MyHotFineFoodPresenter(Context context) {
        this.context = context;
        model=new HttpHotFineFoodModel();
    }
    public void getfinefoodnow(){
        model.gethotfinefoodmodeldata(new AbstractObserver<RandomFriendsBean>() {
            @Override
            public void onSuccess(RandomFriendsBean bean) {
                view.getfinefooddata(bean);
            }

            @Override
            public void onFailure(int code) {

            }
        });
    }

}
