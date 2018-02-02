package com.example.asus.onequickly.model.http;

import com.example.asus.onequickly.model.bean.SearchUserBean;
import com.example.asus.onequickly.utils.httputils.APIFactory;
import com.example.asus.onequickly.utils.httputils.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2018/2/2.
 */

public class HttpSearchUserModel {
//https://www.zhaoapi.cn/quarter/searchFriends?source=android&AppVersion=101&Keywords=哈哈&page=0
    public void getsearchinfo(String keyword, String page, AbstractObserver<SearchUserBean> observer){
        Map<String,String> map=new HashMap<>();
        map.put("Keywords",keyword);
        map.put("page",page);
        APIFactory.getInstance().get("quarter/searchFriends",map,observer);

    }

}
