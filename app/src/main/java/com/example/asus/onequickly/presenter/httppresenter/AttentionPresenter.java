package com.example.asus.onequickly.presenter.httppresenter;

import com.example.asus.onequickly.model.bean.BannerBean;
import com.example.asus.onequickly.model.bean.ProductionBean;
import com.example.asus.onequickly.model.http.HttpAttentionModel;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.viewcallback.AttentionView;

/**
 *
 * Created by win on 2018/1/30.
 */

public class AttentionPresenter extends BasePresenter<AttentionView> {
    private HttpAttentionModel mAttentionModel;

    public AttentionPresenter() {

        mAttentionModel = new HttpAttentionModel();
    }

    public void gainNetRequest() {
        mAttentionModel.getBannerHttpApi(new AbstractObserver<BannerBean>() {

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

        mAttentionModel.getProductionListApi(uid, type, page, new AbstractObserver<ProductionBean>() {
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
