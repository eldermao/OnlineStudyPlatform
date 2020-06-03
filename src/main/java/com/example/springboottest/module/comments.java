package com.example.springboottest.module;

public class comments {
    public void setCommentsid(Integer commentsid){this.commentsid = commentsid;}
    public Integer getCommentsid(){return commentsid;}

    public void setCrspointid(Integer crspointid){this.crspointid = crspointid;}
    public Integer getCrspointid(){return crspointid;}

    public void setUserid(Integer userid){this.userid = userid;}
    public Integer getUserid(){return userid;}

    public void setUsername(String username){this.username = username;}
    public String getUsername(){return username;}

    public void setContent(String content){this.content = content;}
    public String getContent(){return content;}

    public void setProfile(String profile){this.profile = profile;}
    public String getProfile(){return profile;}

    private Integer commentsid;
    private Integer crspointid;
    private Integer userid;
    private String username;
    private String content;
    private String profile;
}
