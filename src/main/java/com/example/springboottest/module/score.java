package com.example.springboottest.module;

public class score {
    public Integer getUserid(){
        return userid;
    }
    public void setUserid(Integer userid){
        this.userid = userid;
    }

    public Integer getIsexam(){
        return isexam;
    }
    public void setIsexam(Integer isexam){
        this.isexam = isexam;
    }

    public Integer getExamid(){
        return examid;
    }
    public void setExamid(Integer examid){
        this.examid = examid;
    }

    public Integer getCrspointid(){
        return crspointid;
    }
    public void setCrspointid(Integer crspointid){
        this.crspointid = crspointid;
    }

    public Integer getScore(){
        return score;
    }
    public void setScore(Integer score){
        this.score = score;
    }
    private Integer userid;
    private Integer isexam;
    private Integer examid;
    private Integer crspointid;
    private Integer score;
}
