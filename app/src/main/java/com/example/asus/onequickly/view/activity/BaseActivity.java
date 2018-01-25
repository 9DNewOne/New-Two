package com.example.asus.onequickly.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.onequickly.presenter.httppresenter.BasePresenter;


/**
 * Created by asus on 2018/1/25.
 */

public abstract class BaseActivity<V,P extends BasePresenter<V>> extends AppCompatActivity {
    public P presenter;
    public abstract P addpresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //presenter连接view与model
        presenter=addpresenter();
        //连接视图
        presenter.attachview((V) this);
    }
        //销毁视图
    @Override
    protected void onDestroy() {
        super.onDestroy();
         presenter.dettach();
    }
}
