package com.example.asus.onequickly.presenter.httppresenter;

import android.content.Context;


import com.example.asus.onequickly.model.bean.MoviesNearbyBean;
import com.example.asus.onequickly.model.http.HttpMoviesNearbyModel;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.viewcallback.IMoviesNearbyView;



/**
 * Created by gq on 2018/1/29.
 */
  //附近
public class MyMoviesNearbyPresenter extends BasePresenter<IMoviesNearbyView>{
    HttpMoviesNearbyModel model;
    Context context;
    public MyMoviesNearbyPresenter(Context context) {
        this.context=context;
        model=new HttpMoviesNearbyModel();

    }

     public void moviesnearby(String page,String token){
        model.getmodelmoviesHot(page,token, new AbstractObserver<MoviesNearbyBean>() {

            @Override
            public void onSuccess(MoviesNearbyBean moviesNearbyBean) {
                view.MoviesNearbydata(moviesNearbyBean);
            }

            @Override
            public void onFailure(int code) {
            }
        });

     }




}
