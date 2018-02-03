package com.example.asus.onequickly.utils.app;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;


/**
 * Created by asus on 2018/1/25.
 */

public class FrescoApplication extends Application {

    private static Context context;//获取全局上下文

    {


        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");

    }



    @Override
    public void onCreate() {
        super.onCreate();
        //初始化fresco
        Fresco.initialize(this);
        UMShareAPI.get(this);
        //设置全局上下文
        context=getApplicationContext();

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    public static Context getContext(){
        return context;
    }
}
