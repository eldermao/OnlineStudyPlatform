package com.example.springboottest.module;

public class subjectivequestion {
    public void setQid(Integer qid){this.qid = qid;}
    public Integer getQid(){return qid;}

    public void setQname(String qname){this.qname = qname;}
    public String getQname(){return qname;}

    public void setExamid(Integer examid){this.examid = examid;}
    public Integer getExamid(){return examid;}
    public void setScore(Integer score){this.score = score;}
    public Integer getScore(){return score;}

    private Integer qid;
    private String qname;
    private Integer examid;
    private Integer score;

}
