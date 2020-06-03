package com.example.springboottest.module;

public class user {

    public user(){};
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Integer getUserage() {
        return userage;
    }
    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    public String getUserphone() {
        return userphone;
    }
    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseremail() {
        return useremail;
    }
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public Integer getPosition() {
        return position;
    }
    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }

    private Integer userid;
    private String username;
    private String userpassword;
    private Integer userage;
    private String userphone;
    private String useremail;
    private Integer position;
    private String profile;
}