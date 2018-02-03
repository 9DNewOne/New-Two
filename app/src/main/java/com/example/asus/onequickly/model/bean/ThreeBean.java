package com.example.asus.onequickly.model.bean;

/**
 * Created by gq on 2018/2/3.
 */
/*
  String iconurl = data.get("iconurl");
                 String  name = data.get("name");
                 String grander = data.get("gender");
               // String accesstoken = data.get("accesstoken");
                String uid = data.get("uid");

*/


public class ThreeBean {

    private  String name;
    private  String grander;
    private  String uid;
    private  String iconurl;

    public ThreeBean(String name, String grander, String uid, String iconurl) {
        this.name = name;
        this.grander = grander;
        this.uid = uid;
        this.iconurl = iconurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrander() {
        return grander;
    }

    public void setGrander(String grander) {
        this.grander = grander;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }


}
