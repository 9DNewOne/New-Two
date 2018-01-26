package com.example.asus.onequickly.model.http;



import com.example.asus.onequickly.model.bean.LoginBean;
import com.example.asus.onequickly.model.bean.RegistBean;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gq on 2018/1/25.
 */

public class Mymodelgetdata  implements Imodlegetdatabase{

//https://www.zhaoapi.cn/quarter/register?source=android&mobile=17316250426&password=1234567

    @Override
    public void getmodledata(String mobile, String password, AbstractObserver<RegistBean> observer) {
        Map<String,String> map= new HashMap();
        map.put("mobile",mobile);
        map.put("password",password);
             APIFactory.getInstance().get("quarter/register", map,observer);

        }

    @Override
    public void getmodellogin(String mobile, String password, String token, AbstractObserver<LoginBean> observer) {
      //   https://www.zhaoapi.cn/user/login?source=android&mobile=17316250426&password=123456789&token=FBF1

        Map<String,String> map= new HashMap();
        map.put("mobile",mobile);
        map.put("password",password);
        map.put("token","");
        APIFactory.getInstance().get("user/login", map,observer);

    }

    }

