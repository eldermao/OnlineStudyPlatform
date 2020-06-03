package com.example.springboottest.module;

public class contest {
    public void setContestid(Integer contestid){this.contestid = contestid;}
    public Integer getContestid(){return contestid;}

    public void setExamid(Integer examid){this.examid = examid;}
    public Integer getExamid(){return examid;}

    public void setExamname(String examname){this.examname = examname;}
    public String getExamname(){return examname;}

    public void setG1id(Integer g1id){this.g1id = g1id;}
    public Integer getG1id(){return g1id;}

    public void setG1name(String g1name){this.g1name = g1name;}
    public String getG1name(){return g1name;}

    public void setG2id(Integer g2id){this.g2id = g2id;}
    public Integer getG2id(){return g2id;}

    public void setG2name(String g2name){this.g2name = g2name;}
    public String getG2name(){return g2name;}

    public void setStarttime(Integer starttime){this.starttime = starttime;}
    public Integer getStarttime(){return starttime;}

    public void setEndtime(Integer endtime){this.endtime = endtime;}
    public Integer getEndtime(){return endtime;}

    private Integer contestid;
    private Integer examid;
    private String examname;
    private Integer g1id;
    private String g1name;
    private Integer g2id;
    private String g2name;
    private Integer starttime;
    private Integer endtime;
}
