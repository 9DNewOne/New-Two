package com.example.asus.onequickly.model.http;

import com.example.asus.onequickly.model.bean.LoginBean;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2018/1/27.
 */

public class HttpLoginModel {

    public void getmodellogin(String mobile, String password, String token, AbstractObserver<LoginBean> observer) {
        //   https://www.zhaoapi.cn/user/login?source=android&mobile=17316250426&password=123456789&token=FBF1
        Map<String,String> map= new HashMap();
        map.put("mobile",mobile);
        map.put("password",password);
        map.put("token","");
        APIFactory.getInstance().get("user/login", map,observer);

    }
}
