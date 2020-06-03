package com.example.springboottest.module;

public class sqstudentanswer {
    public Integer getQid(){
        return qid;
    }
    public void setQid(Integer qid){
        this.qid = qid;
    }

    public String getQname(){
        return qname;
    }
    public void setQname(String qname){
        this.qname = qname;
    }

    public Integer getStudentid(){
        return studentid;
    }
    public void setStudentid(Integer studentid){
        this.studentid = studentid;
    }

    public String getAnswer(){
        return answer;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getStudentname(){
        return studentname;
    }
    public void setStudentname(String studentname){
        this.studentname = studentname;
    }

    public Integer getScore(){
        return score;
    }
    public void setScore(Integer score){
        this.score = score;
    }

    public Integer getMaxscore(){
        return maxscore;
    }
    public void setMaxscore(Integer maxscore){
        this.maxscore = maxscore;
    }

    public Integer getIscorrected(){
        return iscorrected;
    }
    public void setIscorrected(Integer iscorrected){
        this.iscorrected = iscorrected;
    }

    private Integer qid;
    private String qname;
    private Integer studentid;
    private String studentname;
    private String answer;
    private Integer score;
    private Integer maxscore;
    private Integer iscorrected;
}
