package com.example.springboottest.module;

public class crspointscore {
    public Integer getCrspointid() {
        return crspointid;
    }
    public void setCrspointid(Integer crspointid){
        this.crspointid = crspointid;
    }
    public String getCrspointname() {
        return crspointname;
    }
    public void setCrspointname(String crspointname){
        this.crspointname = crspointname;
    }
    public Integer getIsDone() {
        return isDone;
    }
    public void setIsDone(Integer isDone){
        this.isDone = isDone;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score){
        this.score = score;
    }

    private Integer crspointid;
    private String crspointname;
    private Integer isDone;
    private Integer score;
}
