package com.example.springboottest.module;

public class group {
    public void setGroupid(Integer groupid){this.groupid = groupid;}
    public Integer getGroupid(){return groupid;}

    public void setGroupname(String groupname){this.groupname = groupname;}
    public String getGroupname(){return groupname;}

    public void setLeaderid(Integer leaderid){this.leaderid = leaderid;}
    public Integer getLeaderid(){return leaderid;}

    public void setLeadername(String leadername){this.leadername = leadername;}
    public String getLeadername(){return leadername;}

    public void setCourseid(Integer courseid){this.courseid = courseid;}
    public Integer getCourseid(){return courseid;}

    public void setCoursename(String coursename){this.coursename = coursename;}
    public String getCoursename(){return coursename;}

    private Integer groupid;
    private String groupname;
    private Integer leaderid;
    private String leadername;
    private Integer courseid;
    private String coursename;
}
