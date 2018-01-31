package com.example.asus.onequickly.model.http;

import com.example.asus.onequickly.model.bean.UserInfoBean;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by win on 2018/1/30.
 */

public class HttpUserInfoModel {

    public void getUserInfo(String token, String uid, AbstractObserver<UserInfoBean> observer){

        Map<String, String> map = new HashMap<>();
        map.put("token",token);
        map.put("uid",uid);
        APIFactory.getInstance().get("user/getUserInfo",map,observer);

    }
}
