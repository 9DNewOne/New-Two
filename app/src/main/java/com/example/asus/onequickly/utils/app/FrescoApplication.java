package com.example.asus.onequickly.utils.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by asus on 2018/1/25.
 */

public class FrescoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化fresco
        Fresco.initialize(this);
    }
}
