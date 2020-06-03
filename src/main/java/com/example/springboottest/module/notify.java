package com.example.springboottest.module;

public class notify {
    public void setNotifyid(Integer notifyid){this.notifyid = notifyid;}
    public Integer getNotifyid(){return notifyid;}

    public void setTitle(String title){this.title = title;}
    public String getTitle(){return title;}

    public void setContent(String content){this.content = content;}
    public String getContent(){return content;}

    public void setPic(String pic){this.pic = pic;}
    public String getPic(){return pic;}

    public void setTime(Integer time){this.time = time;}
    public Integer getTime(){return time;}

    public void setUserid(Integer userid){this.userid = userid;}
    public Integer getUserid(){return userid;}

    public void setUsername(String username){this.username = username;}
    public String getUsername(){return username;}

    private Integer notifyid;
    private String title;
    private String content;
    private String  pic;
    private Integer time;
    private Integer userid;
    private String username;
}
