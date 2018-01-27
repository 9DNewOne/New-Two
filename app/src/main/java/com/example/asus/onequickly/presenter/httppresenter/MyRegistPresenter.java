package com.example.asus.onequickly.presenter.httppresenter;

import android.content.Context;

import com.example.asus.onequickly.model.bean.RegistBean;
import com.example.asus.onequickly.model.http.HttpRegistModel;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.viewcallback.IregistView;

/**
 * Created by asus on 2018/1/27.
 */

public class MyRegistPresenter extends BasePresenter<IregistView> {
    HttpRegistModel model;
    Context context;

    public MyRegistPresenter(Context context) {
        this.context = context;
        model=new HttpRegistModel();
    }
    public void regisdata(String mobile,String password){
        model.getmodledata(mobile, password, new AbstractObserver<RegistBean>() {
            @Override
            public void onSuccess(RegistBean registBean) {
                view.Registdata(registBean);
            }

            @Override
            public void onFailure(int code) {

            }
        });

    }

}
