package com.example.asus.onequickly.presenter.httppresenter;

import android.util.Log;

import com.example.asus.onequickly.model.bean.BannerBean;
import com.example.asus.onequickly.model.http.HttpHotModel;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import com.example.asus.onequickly.view.viewcallback.HotView;

/**
 *
 * Created by win on 2018/1/30.
 */

public class HotPresenter extends BasePresenter<HotView> {
    private HttpHotModel mHotModel;

    public HotPresenter() {

        mHotModel = new HttpHotModel();
    }

    public void gainNetRequest() {
        mHotModel.getBannerHttpApi(new AbstractObserver<BannerBean>() {

            @Override
            public void onSuccess(BannerBean bannerBean) {

                Log.e("+++++++++++", "onSuccess: "+bannerBean.getData().size() );
//                if (bannerBean!=null) {
//                    List<String> icons = new ArrayList<>();
//                    for (int i = 0; i < bannerBean.getData().size(); i++) {
//                        String icon = bannerBean.getData().get(i).getIcon();
//                        Log.e("onSuccess", "onSuccess: "+icon );
//                        icons.add(icon);
//                    }
                    view.showBannerList(bannerBean);

            }

            @Override
            public void onFailure(int code) {
                Log.e("++++++++++", "onFailure: ---------"+code );

                view.showToast(code);
            }
        });
    }

}
