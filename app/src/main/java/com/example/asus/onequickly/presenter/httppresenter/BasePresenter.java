package com.example.asus.onequickly.presenter.httppresenter;

/**
 * Created by asus on 2018/1/25.
 */

public class BasePresenter<V> {
    public V view;
    public void attachview(V view){
        this.view=view;
    }

    public void dettach(){
        this.view=null;
    }
}
