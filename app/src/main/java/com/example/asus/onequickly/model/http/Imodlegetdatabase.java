package com.example.asus.onequickly.model.http;


import com.example.asus.onequickly.model.bean.LoginBean;
import com.example.asus.onequickly.model.bean.RegistBean;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;

/**
 * Created by gq on 2018/1/25.
 */

public interface Imodlegetdatabase {


        void  getmodledata(String mobile, String password, AbstractObserver<RegistBean> observer);
          //token 值
        void  getmodellogin(String mobile, String password, String token, AbstractObserver<LoginBean> observer);


}
