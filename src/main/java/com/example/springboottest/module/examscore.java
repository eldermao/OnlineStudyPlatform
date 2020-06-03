package com.example.springboottest.module;

public class examscore {
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

    private Integer examid;
    private String examname;
    private Integer isDone;
    private Integer score;
}
