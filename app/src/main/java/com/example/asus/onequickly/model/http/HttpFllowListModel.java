package com.example.asus.onequickly.model.http;

import com.example.asus.onequickly.model.bean.FollowListBean;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2018/1/28.
 */
    //提供用户关注列表model
public class HttpFllowListModel {
    //https://www.zhaoapi.cn/quarter/getFollowUsers?
    // appVersion=101&
    // token=F3768ABA31902C1D56B60F25708B9BCD&
    // source=android&
    // uid=11850
    public void getfllowlistdata(String token, String uid, AbstractObserver<FollowListBean> observer){
        Map<String,String> map=new HashMap<>();
        map.put("token",token);
        map.put("uid",uid);
        APIFactory.getInstance().get("quarter/getFollowUsers",map,observer);
    }
}
