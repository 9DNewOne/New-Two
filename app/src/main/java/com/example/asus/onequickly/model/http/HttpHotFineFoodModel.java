package com.example.asus.onequickly.model.http;

import com.example.asus.onequickly.model.bean.RandomFriendsBean;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;

/**
 * Created by asus on 2018/1/31.
 */

public class HttpHotFineFoodModel {
    //https://www.zhaoapi.cn/quarter/randomFriends?source=android&AppVersion=101
    public void gethotfinefoodmodeldata(AbstractObserver<RandomFriendsBean> observer){
        APIFactory.getInstance().get("quarter/randomFriends?",observer);
    }
}
