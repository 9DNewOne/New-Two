package com.example.asus.onequickly.model.http;

import com.example.asus.onequickly.model.bean.BannerBean;
import com.example.asus.onequickly.model.bean.ProductionBean;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by win on 2018/1/30.
 */

public class HttpAttentionModel implements IAttentionModel {

    @Override
    public void getBannerHttpApi(AbstractObserver<BannerBean> observer) {
        APIFactory.getInstance().get("quarter/getAd?",observer);
    }

    @Override
    public void getProductionListApi(String uid, String type, String page, AbstractObserver<ProductionBean> observer) {
        Map<String,String> ProductionMap=new HashMap<>();

        ProductionMap.put("uid",uid);
        ProductionMap.put("type",type);
        ProductionMap.put("page",page);

        APIFactory.getInstance().get("quarter/getVideos",ProductionMap,observer);

    }
}
