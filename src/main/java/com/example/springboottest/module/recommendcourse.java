package com.example.springboottest.module;

public class recommendcourse {

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

    public Integer getTeacherid() {
        return teacherid;
    }
    public void setTeacherid(Integer teacherid){
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }
    public void setTeachername(String teachername){
        this.teachername = teachername;
    }

    public String getCoursepic() {
        return coursepic;
    }
    public void setCoursepic(String coursepic){
        this.coursepic = coursepic;
    }

    public Integer getCnt() {
        return cnt;
    }
    public void setCnt(Integer cnt){
        this.cnt = cnt;
    }

    private Integer courseid;
    private String coursename;
    private Integer teacherid;
    private String teachername;
    private String coursepic;
    private Integer cnt;
}
