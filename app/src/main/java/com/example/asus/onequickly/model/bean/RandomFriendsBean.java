package com.example.asus.onequickly.model.bean;

import java.util.List;

/**
 * Created by asus on 2018/1/30.
 */
//随机钟友bean
public class RandomFriendsBean {

    /**
     * msg : 请求成功
     * code : 1
     * data : [{"age":null,"appkey":"a527e7a7d6435c94","appsecret":"E315A756BA5D972ADFF8306E17176966","createtime":"2017-12-23T10:56:22","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13955194931","money":null,"nickname":null,"password":"22C084FB649A2545526A7D5715B51D4C","praiseNum":null,"token":null,"uid":9039,"userId":null,"username":"13955194931"},{"age":null,"appkey":"543fd91be4d7f26e","appsecret":"2C781092D8AE1C1C38ABCA92D26FB284","createtime":"2017-12-23T10:56:22","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13925685853","money":null,"nickname":null,"password":"3CE4A77E4113E944D28D72DEF4FC32CE","praiseNum":null,"token":null,"uid":9040,"userId":null,"username":"13925685853"},{"age":null,"appkey":"0e628fe1c552221f","appsecret":"FA339515106EC1FD15304201B583D2DA","createtime":"2017-12-23T10:56:22","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13980883923","money":null,"nickname":null,"password":"C8E758AD84870D2865E8B4D178207AC3","praiseNum":null,"token":null,"uid":9041,"userId":null,"username":"13980883923"},{"age":null,"appkey":"0f31d889bd773c2e","appsecret":"DC41A847C7C54D81E29C94DDBCEDCFBD","createtime":"2017-12-23T10:56:22","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13933552620","money":null,"nickname":null,"password":"1669DF78C1597EDC532DA6AE0809B603","praiseNum":null,"token":null,"uid":9042,"userId":null,"username":"13933552620"},{"age":null,"appkey":"3811c255ad0e32fc","appsecret":"7157C13220DE08F49D03C90FD799E5CA","createtime":"2017-12-23T10:56:22","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13986353330","money":null,"nickname":null,"password":"5F25AA6BCBE444085F9B7F1782B402D7","praiseNum":null,"token":null,"uid":9043,"userId":null,"username":"13986353330"},{"age":null,"appkey":"44b465034f389991","appsecret":"7379EC29AF2030DF09A7E9EC5AC2CC18","createtime":"2017-12-23T10:56:22","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13936144981","money":null,"nickname":null,"password":"95E0F2BCA64140E51B6D6E80D9ADC0C6","praiseNum":null,"token":null,"uid":9044,"userId":null,"username":"13936144981"},{"age":null,"appkey":"d85969833e55b3f0","appsecret":"745AC611EE6EC8DDFA0A67A137183649","createtime":"2017-12-23T10:56:22","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13969249983","money":null,"nickname":null,"password":"C46976FECA7282FFEA1011ED81397524","praiseNum":null,"token":null,"uid":9045,"userId":null,"username":"13969249983"},{"age":null,"appkey":"a28b555c76650f52","appsecret":"50F735DBFD64AAB8D286A6D5E4EC8176","createtime":"2017-12-23T10:56:22","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13992442963","money":null,"nickname":null,"password":"54B3403B388A245A3E3FDFD781B1B5B8","praiseNum":null,"token":null,"uid":9046,"userId":null,"username":"13992442963"},{"age":null,"appkey":"74b74baa0907563b","appsecret":"1BDCDFCFFD2AF905EF36915F4BA82F61","createtime":"2017-12-23T10:56:23","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13961326981","money":null,"nickname":null,"password":"7496E2836CAC9FBC23037BB657505A0B","praiseNum":null,"token":null,"uid":9047,"userId":null,"username":"13961326981"},{"age":null,"appkey":"2f51ed53938542b8","appsecret":"2C62D54D0D05383E79F42BA588EFD83F","createtime":"2017-12-23T10:56:23","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13987032349","money":null,"nickname":null,"password":"F1BF85062EC3D5B642E10EA7A4F8355B","praiseNum":null,"token":null,"uid":9048,"userId":null,"username":"13987032349"}]
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
         * appkey : a527e7a7d6435c94
         * appsecret : E315A756BA5D972ADFF8306E17176966
         * createtime : 2017-12-23T10:56:22
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 13955194931
         * money : null
         * nickname : null
         * password : 22C084FB649A2545526A7D5715B51D4C
         * praiseNum : null
         * token : null
         * uid : 9039
         * userId : null
         * username : 13955194931
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private Object gender;
        private Object icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private Object money;
        private Object nickname;
        private String password;
        private Object praiseNum;
        private Object token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
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

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
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

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
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

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
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
}
