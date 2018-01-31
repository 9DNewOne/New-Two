package com.example.asus.onequickly.model.http;

import com.example.asus.onequickly.model.bean.BannerBean;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;

/**
 * Created by win on 2018/1/30.
 */

public class HttpAttentionModel implements IAttentionModel {

    @Override
    public void getBannerHttpApi(AbstractObserver<BannerBean> observer) {
        APIFactory.getInstance().get("quarter/getAd?",observer);
    }
}
