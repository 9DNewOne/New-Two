package com.example.asus.onequickly.presenter.httppresenter;

import android.content.Context;

import com.example.asus.onequickly.model.bean.PublishBean;
import com.example.asus.onequickly.model.http.HttpPublishModel;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.activity.AnepisodeActivity;
import com.example.asus.onequickly.view.viewcallback.IPublishView;

/**
 * Created by gq on 2018/2/4.
 */


public class MyPublishpresenter  extends BasePresenter<IPublishView>{

       Context context;
       HttpPublishModel modle;

    public MyPublishpresenter(Context context) {
        this.context=context;
        modle=new HttpPublishModel();

    }

       public void getpublishdata(String uid,String token,String content){
           modle.getmodelPublish(uid, token, content, new AbstractObserver<PublishBean>() {
               @Override
               public void onSuccess(PublishBean publishBean) {
                      view.publishdata(publishBean);
               }

               @Override
               public void onFailure(int code) {

               }
           });




       }









}
