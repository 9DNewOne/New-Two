package com.example.asus.onequickly.view.viewcallback;


import com.example.asus.onequickly.model.bean.BannerBean;

/**
 *
 * Created by asus on 2018/1/23.
 */

public interface AttentionView {

    //展示轮播图
    void showBannerList(BannerBean bannerBean);

    //Toast错误码
    void showToast(int e);


}
