package com.example.asus.onequickly.presenter.httppresenter;

import android.content.Context;

import com.example.asus.onequickly.model.bean.LoginBean;
import com.example.asus.onequickly.model.bean.UserInfoBean;
import com.example.asus.onequickly.model.http.HttpLoginModel;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.viewcallback.IlogView;

/**
 * Created by asus on 2018/1/27.
 */
    //登录presenter
public class MyLogPresenter extends BasePresenter<IlogView> {
    HttpLoginModel model;
    Context context;
    public MyLogPresenter(Context context) {
        this.context=context;
        model=new HttpLoginModel();
    }
    //登录方法
    public void login(String mobile,String password,String toKen){
        model.getmodellogin(mobile, password, toKen, new AbstractObserver<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                view.loginData(loginBean);
            }

            @Override
            public void onFailure(int code) {

            }
        });
    }

    public void getUserInfo(String uid,String toKen){
        model.getUserInfo(uid, toKen, new AbstractObserver<UserInfoBean>() {
            @Override
            public void onSuccess(UserInfoBean userInfoBean) {
                view.showUserInfo(userInfoBean);
            }

            @Override
            public void onFailure(int code) {

            }
        });

    }


}

