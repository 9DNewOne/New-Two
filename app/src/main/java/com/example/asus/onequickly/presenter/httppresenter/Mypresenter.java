package com.example.asus.onequickly.presenter.httppresenter;

import android.content.Context;

import com.example.asus.onequickly.model.bean.RegistBean;
import com.example.asus.onequickly.model.http.Mymodelgetdata;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.viewcallback.IViewShoudata;


/**
 * Created by gq on 2018/1/25.
 */


public class Mypresenter {
        IViewShoudata view;
       Mymodelgetdata modle;
      Context context;


    public Mypresenter( Context context, IViewShoudata view){
        this.context=context;
        this.view=view;
        modle=new Mymodelgetdata();
    }

      public void aishasha(String mobile,String password)
      {
         modle.getmodledata(mobile, password, new AbstractObserver<RegistBean>() {
             @Override
             public void onSuccess(RegistBean registBean) {
                  view.IviewShooudata(registBean);
               }

             @Override
             public void onFailure(int code) {
             }
         });


      }








}
