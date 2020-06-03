package com.example.springboottest.module;

public class coursescore {
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
    public String getTeachername() {
        return teachername;
    }
    public void setTeachername(String teachername){
        this.teachername = teachername;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score){
        this.score = score;
    }
    public Integer getMax() {
        return max;
    }
    public void setMax(Integer max){
        this.max = max;
    }
    public Integer getSum() {
        return sum;
    }
    public void setSum(Integer sum){
        this.sum = sum;
    }
    public Integer getRank() {
        return rank;
    }
    public void setRank(Integer rank){
        this.rank = rank;
    }

    private Integer courseid;
    private String coursename;
    private String teachername;
    private Integer score;
    private Integer max;
    private Integer sum;
    private Integer rank;
}
