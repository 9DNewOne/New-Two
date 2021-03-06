package com.example.asus.onequickly.utils.httputils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;



public class OkHttpUtils {


    private static OkHttpClient client = null ;


    public static OkHttpClient getInstance(){

        if(client == null){
            synchronized (OkHttpUtils.class){
                if(client == null){
                    client = new OkHttpClient.Builder()
                            .connectTimeout(50000, TimeUnit.SECONDS)
                            .writeTimeout(50000,TimeUnit.SECONDS)
                            .addInterceptor(new LoggingInterceptor())
                            .readTimeout(50000,TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return client;
    }


}
