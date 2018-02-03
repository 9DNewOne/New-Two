package com.example.asus.onequickly.presenter.httppresenter;

import android.content.Context;

import com.example.asus.onequickly.model.bean.MoviesBean;
import com.example.asus.onequickly.model.bean.MoviesHotBean;
import com.example.asus.onequickly.model.http.HttpMoviesHotModel;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.viewcallback.IMoviesHotView;


/**
 * Created by gq on 2018/1/29.
 */
  //热门
public class MyMoviesHotPresenter extends BasePresenter<IMoviesHotView> {

    HttpMoviesHotModel model;
    Context context;

    public MyMoviesHotPresenter(Context context) {
        this.context=context;
        model=new HttpMoviesHotModel();
    }

     //   String page,String token
    public void movieshot(String uid,String page){
        model.getmodelmoviesHot(uid,page,new AbstractObserver<MoviesBean>() {
            @Override
            public void onSuccess(MoviesBean moviesBean) {
                  //成功的数据回调
                view.MoviesHotdata(moviesBean);
            }
            @Override
            public void onFailure(int code) {
            }
        });



    }



}
