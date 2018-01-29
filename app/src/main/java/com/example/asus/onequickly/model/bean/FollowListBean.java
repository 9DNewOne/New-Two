package com.example.asus.onequickly.model.bean;

import java.util.List;

/**
 * Created by asus on 2018/1/27.
 */
//关注列表
public class FollowListBean {

    /**
     * msg : 获取关注用户列表成功
     * code : 0
     * data : [{"age":null,"appkey":null,"appsecret":null,"createtime":"2018-01-27T11:19:18","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"15726649477","money":0,"nickname":null,"password":"123456","praiseNum":null,"token":"7D7681906D11EB7DA06B04362688EB74","uid":983,"userId":null,"username":"15726649477"},{"age":null,"appkey":"3da240ef83bff8bd","appsecret":"6A0BEB7B305CFB831B3EC00D092B6B65","createtime":"2018-01-27T11:21:28","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13073564376","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"453274D5A5F76F3B4BBBF43F0DEEAB16","uid":12074,"userId":null,"username":"13073564376"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2018-01-27T11:19:18
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 15726649477
         * money : 0
         * nickname : null
         * password : 123456
         * praiseNum : null
         * token : 7D7681906D11EB7DA06B04362688EB74
         * uid : 983
         * userId : null
         * username : 15726649477
         */

        private Object age;
        private Object appkey;
        private Object appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private int gender;
        private Object icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private int money;
        private Object nickname;
        private String password;
        private Object praiseNum;
        private String token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public Object getAppkey() {
            return appkey;
        }

        public void setAppkey(Object appkey) {
            this.appkey = appkey;
        }

        public Object getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(Object appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFans() {
            return fans;
        }

        public void setFans(Object fans) {
            this.fans = fans;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    @Override
    public String toString() {
        return "FollowListBean{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
