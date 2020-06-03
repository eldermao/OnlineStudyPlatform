package com.example.springboottest.module;

public class coursecontest {
    public Integer getExamid() {
        return examid;
    }
    public void setExamid(Integer examid){
        this.examid = examid;
    }

    public String getExamname() {
        return examname;
    }
    public void setExamname(String examname){
        this.examname = examname;
    }

    public Integer getIscontest() {
        return iscontest;
    }
    public void setIscontest(Integer iscontest){
        this.iscontest = iscontest;
    }

    public Integer getCourseid() {
        return courseid;
    }
    public void setCourseid(Integer courseid){
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }
    public void setCoursename(String coursename){
        this.coursename = coursename;
    }

    private Integer examid;
    private String examname;
    private Integer iscontest;
    private Integer courseid;
    private String coursename;
}
