package com.example.asus.onequickly.model.http;


import com.example.asus.onequickly.model.bean.MoviesNearbyBean;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;

import java.util.HashMap;
import java.util.Map;
    //附近
/**
 * Created by gq on 2018/1/29.
 */
//https://www.zhaoapi.cn/quarter/getNearVideos?appVersion=101&source=android&page=1&token=FE04C41704BE82CECA90454EA16CFBF1
public class HttpMoviesNearbyModel {

    public void getmodelmoviesHot(String page, String token, AbstractObserver<MoviesNearbyBean> observer) {
        Map<String,String> map= new HashMap();
        map.put("page",page);
        map.put("token",token);

        APIFactory.getInstance().post("quarter/getVideos", map,observer);



    }

}
