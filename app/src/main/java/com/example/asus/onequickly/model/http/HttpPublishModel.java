package com.example.asus.onequickly.model.http;

import com.example.asus.onequickly.model.bean.MoviesBean;
import com.example.asus.onequickly.model.bean.PublishBean;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gq on 2018/2/4.
 */

public class HttpPublishModel {

 //https://www.zhaoapi.cn/quarter/publishJoke?appVersion=1&source=android&uid=4305&token=FE04C41704BE82CECA90454EA16CFBF1&content=的分v你发的
    //

    public void getmodelPublish(String uid,String token,String content, AbstractObserver<PublishBean> observer) {
        Map<String,String> map= new HashMap();
        map.put("uid",uid);
        map.put("token",token);
        map.put("content","content");
        APIFactory.getInstance().get("quarter/publishJoke", map,observer);

    }

}
