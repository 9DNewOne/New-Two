package com.example.asus.onequickly.view.viewcallback;

import com.example.asus.onequickly.model.bean.LoginBean;
import com.example.asus.onequickly.model.bean.UserInfoBean;

/**
 * Created by asus on 2018/1/27.
 */

public interface IlogView {
    void loginData(LoginBean loginBean);

    void showUserInfo(UserInfoBean userInfo);
}
