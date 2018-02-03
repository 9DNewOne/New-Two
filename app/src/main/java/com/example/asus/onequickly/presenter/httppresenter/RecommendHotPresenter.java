package com.example.asus.onequickly.presenter.httppresenter;

import com.example.asus.onequickly.model.bean.BannerBean;
import com.example.asus.onequickly.model.bean.ProductionBean;
import com.example.asus.onequickly.model.http.HttpRecommendHotModel;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.viewcallback.HotView;

/**
 * Created by win on 2018/1/30.
 */

public class RecommendHotPresenter extends BasePresenter<HotView> {
    private HttpRecommendHotModel mHotModel;

    public RecommendHotPresenter() {

        mHotModel = new HttpRecommendHotModel();
    }

    public void gainNetRequest() {
        mHotModel.getBannerHttpApi(new AbstractObserver<BannerBean>() {

            @Override
            public void onSuccess(BannerBean bannerBean) {

                view.showBannerList(bannerBean);
            }

            @Override
            public void onFailure(int code) {

                view.showToast(code);
            }
        });
    }

    public void gainNetProduction(String uid, String type, String page) {

        mHotModel.getProductionListApi(uid, type, page, new AbstractObserver<ProductionBean>() {
            @Override
            public void onSuccess(ProductionBean productionBean) {

                view.showProductionList(productionBean);
            }

            @Override
            public void onFailure(int code) {

                view.showToast(code);
            }
        });
    }

}
