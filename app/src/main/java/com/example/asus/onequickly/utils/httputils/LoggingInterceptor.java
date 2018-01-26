package com.example.asus.onequickly.utils.httputils;

import android.os.Build;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.logging.Logger;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 网络拦截器
 */

public class LoggingInterceptor implements Interceptor {
    private static final String UA = "User-Agent";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String url = request.url().toString();
        //添加了新的公共参数
        url=url+"&source=android&appVersion=101";
                Request request1=request.newBuilder()
                        .url(url)
                        .addHeader(UA, makeUA())
                        .build();
        return chain.proceed(request1);
    }

    private String makeUA() {
        String s = Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;
        return Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;
    }

}
