package com.example.asus.onequickly.utils.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by asus on 2018/1/25.
 */

public class FrescoApplication extends Application {

    private  static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化fresco
        Fresco.initialize(this);

        //设置全局上下文
        context=getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
