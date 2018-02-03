package com.example.asus.onequickly.model.bean;

import java.util.List;

/**
 * Created by win on 2018/1/31.
 */

public class ProductionBean {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15172267804431513341066240.jpg","createTime":"2018-01-29T19:53:00","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":1,"praiseNum":1,"uid":2766,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516188593683alk.jpg","nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517226780443haodeba.mp4","wid":274,"workDesc":null},{"commentNum":1,"comments":[{"cid":263,"content":"%E5%93%88%E5%93%88%E5%93%88%E5%93%88%E5%93%88%E5%93%88%E5%93%88%E5%93%88%E5%93%88","createTime":"2018-01-29T18:34:01","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":11365,"wid":273}],"cover":"https://www.zhaoapi.cn/images/quarter/151721482212520180129163224.jpg","createTime":"2018-01-29T16:33:45","favoriteNum":3,"latitude":"0","localUri":null,"longitude":"0","playNum":0,"praiseNum":1,"uid":2924,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517214822125VID_20180129_163206.mp4","wid":273,"workDesc":"小短片"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151721482280220180129163224.jpg","createTime":"2018-01-29T16:33:42","favoriteNum":1,"latitude":"0","localUri":null,"longitude":"0","playNum":0,"praiseNum":0,"uid":2924,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517214822802VID_20180129_163206.mp4","wid":272,"workDesc":"小短片"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151721422725920180129162227.jpg","createTime":"2018-01-29T16:23:47","favoriteNum":1,"latitude":"0","localUri":null,"longitude":"0","playNum":0,"praiseNum":0,"uid":2924,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517214227259VID_20180129_162205.mp4","wid":271,"workDesc":"11111"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151721400670620180129161954.jpg","createTime":"2018-01-29T16:20:07","favoriteNum":0,"latitude":"0","localUri":null,"longitude":"0","playNum":1,"praiseNum":0,"uid":2924,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517214006706VID_20180129_161934.mp4","wid":270,"workDesc":"1111"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151721400672220180129161954.jpg","createTime":"2018-01-29T16:20:07","favoriteNum":0,"latitude":"0","localUri":null,"longitude":"0","playNum":0,"praiseNum":0,"uid":2924,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517214006722VID_20180129_161934.mp4","wid":269,"workDesc":"1111"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1517025486173xniao.jpg","createTime":"2018-01-27T11:58:06","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":1,"uid":2322,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15169660139571516966011147.png","nickname":"小崔","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517025486173minion_09.mp4","wid":268,"workDesc":"俞敏洪小视频"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1517017952764nyxb20170906-1-l.jpg","createTime":"2018-01-27T09:52:32","favoriteNum":0,"latitude":"156","localUri":null,"longitude":"150","playNum":0,"praiseNum":2,"uid":4814,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1517017459017nyxb20170906-1-l.jpg","nickname":"叫我飞哥好吗!","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517017952764xiaohuang.mp4","wid":267,"workDesc":"111"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1517016896244jqr.png","createTime":"2018-01-27T09:34:56","favoriteNum":1,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":2322,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15169660139571516966011147.png","nickname":"小崔","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517016896244ymh.mp4","wid":266,"workDesc":"俞敏洪小视频"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15170166607103.jpg","createTime":"2018-01-27T09:31:00","favoriteNum":1,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":4,"praiseNum":1,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517016660710xiaohuang.mp4","wid":265,"workDesc":"测试"}]
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
         * commentNum : 0
         * comments : []
         * cover : https://www.zhaoapi.cn/images/quarter/15172267804431513341066240.jpg
         * createTime : 2018-01-29T19:53:00
         * favoriteNum : 0
         * latitude : 39.95
         * localUri : null
         * longitude : 116.30
         * playNum : 1
         * praiseNum : 1
         * uid : 2766
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516188593683alk.jpg","nickname":null,"praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1517226780443haodeba.mp4
         * wid : 274
         * workDesc : null
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private Object workDesc;
        private List<?> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public Object getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(Object workDesc) {
            this.workDesc = workDesc;
        }

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1516188593683alk.jpg
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private Object nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
