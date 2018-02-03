package com.example.asus.onequickly.view.viewcallback;


import com.example.asus.onequickly.model.bean.BannerBean;
import com.example.asus.onequickly.model.bean.ProductionBean;

import java.util.List;

/**
 *
 * Created by asus on 2018/1/23.
 */

public interface HotView {

    void showBannerList(BannerBean bannerBean);

    void showToast(int e);

    void showProductionList(ProductionBean productions);

}
