package com.example.asus.onequickly.presenter.httppresenter;

import android.content.Context;

import com.example.asus.onequickly.model.bean.LoginBean;
import com.example.asus.onequickly.model.http.Mymodelgetdata;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.viewcallback.IViewShoudata;


/**
 * Created by gq on 2018/1/26.
 */

public class Myloginpresenter {

    Context context;
    IViewShoudata ivewlogin;
     Mymodelgetdata mymodelgetdata;


    public Myloginpresenter( Context context,  IViewShoudata ivewlogin) {
        this.context=context;
        this.ivewlogin=ivewlogin;
         mymodelgetdata=new Mymodelgetdata();
    }
    public void Login(String mobile,String password,String token) {
        mymodelgetdata.getmodellogin(mobile, password, token, new AbstractObserver<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                ivewlogin.IvewShouLogindata(loginBean);

            }

            @Override
            public void onFailure(int code) {

            }
        });
    }
}
