package com.example.asus.onequickly.presenter.httppresenter;

import android.content.Context;
import android.util.Log;

import com.example.asus.onequickly.model.bean.UserInfoBean;
import com.example.asus.onequickly.model.http.HttpUserInfoModel;
import com.example.asus.onequickly.utils.app.FrescoApplication;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.viewcallback.IUserInfoView;

/**
 * Created by win on 2018/1/30.
 */

public class UserInfoPresenter extends BasePresenter<IUserInfoView> {

    private final Context mContext;
    private final HttpUserInfoModel userInfoModel;

    public UserInfoPresenter() {
        mContext = FrescoApplication.getContext();
        userInfoModel = new HttpUserInfoModel();
    }


    public void getNetUserInfo(String token,String uid){

        userInfoModel.getUserInfo(token, uid, new AbstractObserver<UserInfoBean>() {
            @Override
            public void onSuccess(UserInfoBean userInfoBean) {
                Log.e("getNetUserInfo", "onSuccess: "+userInfoBean.toString() );
                view.showUserInfoNetApi(userInfoBean);
            }

            @Override
            public void onFailure(int code) {
                Log.e("getNetUserInfo", "onFailure: "+code );
            }
        });

    }
}
