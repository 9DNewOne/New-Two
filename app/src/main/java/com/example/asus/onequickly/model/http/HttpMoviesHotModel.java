package com.example.asus.onequickly.model.http;


import com.example.asus.onequickly.model.bean.MoviesBean;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by gq on 2018/1/29.
 */
  //
public class HttpMoviesHotModel {
//https://www.zhaoapi.cn/quarter/getVideos?uid=4305&type=1&page=1&source=android&appVersion=1


    public void getmodelmoviesHot(String uid,String page, AbstractObserver<MoviesBean> observer) {
        Map<String,String> map= new HashMap();
        map.put("uid",uid);
        map.put("page",page);
        map.put("type","1");
        APIFactory.getInstance().get("quarter/getVideos", map,observer);



    }

}
