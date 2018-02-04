package com.example.asus.onequickly.model.http;

import com.example.asus.onequickly.model.bean.RegistBean;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2018/1/27.
 */

public class HttpRegistModel {

    public void getmodledata(String mobile,String password,AbstractObserver<RegistBean> observer) {
        Map<String,String> map= new HashMap();
        map.put("mobile",mobile);
        map.put("password",password);
        APIFactory.getInstance().get("quarter/register", map,observer);
    }
}
