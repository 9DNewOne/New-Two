package com.example.asus.onequickly.model.http;

import com.example.asus.onequickly.model.bean.BannerBean;
import com.example.asus.onequickly.model.bean.ProductionBean;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;

/**
 *
 * Created by win on 2018/1/30.
 */

public interface IRecommendHotModel {

    void getBannerHttpApi(AbstractObserver<BannerBean> observer);

    /**
     * 作品列表
     * @param uid   用户id
     * @param type  类别 1.推荐 2.关注
     * @param page  页码
     * @param observer  观察者
     */
    void getProductionListApi(String uid,String type,String page,AbstractObserver<ProductionBean> observer);



}
